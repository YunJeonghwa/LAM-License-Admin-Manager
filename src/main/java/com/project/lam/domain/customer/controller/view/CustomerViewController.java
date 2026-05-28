package com.project.lam.domain.customer.controller.view;

import com.project.lam.domain.customer.dto.*;
import com.project.lam.domain.customer.service.CustomerService;
import com.project.lam.domain.license.dto.LicenseCustomerDetailDto;
import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.enums.LicenseType;
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
    public String customerDetail(
            @RequestParam(defaultValue = "0") int historyPage,
            @RequestParam(defaultValue = "0") int licensePage,
            @PathVariable Long custNo,
            Model model) {

        // 페이징에 필요한 변수
        int size = 3; //한 페이지에 최대 10개

        // 점검이력, 라이선스 offset 각각
        // 페이지 * 사이즈 => 앞의 offset 만큼 버리고 데이터 가져오기
        int historyOffset = historyPage * size;
        int licenseOffset = licensePage * size;

        // 각각 count 필요
        int historyTotal = customerService.getInspectionHistoryCount(custNo);
        int licenseTotal = licenseService.getLicenseCustomerCount(custNo);

        int historyTotalPage = (int) Math.ceil((double) historyTotal / size);
        int licenseTotalPage = (int) Math.ceil((double) licenseTotal / size);


        // 라이선스 총 수량 화면 표시(sum)
        int totalLicenseCount = customerService.getCustomerDetailTotalCount(custNo);
        // System.out.println("CUSTNO : " + custNo);

        // 고객 기본 정보 및 라이선스 요약 조회(상단 카드)
        CustomerDetailResponse detail = customerService.getCustomerDetail(custNo);

        // 점검 이력 리스트 조회
        List<InspectionHistory> history = customerService.getInspectionHistory(custNo,size,historyOffset);

        // 고객사 라이선스 구매 리스트
        List<LicenseCustomerDetailDto> licenseList = licenseService.getLicenseCustomerList(custNo,size,licenseOffset);


        // 상위 카드 고객사 상세정보 model
        model.addAttribute("customer", detail);

        // 점검,라이선스 테이블 리스트 및 총 구매 라이선스 수량  model
        model.addAttribute("history", history); //점검이력
        model.addAttribute("licenseList",licenseList); //라이선스
        model.addAttribute("totalLicenseCount", totalLicenseCount); //라이선스구매수량

        // 페이징용
        model.addAttribute("historyPage", historyPage);
        model.addAttribute("licensePage", licensePage);

        model.addAttribute("historyTotalPage", historyTotalPage);
        model.addAttribute("licenseTotalPage", licenseTotalPage);

        return "customer/customer-detailData";
    }

    @GetMapping("/register")
    public String CustomerRegisterForm(Model model){

        model.addAttribute("customerRequestDto",new CustomerRequestDto()); //라이선스 구매 고객사 등록(form)
        model.addAttribute("licenseTypes", LicenseType.values());
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
