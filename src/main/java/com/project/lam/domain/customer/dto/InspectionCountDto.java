package com.project.lam.domain.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InspectionCountDto {

    private int totalInspectionCount; // 유지보수 고객사
    private int scheduledInspectionCount; // 이번달 예정
    private int completedInspectionCount; // 이번달 완료
    private int expiringLicenseCount;     // 만료 예정
}
