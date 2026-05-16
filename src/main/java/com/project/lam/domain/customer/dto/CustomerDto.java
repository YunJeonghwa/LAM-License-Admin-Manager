package com.project.lam.domain.customer.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {

    private Long custNo;              // CUST_NO
    private String custNm;            // CUST_NM
    private String businessNo;        // BUSINESS_NO
    private String custStatus;        // CUST_STATUS (ACTIVE / INACTIVE)
    private Long managerUserno;       // MANAGER_USERNO
    private LocalDateTime createDate; // CREATE_DATE
    private LocalDateTime updateDate; // UPDATE_DATE
}

