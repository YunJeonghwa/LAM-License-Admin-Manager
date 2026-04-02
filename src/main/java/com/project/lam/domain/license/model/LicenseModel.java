package com.project.lam.domain.license.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class LicenseModel {

    private Long id;                // PK
    private Long customerId;         // 고객사 ID
    private String licenseKey;       // 라이선스 키
    private int quantity;            // 수량
    private LocalDate issuedDate;     // 발급일
    private LocalDate expireDate;     // 만료일
    private String status;            // ACTIVE / EXPIRED / DISABLED

}
