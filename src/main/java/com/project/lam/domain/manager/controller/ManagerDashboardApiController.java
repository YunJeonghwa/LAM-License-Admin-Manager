package com.project.lam.domain.manager.controller;

import com.project.lam.domain.license.dto.LicenseMonthlyChartDto;
import com.project.lam.domain.license.dto.LicenseRatioDto;
import com.project.lam.domain.license.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerDashboardApiController {

    private final LicenseService licenseService;

    // 자바스크립트에서 fetch('/api/license-stats')로 호출할 주소
    // /manager/dashboard : 라이선스타입비중 차트api
    @GetMapping("/api/license-stats")
    public List<LicenseRatioDto> getLicenseStatistics() {
        // DB에서 데이터 조회 후 반환
        return licenseService.getLicenseType();
    }

    // /manager/dashboard : 월별 라이선스 동향 차트api
    @GetMapping("/api/licenseMonthly-stats")
    public List<LicenseMonthlyChartDto> getMonthlyChart(){
        return licenseService.getLastSevenMonthStatus();
    }

}
