package com.project.lam.domain.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreateDto {

    private Long custNo;              // 고객번호
    private String custNm;            // 고객사명
    private String businessNo;        // 사업자번호
    private String custCeoNm;         // 대표명
    private String address;           // 주소
}
