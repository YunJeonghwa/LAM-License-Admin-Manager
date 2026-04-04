package com.project.lam.domain.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerListResponse {
    private Long customerNo;          // CUST_NO
    private String customerNm;        // CUST_NM
    private String businessNo;        // BUSINESS_NO
    private String managerName;       // 담당자명
    private OffsetDateTime lastInspectionDate;  // 최근 점검일
    private Integer totalLicenseCount;          // 라이선스 수량
}
