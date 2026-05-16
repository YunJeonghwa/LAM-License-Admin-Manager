package com.project.lam.domain.license.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LicenseCreateDto{

    private Long licenseNo; //라이선스 번호
    private Long custNo; //고객 번호 (어떤 고객사가 구매했는지)
    private Long managerNo; //고객담당자 번호 (어떤 담당자 통해 구매했는지)
    private String licenseKey; //라이선스 key
    private LocalDate issueDate; //발행일
    private LocalDate expireDate; //만료일
    private int licenseCount; // 라이선스 수량
    private String licenseType; //라이선스 종류
    private String licenseMemo; // 특이사항

}
