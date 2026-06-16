package com.project.lam.domain.license.dto;

import com.project.lam.domain.license.enums.LicenseType;
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
public class LicenseListResponseDto {

    //대쉬보드 고객사 라이선스만료 테이블리스트
    private Long licenseNo; //라이선스 번호
    private Long custNo; //고객 번호 (어떤 고객사가 구매했는지)
    private String custNm; //고객사명
    private String licenseKey; //라이선스 key
    private OffsetDateTime issueDate; //발행일
    private OffsetDateTime expiredDate; //만료일
    private int licenseCount; // 라이선스 수량
    private LicenseType licenseType; // // enum 라이선스 타입

}
