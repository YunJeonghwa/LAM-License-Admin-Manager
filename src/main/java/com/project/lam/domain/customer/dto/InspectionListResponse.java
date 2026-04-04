package com.project.lam.domain.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InspectionListResponse {

    private Long inspectionNo;
    private Long customerNo;
    private String customerNm;
    private String customerManagerNm;
    private String customerTel;
    private String customerEm;
    private String inspectorName;
    private String resultStatus;
    private OffsetDateTime nextInspectionDate;
    private OffsetDateTime expireDate;        // expiredInspectionDate → expireDate로 통일
}
