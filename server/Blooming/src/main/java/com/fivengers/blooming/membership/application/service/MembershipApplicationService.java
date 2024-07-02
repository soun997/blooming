package com.fivengers.blooming.membership.application.service;

import static com.fivengers.blooming.membership.consts.ContractProperties.ANTI_BOT_INTERVAL;
import static com.fivengers.blooming.membership.consts.ContractProperties.MINT_INDEX_FOR_SALE;
import static com.fivengers.blooming.membership.consts.ContractProperties.MINT_START_BLOCK_NUMBER;

import com.fivengers.blooming.admin.application.port.in.AdminMembershipApplicationUseCase;
import com.fivengers.blooming.artist.application.port.out.ArtistPort;
import com.fivengers.blooming.artist.domain.Artist;
import com.fivengers.blooming.global.exception.artist.ArtistNotFoundException;
import com.fivengers.blooming.global.exception.membership.MembershipApplicationNotFoundException;
import com.fivengers.blooming.membership.application.port.in.MembershipApplicationUseCase;
import com.fivengers.blooming.membership.application.port.in.dto.MembershipApplyRequest;
import com.fivengers.blooming.membership.application.port.out.ContractPort;
import com.fivengers.blooming.membership.application.port.out.MembershipApplicationPort;
import com.fivengers.blooming.membership.application.port.out.MembershipPort;
import com.fivengers.blooming.membership.consts.ContractProperties;
import com.fivengers.blooming.membership.domain.Membership;
import com.fivengers.blooming.membership.domain.MembershipApplication;
import com.fivengers.blooming.membership.domain.MembershipApplicationState;
import com.fivengers.blooming.membership.domain.NftSale;
import com.klaytn.caver.contract.Contract;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MembershipApplicationService
        implements MembershipApplicationUseCase, AdminMembershipApplicationUseCase {

    private final ContractProperties contractProperties;
    private final MembershipApplicationPort membershipApplicationPort;
    private final MembershipPort membershipPort;
    private final ContractPort contractPort;
    private final ArtistPort artistPort;

    @Override
    public MembershipApplication add(MembershipApplyRequest request, Long memberId) {

        Artist artist = artistPort.findByMemberId(memberId)
                .orElseThrow(ArtistNotFoundException::new);
        int currentSeason = membershipPort.findLatestSeasonByArtistId(artist.getId()) + 1;
        return membershipApplicationPort.save(
                request.toDomain(currentSeason, artist));
    }

    @Override
    public List<MembershipApplication> searchAllByMemberIdAndApplicationState(
            Long memberId, MembershipApplicationState applicationState) {
        return membershipApplicationPort
                .findByMemberIdAndApplicationState(memberId, applicationState);
    }

    @Override
    public Page<MembershipApplication> searchAll(
            Pageable pageable, MembershipApplicationState applicationState) {
        return membershipApplicationPort.findByApplicationState(pageable, applicationState);
    }

    @Override
    @Transactional
    public MembershipApplication modifyStateById(
            MembershipApplicationState applicationState, Long applicationId) {
        MembershipApplication application = membershipApplicationPort.findById(
                        applicationId)
                .orElseThrow(MembershipApplicationNotFoundException::new);
        application.changeState(applicationState);

        MembershipApplication updatedApplication = membershipApplicationPort.update(application);
        if (applicationState.equals(MembershipApplicationState.APPROVAL)) {
            addMembership(updatedApplication);
        }
        return updatedApplication;
    }

    private void addMembership(MembershipApplication application) {

        String contractAddress =
                mintMembershipNft(
                        application.getTitle(),
                        application.getTitle().toUpperCase(),
                        application.getSaleCount(),
                        application.getSalePrice());
        membershipPort.save(Membership.builder()
                .title(application.getTitle())
                .symbol(application.getTitle().toUpperCase())
                .description(application.getDescription())
                .season(application.getSeason())
                .seasonStart(application.getSeasonStart())
                .seasonEnd(application.getSeasonEnd())
                .purchaseStart(application.getPurchaseStart())
                .purchaseEnd(application.getPurchaseEnd())
                .saleCount(application.getSaleCount())
                .salePrice(application.getSalePrice())
                .imageUrl(application.getImageUrl())
                .contractAddress(contractAddress)
                .artist(application.getArtist())
                .nftSale(NftSale.builder()
                        .totalNftCount(application.getSaleCount())
                        .soldNftCount(0L)
                        .totalNftAmount(
                                application.getSaleCount() * application.getSalePrice())
                        .soldNftAmount(0L)
                        .build())
                .build());
    }

    private String mintMembershipNft(
            String title, String symbol, Long saleCount, Long salePrice) {

        Contract deployedContract = contractPort.deployContract(title, symbol);
        String baseUri = contractProperties.metadataUrl + title + "/";
        log.info("baseUri: {}", baseUri);
        contractPort.setBaseUri(deployedContract, baseUri);
        contractPort.reveal(deployedContract);
        Long mintLimitPerBlock = saleCount;
        Long mintLimitPerSale = saleCount;
        contractPort.setupSale(
                deployedContract,
                ANTI_BOT_INTERVAL,
                mintLimitPerBlock,
                mintLimitPerSale,
                MINT_START_BLOCK_NUMBER,
                MINT_INDEX_FOR_SALE,
                mintLimitPerBlock,
                BigDecimal.valueOf(salePrice));
        contractPort.setPublicMintEnabled(deployedContract);
        contractPort.publicMint(deployedContract, saleCount);
        return deployedContract.getContractAddress();
    }
}
