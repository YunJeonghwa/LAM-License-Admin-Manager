package com.project.lam.domain.license.controller;

import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class LicenseDashboardController {

   /* private final LicenseService licenseService;

    @GetMapping("/dashboard")
    public String dashboardView(Model model) {

        // dashboard 상단 라이선스 수량 조회
        LicenseDashboardDto dashboard = licenseService.getDashboardCounts();
        model.addAttribute("dashboard", dashboard);

        return "manager/dashboard";
    }*/

}
