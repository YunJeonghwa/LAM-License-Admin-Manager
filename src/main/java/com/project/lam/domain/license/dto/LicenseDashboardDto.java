package com.project.lam.domain.license.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LicenseDashboardDto {

    private int totalLicenses;        // 전체 라이선스 수
    private int activeLicenses;       // 활성 라이선스
    private int expiringSoonLicenses; // 30일 이내 만료

}

