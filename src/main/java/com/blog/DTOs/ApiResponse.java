package com.blog.DTOs;

import lombok.Data;

@Data
public class ApiResponse {
    String message;
    boolean status;

    public ApiResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
}
