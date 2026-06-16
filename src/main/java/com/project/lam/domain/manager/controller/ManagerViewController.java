package com.project.lam.domain.manager.controller;

import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.dto.LicenseListResponseDto;
import com.project.lam.domain.license.service.LicenseService;
import com.project.lam.domain.manager.service.ManagerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerViewController {

    private final ManagerService managerService;

    private final LicenseService licenseService;

    @GetMapping("/dashboard")
    public String dashboardView(@RequestParam(defaultValue = "0") int page, Model model) {

        // dashboard 상단 라이선스 수량 조회
        LicenseDashboardDto dashboard = licenseService.getDashboardCounts();
        model.addAttribute("dashboard", dashboard);

        // 페이징 : 라이선스 만료 고객사
        int size = 5; // 페이지당 10개
        int offset = page * size;

        //전체 만료 라이선스 개수 & 전체 페이지 수
        int totalCount = licenseService.getExpiredTotalCount();
        int totalPages = (int) Math.ceil((double) totalCount / size);

        // dashboard 하단 라이선스 만료 고객사 리스트조회
        List<LicenseListResponseDto> expiredLicenseList = licenseService.getDashboardExpireList(offset,size);

        model.addAttribute("expiredLicenseList",expiredLicenseList); //라이선스만료 고객사 리스트
        model.addAttribute("totalCount", totalCount); //페이징 : 전체라이선스만료 고객사
        model.addAttribute("currentPage", page); // 페이징 : 현제 페이지
        model.addAttribute("totalPages", totalPages); // 페이징 : 전체 페이지


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