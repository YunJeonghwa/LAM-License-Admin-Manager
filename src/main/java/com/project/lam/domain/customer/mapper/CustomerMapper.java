package com.project.lam.domain.customer.mapper;

import com.project.lam.domain.customer.dto.*;
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

    // 고객사 상세 정보 조회(고객사 번호로)
    CustomerDetailResponse selectCustomerDetailSummary(Long custNo);

    // 고객사 정기점검 상세 정보 조회(고객사 번호로)
    List<InspectionHistory> selectCustomerInspectionHistory(
            @Param("custNo") Long custNo,
            @Param("size") int size,
            @Param("offset") int offset
    );

    // 특정 고객사 라이선스 전체 수량 조회
    int getCustomerLicenseTotalCount(Long custNo);

    // 고객사 등록1 : 고객사등록
    void insertCustomer(CustomerCreateDto customerCreateDto);

    // 고객사 등록 2 : 고객사 담당자 등록
    void insertCustomerManager(CustomerManagerCreateDto customerManagerCreateDto);

    int getInspectionHistoryCount(@Param("custNo") Long custNo);


    // 점검 계획 목록 조회
    //List<InspectionPlanResponse> selectInspectionPlanList();
}
