package com.fivengers.blooming.project_application.adapter.out.persistence.mapper;


import com.fivengers.blooming.project_application.adapter.out.persistence.entity.PolicyInfoJpaEntity;
import com.fivengers.blooming.project_application.domain.PolicyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PolicyInfoMapper {

    public PolicyInfo toDomain(PolicyInfoJpaEntity policyInfo) {

        return new PolicyInfo(
                policyInfo.getServiceAgreement(),
                policyInfo.getRefundAgreement());
    }

    public PolicyInfoJpaEntity toInJpaEntity(PolicyInfo policyInfo) {

        return new PolicyInfoJpaEntity(
                policyInfo.getServiceAgreement(),
                policyInfo.getRefundAgreement());
    }
}
