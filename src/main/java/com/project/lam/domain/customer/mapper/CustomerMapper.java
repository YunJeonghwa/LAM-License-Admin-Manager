package com.project.lam.domain.customer.mapper;

import com.project.lam.domain.customer.dto.CustomerListResponse;
import com.project.lam.domain.customer.dto.InspectionListResponse;
import com.project.lam.domain.customer.dto.InspectionSummaryResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {

    // 고객 목록 조회
    List<CustomerListResponse> selectCustomerList(@Param("offset") int offset,@Param("size") int size);

    // 고객사 수 전체 조회
    int getCustomerTotalCount();

    // 점검 현황 목록 조회
    List<InspectionListResponse> selectInspectionList();

    // 점검 집계 조회 (대시보드)
    InspectionSummaryResponse selectInspectionSummary();



    // 점검 계획 목록 조회
    //List<InspectionPlanResponse> selectInspectionPlanList();
}
