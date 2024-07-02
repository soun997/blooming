package com.fivengers.blooming.membership.adapter.out.persistence;

import static com.fivengers.blooming.config.contract.KIP17BloomingToken.ABI_JSON;
import static com.fivengers.blooming.config.contract.KIP17BloomingToken.BYTE_CODE;
import static com.fivengers.blooming.membership.consts.ContractProperties.DEPLOY_VALUE;
import static com.fivengers.blooming.membership.consts.ContractProperties.GAS_LIMIT;

import com.fivengers.blooming.global.exception.artist.ArtistNotFoundException;
import com.fivengers.blooming.membership.application.port.out.ContractPort;
import com.klaytn.caver.Caver;
import com.klaytn.caver.contract.Contract;
import com.klaytn.caver.contract.ContractDeployParams;
import com.klaytn.caver.contract.SendOptions;
import com.klaytn.caver.methods.response.Bytes32;
import com.klaytn.caver.methods.response.TransactionReceipt.TransactionReceiptData;
import com.klaytn.caver.transaction.AbstractTransaction;
import com.klaytn.caver.transaction.response.PollingTransactionReceiptProcessor;
import com.klaytn.caver.transaction.response.TransactionReceiptProcessor;
import com.klaytn.caver.wallet.keyring.AbstractKeyring;
import com.klaytn.caver.wallet.keyring.KeyringFactory;
import java.io.IOException;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContractAdapter implements ContractPort {

    private final Caver caver;

    private final AbstractKeyring publisherKeyring;

    @Autowired
    public ContractAdapter(
            Caver caver,
            @Value("${klaytn.wallet-private-key}") String walletPrivateKey) {
        this.caver = caver;
        this.publisherKeyring = KeyringFactory.createFromPrivateKey(walletPrivateKey);
        if (!caver.wallet.isExisted(publisherKeyring.getAddress())) {
            caver.wallet.add(publisherKeyring);
        }
    }

    @Override
    public Contract deployContract(String title, String symbol) {

        ContractDeployParams params = generateDeployParams(title, symbol);
        SendOptions options = generateSendOptions();

        Contract contract = createContract();
        try {
            contract.deploy(params, options);
        } catch (Exception e) {
            throw new ArtistNotFoundException();
        }
        contract.setDefaultSendOptions(options);
        printContractMethods(contract);
        return contract;
    }

    @Override
    public void setBaseUri(Contract contract, String baseUri) {
        executeTransaction("setBaseURI", contract, baseUri);
    }

    @Override
    public void reveal(Contract contract) {
        executeTransaction("reveal", contract, true);
    }

    @Override
    public void setupSale(
            Contract contract,
            Long newAntiBotInterval,   // 봇 독점 방지 (minting interval)
            Long newMintLimitPerBlock,  // 한 번의 트랜잭션에서 최대로 민팅할 수 있는 양
            Long newMintLimitPerSale,   // 한 계정당 가질 수 있는 NFT 개수 제한
            Long newMintStartBlockNumber,   // 민팅을 시작할 수 있는 블록 높이
            Long newMintIndexForSale,   // 발행할 NFT 토큰 번호의 시작 index
            Long newMaxSaleAmount,
            BigDecimal newMintPrice) {
        executeTransaction("setupSale", contract,
                newAntiBotInterval,
                newMintLimitPerBlock,
                newMintLimitPerSale,
                newMintStartBlockNumber,
                newMintIndexForSale,
                newMaxSaleAmount,    // 최대 몇 개의 NFT를 발행할 지
                caver.utils.convertToPeb(newMintPrice, "KLAY"));    // NFT 하나의 가격
    }

    @Override
    public void setPublicMintEnabled(Contract contract) {
        executeTransaction("setPublicMintEnabled", contract, true);
    }

    @Override
    public void publicMint(Contract contract, Long requestedCount) {
        executeTransaction("publicMint", contract, requestedCount);
    }

    @Override
    public void transferFrom(Contract contract, String from, String to, Long tokenId) {

        executeTransaction("transferFrom", contract, from, to, tokenId);
    }

    private void executeTransaction(String method, Contract contract, Object... args) {
        try {
            AbstractTransaction signedTx = contract.sign(generateSendOptions(), method, args);
            Bytes32 txHash = caver.rpc.klay.sendRawTransaction(signedTx).send();
            if (txHash.hasError()) {
                throw new ArtistNotFoundException();
            }
            TransactionReceiptProcessor receiptProcessor =
                    new PollingTransactionReceiptProcessor(caver, 1000, 15);
            TransactionReceiptData receipt =
                    receiptProcessor.waitForTransactionReceipt(txHash.getResult());
            printReceipt(receipt);
        } catch (Exception e) {
            throw new ArtistNotFoundException();
        }
    }

    private Contract createContract() {

        try {
            return caver.contract.create(ABI_JSON);
        } catch (IOException e) {
            throw new ArtistNotFoundException();
        }
    }

    private Contract createContractByContractAddress(String contractAddress) {
        try {
            return caver.contract.create(ABI_JSON, contractAddress);
        } catch (IOException e) {
            throw new ArtistNotFoundException();
        }
    }

    private SendOptions generateSendOptions() {

        return new SendOptions(publisherKeyring.getAddress(), GAS_LIMIT, DEPLOY_VALUE);
    }

    private ContractDeployParams generateDeployParams(String name, String symbol) {

        return new ContractDeployParams(BYTE_CODE, name, symbol);
    }

    private void printContractMethods(Contract contract) {

        contract.getMethods().forEach((name, method) -> {
            log.debug("type: {} | name: {}", method.getType(), name);
        });
    }

    private void printReceipt(TransactionReceiptData receipt) {

        log.debug("========== TX Receipt ==========");
        log.debug("contractAddress: {}", receipt.getContractAddress());
        log.debug("status: {}", receipt.getStatus());
        log.debug("input: {}", receipt.getInput());
        log.debug("type: {}", receipt.getType());
        log.debug("codeFormat: {}", receipt.getCodeFormat());
        log.debug("blockHash: {}", receipt.getBlockHash());
        log.debug("blockNumber: {}", receipt.getBlockNumber());
        log.debug("from: {}", receipt.getFrom());
        log.debug("to: {}", receipt.getTo());
        log.debug("gas: {}", receipt.getGas());
        log.debug("gasPrice: {}", receipt.getGasPrice());
        log.debug("gasUsed: {}", receipt.getGasUsed());
        log.debug("effectiveGasPrice: {}", receipt.getEffectiveGasPrice());
        log.debug("key: {}", receipt.getKey());
        log.debug("value: {}", receipt.getValue());
        log.debug("================================");
    }
}
