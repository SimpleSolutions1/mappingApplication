package com.simpleSolutions.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;


@Getter
@Setter
public class ErrorMessageDTO {

    private int status;
    private String message;
    private LocalTime time;

    public ErrorMessageDTO(int status, String message) {
        this.status = status;
        this.message = message;
        this.time = LocalTime.now();
    }
}
