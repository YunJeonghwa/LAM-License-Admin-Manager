package com.project.lam.domain.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailDto {

    private Long customerNo;                 // 상세보기용
    private String customerNm;               // 고객명
    private String businessNo;           // 고객번호 (사업자번호)
    private String managerName;          // 고객 담당자
    private OffsetDateTime lastInspectionDate; // 최근 점검일
    private Integer totalLicenseCount;   // 구매 라이선스 수량

}
