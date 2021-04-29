package com.bug_tracker.errorHandling;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter @Getter
public class ApiResponse {
    private HttpStatus status;

    private int code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private ApiResponse() {
        timestamp = LocalDateTime.now();
    }


    public ApiResponse(HttpStatus status, String message) {
        this();
        this.status = status;
        this.code = status.value();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
