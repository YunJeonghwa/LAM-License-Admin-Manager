package com.project.lam.domain.license.mapper;

import com.project.lam.domain.license.dto.LicenseCreateDto;
import com.project.lam.domain.license.dto.LicenseCustomerDetailDto;
import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.dto.LicenseRatioDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LicenseMapper {
    int countLicensesStatus(String status);

    LicenseDashboardDto selectDashboardCounts();

    // 고객사 등록 3 : 고객사가 구매한 라이선스  등록
    void insertLicense(LicenseCreateDto licenseCreateDto);

    // 고객사 상세페이지 구매 라이선스 리스트 조회
    List<LicenseCustomerDetailDto> selectLicenseCustomerList(Long custNo, int size, int offset);

    int getLicenseCustomerCount(@Param("custNo") Long custNo);

    List<LicenseRatioDto> selectLicenseType();
}
