package com.project.lam.domain.license.service;

import com.project.lam.domain.license.dto.*;
import com.project.lam.domain.license.mapper.LicenseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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

    public List<LicenseMonthlyChartDto> getLastSevenMonthStatus() {

        // 1. 최근 7개월 틀 생성 (Key: YearMonth)
        Map<YearMonth, LicenseMonthlyChartDto> chartDataMap = new LinkedHashMap<>();

        YearMonth currentMonth = YearMonth.now();

        for (int i = 6; i >= 0; i--) {
            YearMonth targetMonth = currentMonth.minusMonths(i);

            chartDataMap.put(
                    targetMonth,
                    new LicenseMonthlyChartDto(
                            targetMonth.getMonthValue() + "월",
                            0,
                            0
                    )
            );
        }

        // 2. DB 조회
        List<Map<String, Object>> dbResultList = licenseMapper.findRawLicenseCounts();

        // 3. 매핑
        for (Map<String, Object> row : dbResultList) {

            String dbMonth = String.valueOf(row.get("month")); // ✅ 안전한 캐스팅
            YearMonth ym = YearMonth.parse(dbMonth);

            if (chartDataMap.containsKey(ym)) {
                // ✅ null 방어 추가
                int newReg = row.get("new_count") != null ? ((Number) row.get("new_count")).intValue() : 0;
                int exp    = row.get("exp_count") != null ? ((Number) row.get("exp_count")).intValue() : 0;

                chartDataMap.put(
                        ym,
                        new LicenseMonthlyChartDto(ym.getMonthValue() + "월", newReg, exp)
                );
            }
        }

        return new ArrayList<>(chartDataMap.values());
    }

    public List<LicenseListResponseDto> getDashboardExpireList(int offset, int size) {
        return licenseMapper.selectExpiredLicenseList(offset, size);
    }

    public int getExpiredTotalCount() {
        return licenseMapper.selectExpiredCounts();
    }
}
