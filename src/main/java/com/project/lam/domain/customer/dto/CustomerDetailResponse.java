package com.project.lam.domain.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailResponse {

    private Long customerNo;           // 수정 버튼에서 사용
    private String customerNm;         // 고객명

    private String businessNo;         // 사업자번호
    private String managerName;        // 담당자
    private String managerPhone;       // 연락처

    private String lastInspectionDate; // 최근 점검일
    private Integer totalLicenseCount; // 라이선스 수량
    private String expiryDate;         // 만료일

    private String memo;               // 특이사항

}
