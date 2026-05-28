package com.project.lam.domain.manager.controller;

import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.service.LicenseService;
import com.project.lam.domain.manager.service.ManagerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerViewController {

    private final ManagerService managerService;

    private final LicenseService licenseService;

    @GetMapping("/dashboard")
    public String dashboardView(Model model) {

        // dashboard 상단 라이선스 수량 조회
        LicenseDashboardDto dashboard = licenseService.getDashboardCounts();
        model.addAttribute("dashboard", dashboard);

        return "manager/dashboard";
    }

    @GetMapping("/register")
    public String managerRegister(){
        return "manager/register";
    }

    @GetMapping("/{id}")
    public String managerDetail(@PathVariable String id, Model model){
        model.addAttribute("manager", managerService.getById(id));

        return "manager/detail";
    }

    @GetMapping("/login")
    public String managerLogin(){
        return "manager/login";
    }

    //로그아웃은 spring security로 변경
    @GetMapping("/logout")
    public String managerLogout(HttpSession session){
        session.invalidate();
        return "redirect:/manager/login";
    }






}