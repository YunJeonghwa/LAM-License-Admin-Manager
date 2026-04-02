package com.project.lam.domain.customer.mapper;

import com.project.lam.domain.customer.dto.CustomerDetailDto;
import com.project.lam.domain.customer.dto.CustomerInspectionDto;
import com.project.lam.domain.customer.dto.InspectionCountDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<CustomerDetailDto> selectManagerDataList();

    List<CustomerInspectionDto> selectManagerInspectionList();

    InspectionCountDto selectInspectionCount();

    List<CustomerInspectionDto> selectCustomerInspectionPlanList();
}
