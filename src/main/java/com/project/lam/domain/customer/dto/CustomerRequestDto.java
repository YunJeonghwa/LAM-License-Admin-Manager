package com.project.lam.domain.customer.dto;

import com.project.lam.domain.license.dto.LicenseCreateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    private CustomerCreateDto customerCreateDto;
    private CustomerManagerCreateDto customerManagerCreateDto;
    private LicenseCreateDto  licenseCreateDto;

    // 판별 값들
    private boolean isNewCustomer; // 신규 고객사 여부
    private boolean isNewManager;  // 신규 담당자 여부

    private Long selectedCustNo;   // 기존 고객사 선택 시 번호
    private Long selectedManagerNo;// 기존 담당자 선택 시 번호
}
