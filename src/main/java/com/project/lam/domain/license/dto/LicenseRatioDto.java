package com.project.lam.domain.license.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LicenseRatioDto {

    private String licenseType;
    private int count;
}
