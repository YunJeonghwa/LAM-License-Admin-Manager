package com.project.lam.domain.license.enums;

import lombok.Getter;

@Getter
public enum LicenseType{
    STANDARD("Standard License"), // DB에 들어갈 값: STANDARD
    PRO("Pro License"),           // DB에 들어갈 값: PRO
    ENTERPRISE("Enterprise License"); // DB에 들어갈 값: ENTERPRISE

    private final String description;


    LicenseType(String description) {
        this.description = description;
    }

}
