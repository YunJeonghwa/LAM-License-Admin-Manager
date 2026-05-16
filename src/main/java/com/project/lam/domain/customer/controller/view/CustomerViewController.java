package com.project.lam.domain.customer.controller.view;

import com.project.lam.domain.customer.dto.*;
import com.project.lam.domain.customer.service.CustomerService;
import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String customerDetail(@RequestParam(defaultValue = "0") int page, @PathVariable Long custNo, Model model) {

        // 페이징에 필요한 변수
        int size = 10; //한 페이지에 최대 10개
        int offset = page * size; // 페이지 * 사이즈 => 앞의 offset 만큼 버리고 데이터 가져오기

        // 페이징용
        //int totalCount = customerService.getCustomerLicenseRowCount(); // COUNT(*)
        //int totalPage = (int) Math.ceil((double) totalCount / size);

        // 라이선스 총 수량 화면 표시(sum)
        int totalLicenseCount = customerService.getCustomerDetailTotalCount(custNo);
        // System.out.println("CUSTNO : " + custNo);

        // 고객 기본 정보 및 라이선스 요약 조회
        CustomerDetailResponse detail = customerService.getCustomerDetail(custNo);
        // 점검 이력 리스트 조회
        List<InspectionHistory> history = customerService.getInspectionHistory(custNo);



        model.addAttribute("customer", detail);
        model.addAttribute("historyList", history);
        model.addAttribute("totalLicenseCount", totalLicenseCount);
        return "customer/customer-detailData";
    }

    @GetMapping("/register")
    public String CustomerRegisterForm(Model model){

        model.addAttribute("customerRequestDto",new CustomerRequestDto()); //라이선스 구매 고객사 등록(form)
        return "customer/customer-register";
    }

    @PostMapping("/register")
    public String CustomerRegisterSave(@ModelAttribute CustomerRequestDto request){

        // 여기서 바로 찍어보세요!
        System.out.println("newCustomer 값: " + request.isNewCustomer());
        System.out.println("newManager 값: " + request.isNewManager());

        customerService.customerRegisterSave(request);

        return "redirect:/customer/detail";
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
