package com.project.lam.domain.manager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Manager{

    private Long managerUserNo;
    private String userName;
    private String id;
    private String pw;
    private String role;
    private OffsetDateTime createDate;
    private OffsetDateTime updateDate;

}
