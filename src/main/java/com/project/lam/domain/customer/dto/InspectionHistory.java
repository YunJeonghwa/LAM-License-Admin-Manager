package com.project.lam.domain.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InspectionHistory {
    private String inspectionDate; // 점검일자
    private String inspectorName;  // 담당자
    private String status;         // 완료 / 미완료
}
