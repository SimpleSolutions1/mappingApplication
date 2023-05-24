package com.simpleSolutions.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;


@Getter
@Setter
public class ErrorMessageDTO implements Serializable {

    private static final long serialVersionUID = -2384098361186259515L;
    private int status;
    private String message;
    private LocalTime time;

    public ErrorMessageDTO(int status, String message) {
        this.status = status;
        this.message = message;
        this.time = LocalTime.now();
    }
}
