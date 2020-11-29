package com.example.demo.api;

import lombok.Data;
import lombok.Getter;

@Getter
public class CustomerErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

    public CustomerErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
