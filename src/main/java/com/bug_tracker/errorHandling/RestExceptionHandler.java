package com.bug_tracker.errorHandling;

import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice(annotations = RestController.class)
@Order(1)
@NoArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                HttpHeaders headers, HttpStatus status, WebRequest request) {
        int size = ex.getBindingResult().getAllErrors().toArray().length;
        String allErrors = "";
        for(int i=0;i<size;i++)
        {
            allErrors += ex.getBindingResult().getAllErrors().get(i).getDefaultMessage();
            allErrors += "\n";
        }
        ApiResponse notValidError = new ApiResponse(status,allErrors);
        return new ResponseEntity<>(notValidError,notValidError.getStatus());
    }
}
