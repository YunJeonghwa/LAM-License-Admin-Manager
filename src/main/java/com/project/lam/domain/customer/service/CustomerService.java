package com.project.lam.domain.customer.service;

import com.project.lam.domain.customer.dto.CustomerListResponse;
import com.project.lam.domain.customer.dto.InspectionListResponse;
import com.project.lam.domain.customer.dto.InspectionSummaryResponse;
import com.project.lam.domain.customer.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;

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

    /*public List<InspectionPlanResponse> getInspectionPlanList() {
        return customerMapper.selectInspectionPlanList();
    }*/
}
