package com.project.lam.domain.license.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LicenseMonthlyChartDto {

    private String month;   // x축 : month(1월,2월....)
    private int newRegisterCount;  //파란색 막대(+) 신규 가입
    private int expirationCount;   // 분홍색 막대 (+) 만료

    public LicenseMonthlyChartDto(String month, int newReg, int exp) {
        this.month = month;
        this.newRegisterCount = newReg;
        this.expirationCount = exp > 0 ? -exp : exp;
    }
}
