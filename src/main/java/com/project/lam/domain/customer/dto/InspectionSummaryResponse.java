package com.project.lam.domain.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InspectionSummaryResponse {
    private int totalInspectionCount;
    private int scheduledInspectionCount;
    private int completedInspectionCount;
    private int expiringLicenseCount;
}