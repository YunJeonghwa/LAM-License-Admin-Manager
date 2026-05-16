package com.project.lam.domain.customer.service;

import com.project.lam.domain.customer.dto.*;
import com.project.lam.domain.customer.mapper.CustomerMapper;
import com.project.lam.domain.license.dto.LicenseCreateDto;
import com.project.lam.domain.license.mapper.LicenseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final LicenseMapper licenseMapper;

    public List<CustomerListResponse> getCustomerList(int  offset, int size) {
        return customerMapper.selectCustomerList(offset,size);
    }
    public int getCustomerTotalCount() {
        return customerMapper.getCustomerTotalCount();
    }

    public InspectionSummaryResponse getInspectionSummary() {
        return customerMapper.selectInspectionSummary();
    }

    public List<InspectionListResponse> getInspectionList() {
        return customerMapper.selectInspectionList();
    }

    public CustomerDetailResponse getCustomerDetail(Long custNo) { return customerMapper.selectCustomerDetailSummary(custNo);
    }

    public List<InspectionHistory> getInspectionHistory(Long custNo) { return customerMapper.selectCustomerInspectionHistory(custNo);
    }

    public int getCustomerDetailTotalCount(Long custNo) {return customerMapper.getCustomerLicenseTotalCount(custNo);
    }

    @Transactional
    public void customerRegisterSave(CustomerRequestDto request) {

        Long custNo;
        Long managerNo;

        // 1. 고객사 처리
        if (request.isNewCustomer()) {
            CustomerCreateDto customerDto = request.getCustomerCreateDto();
            customerMapper.insertCustomer(customerDto);
            custNo = customerDto.getCustNo(); // 신규 생성된 ID
            request.setNewManager(true);
        } else {
            custNo = request.getSelectedCustNo(); // 기존 선택된 ID
        }

        // 2. 담당자 처리
        if (request.isNewManager()) {
            CustomerManagerCreateDto managerDto = request.getCustomerManagerCreateDto();
            managerDto.setCustNo(custNo);
            customerMapper.insertCustomerManager(managerDto); // 매퍼에는 이제 ManagerDto만 전달!
           // managerDto.setCustNo(custNo); // 소속 고객사 번호 지정
            managerNo = managerDto.getManagerNo(); // 신규 생성된 ID
        } else {
            managerNo = request.getSelectedManagerNo(); // 기존 선택된 ID
        }

        // 3. 라이선스 처리
        LicenseCreateDto licenseDto = request.getLicenseCreateDto();
        licenseDto.setCustNo(custNo);
        licenseDto.setManagerNo(managerNo);

        // 💡 [디버깅 추가] DB에 넣기 직전에 값 확인하기!
        System.out.println("====== [디버깅] ======");
        System.out.println("isNewCustomer? : " + request.isNewCustomer());
        System.out.println("넣으려는 custNo : " + custNo);
        System.out.println("넣으려는 managerNo : " + managerNo);
        System.out.println("======================");

        licenseMapper.insertLicense(licenseDto);

       /* // 1. customer 데이터 저장
        CustomerCreateDto customerCreateDto = request.getCustomerCreateDto();
        customerMapper.insertCustomer(customerCreateDto);
        Long custNo = customerCreateDto.getCustNo();

        // 2. 고객 담당자 데이터 저장
        Long managerNo;

        LicenseCreateDto licenseCreateDto = request.getLicenseCreateDto();
        if(request.isNewManager()){

            licenseCreateDto manager = request.getlicenseCreateDto();
            manager.setCustNo(custNo);

            customerMapper.insertManager(customerCreateDto);
            customerCreateDto.setManagerNo(customerCreateDto.getManagerNo());
        }else{
            managerNo = request.getManagerNo(); // 기존 담당자 선택
        }
        customerCreateDto.setCustNo(custNo);
        customerMapper.insertCustomerManager(customerCreateDto);

        // 3. 라이선스 데이터 저장

        licenseCreateDto.setCustNo(custNo);
        licenseMapper.insertLicense(licenseCreateDto);
        Long licenseNo = licenseCreateDto.getLicenseNo();*/
    }

}
