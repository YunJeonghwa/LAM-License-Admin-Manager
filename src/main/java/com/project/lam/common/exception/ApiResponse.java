package com.project.lam.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse {

    private boolean success;
    private Object data;
    private String message;

    public static ApiResponse ok(){
        return new ApiResponse(true,null,null);
    }

    public static ApiResponse ok(Object data){
        return new ApiResponse(true,data,null);
    }

    public static ApiResponse fail(String message){
        return new ApiResponse(false,null,message);
    }
}
