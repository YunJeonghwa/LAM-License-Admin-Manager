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
public class CustomerInspectionDto {

    private Long inspectionNo;
    private Long customerNo;

    private String customerNm;        // 고객사명

    private String customerManagerNm; // 고객 담당자
    private String customerTel;       // 담당자 연락처
    private String customerEm;        // 담당자 이메일

    private String inspectorName;     // 점검 담당자


    private String resultStatus;      // 점검 결과

    private OffsetDateTime nextInspectionDate;
    private OffsetDateTime expireDate; // 유지보수 만료일
 }
