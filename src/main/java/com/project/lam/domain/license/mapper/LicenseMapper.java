package com.project.lam.domain.license.mapper;

import com.project.lam.domain.license.dto.LicenseDashboardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LicenseMapper {
    int countLicensesStatus(String status);

    LicenseDashboardDto selectDashboardCounts();

}
