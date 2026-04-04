package com.project.lam.domain.customer.controller.view;

import com.project.lam.domain.customer.dto.CustomerListResponse;
import com.project.lam.domain.customer.dto.InspectionListResponse;
import com.project.lam.domain.customer.dto.InspectionSummaryResponse;
import com.project.lam.domain.customer.service.CustomerService;
import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerViewController {

    private final CustomerService customerService;
    private final LicenseService licenseService;

    @GetMapping("/detail")
    public String CustomerDetail(Model model){

        // 전체 유지보수 고객사 정보 조회
        List<CustomerListResponse> customerData = customerService.getCustomerList();
        model.addAttribute("customerData",customerData);

        // dashboard 상단 라이선스 수량 조회
        LicenseDashboardDto dashboard = licenseService.getDashboardCounts();
        model.addAttribute("dashboard", dashboard);

        // 정기점검 고객사 수량 조회
        InspectionSummaryResponse inspectionCount = customerService.getInspectionSummary();
        model.addAttribute("inspectionCount",inspectionCount);

        System.out.println(inspectionCount);

        return "customer/customer-detail";
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
