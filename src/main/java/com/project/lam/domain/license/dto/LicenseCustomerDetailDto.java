package com.project.lam.domain.license.dto;

import com.project.lam.domain.license.enums.LicenseType;
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
public class LicenseCustomerDetailDto {

    private Long custNo;
    private String licenseKey;
    private LicenseType licenseType;
    private Long licenseCount;
    private String licenseStatus;
    private OffsetDateTime expireDate;

}
