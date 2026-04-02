package com.project.lam.domain.customer.service;

import com.project.lam.domain.customer.dto.CustomerDetailDto;
import com.project.lam.domain.customer.dto.CustomerInspectionDto;
import com.project.lam.domain.customer.dto.InspectionCountDto;
import com.project.lam.domain.customer.mapper.CustomerMapper;
import com.project.lam.domain.manager.mapper.ManagerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;

    public List<CustomerDetailDto> getCustomerData() {
        return customerMapper.selectManagerDataList();
    }

    public InspectionCountDto getInspectionCount(){
        return customerMapper.selectInspectionCount();
    }

   public List<CustomerInspectionDto> getInspectionListData(){
        return customerMapper.selectManagerInspectionList();
    }

    public List<CustomerInspectionDto> getMonthInspection() {return customerMapper.selectCustomerInspectionPlanList();}
}
