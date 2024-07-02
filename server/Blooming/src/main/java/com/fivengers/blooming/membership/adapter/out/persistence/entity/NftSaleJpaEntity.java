package com.fivengers.blooming.membership.adapter.out.persistence.entity;

import com.fivengers.blooming.global.audit.BaseTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "nft_sale")
@Getter
@Where(clause = "deleted = false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NftSaleJpaEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nft_sale_id")
    private Long id;

    @Column(nullable = false)
    private Long totalNftCount;

    @Column(nullable = false)
    private Long soldNftCount;

    @Column(nullable = false)
    private Long totalNftAmount;

    @Column(nullable = false)
    private Long soldNftAmount;

    @Column(nullable = false)
    private Boolean deleted;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "membership_id")
    private MembershipJpaEntity membershipJpaEntity;

    @Builder
    public NftSaleJpaEntity(
            Long id,
            Long totalNftCount,
            Long soldNftCount,
            Long totalNftAmount,
            Long soldNftAmount,
            Boolean deleted) {
        this.id = id;
        this.totalNftCount = totalNftCount;
        this.soldNftCount = soldNftCount;
        this.totalNftAmount = totalNftAmount;
        this.soldNftAmount = soldNftAmount;
        this.deleted = deleted;
    }

    public void setMembershipJpaEntity(MembershipJpaEntity membershipJpaEntity) {
        this.membershipJpaEntity = membershipJpaEntity;
    }
}
