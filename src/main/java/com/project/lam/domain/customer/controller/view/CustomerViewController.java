package com.project.lam.domain.customer.controller.view;

import com.project.lam.domain.customer.dto.*;
import com.project.lam.domain.customer.service.CustomerService;
import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.service.LicenseService;
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
@RequestMapping("/customer")
public class CustomerViewController {

    private final CustomerService customerService;
    private final LicenseService licenseService;

    @GetMapping("/detail")
    public String CustomerDetail(@RequestParam(defaultValue = "0") int page, Model model){

        //고객사 조회 테이블 페이징
        int size = 10; // 페이지당 10개
        int offset = page * size;

        // 전체 유지보수 고객사 정보 조회
        List<CustomerListResponse> customerData = customerService.getCustomerList(offset,size);

        //전체 개수
        int totalCount = customerService.getCustomerTotalCount();
        int totalPages = (int) Math.ceil((double) totalCount / size);

        model.addAttribute("customerData",customerData);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        // dashboard 상단 라이선스 수량 조회
        LicenseDashboardDto dashboard = licenseService.getDashboardCounts();
        model.addAttribute("dashboard", dashboard);

        // 정기점검 고객사 수량 조회
        InspectionSummaryResponse inspectionCount = customerService.getInspectionSummary();
        model.addAttribute("inspectionCount",inspectionCount);

        System.out.println(inspectionCount);

        return "customer/customer-detail";
    }

    @GetMapping("/detail/{custNo}")
    public String customerDetail(@PathVariable Long custNo, Model model) {
        // 1. 고객 기본 정보 및 라이선스 요약 조회
        CustomerDetailResponse detail = customerService.getCustomerDetail(custNo);
        // 2. 점검 이력 리스트 조회
        List<InspectionHistory> history = customerService.getInspectionHistory(custNo);

        model.addAttribute("customer", detail);
        model.addAttribute("historyList", history);
        return "customer/customer-detailData";
    }

    @GetMapping("/inspectionAll")
    public String customerInspectionAll(Model model){

        List<InspectionListResponse> inspectionCustomer = customerService.getInspectionList();
        model.addAttribute("inspectionCustomer",inspectionCustomer);
        System.out.println(inspectionCustomer);
        return "customer/customer-inspectionAll";
    }

    @GetMapping("/monthInspection")
    public String customerMonthInspection(Model model){

       // List<CustomerInspectionDto> monthInspection = customerService.getInspectionPlanList();
        List<InspectionListResponse> monthInspection = customerService.getInspectionList();
        model.addAttribute("monthInspection",monthInspection);

        return "customer/customer-inspectionMonth";

    }


}
