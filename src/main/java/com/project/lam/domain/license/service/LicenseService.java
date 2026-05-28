package com.project.lam.domain.license.service;

import com.project.lam.domain.license.dto.LicenseCustomerDetailDto;
import com.project.lam.domain.license.dto.LicenseDashboardDto;
import com.project.lam.domain.license.dto.LicenseRatioDto;
import com.project.lam.domain.license.mapper.LicenseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LicenseService {

    private final LicenseMapper licenseMapper;

    public LicenseDashboardDto getDashboardCounts() {
        return licenseMapper.selectDashboardCounts();
    }

    // 고객사 상세페이지 구매 라이선스 리스트 조회
    public List<LicenseCustomerDetailDto> getLicenseCustomerList(Long custNo,int size, int offset) {
        return licenseMapper.selectLicenseCustomerList(custNo,size,offset);
    }


    public int getLicenseCustomerCount(Long custNo) { return licenseMapper.getLicenseCustomerCount(custNo);}

    public List<LicenseRatioDto> getLicenseType() { return licenseMapper.selectLicenseType();}
}
