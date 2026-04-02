package com.project.lam.domain.license.service;

import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.mapper.LicenseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LicenseService {

    private final LicenseMapper licenseMapper;

    public LicenseDashboardDto getDashboardCounts() {
        return licenseMapper.selectDashboardCounts();
    }
}
