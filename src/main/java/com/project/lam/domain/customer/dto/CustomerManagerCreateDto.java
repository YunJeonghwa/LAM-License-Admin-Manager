package com.project.lam.domain.customer.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerManagerCreateDto {

    private Long custNo;              // 고객번호
    private Long managerNo;          //담당자 번호
    private String managerNm;        // 담당자이름
    private String managerEm;            // 담당자 이메일
    private String managerPhone;       // 담당자 연락처
    private String managerPosition;    // 담당자 직위

}
