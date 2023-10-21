package com.example.hospital.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(value ={ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException exception) {

        HttpStatus httpStatus = exception.getHttpStatus() != null ? exception.getHttpStatus() : HttpStatus.INTERNAL_SERVER_ERROR;

        ApiException apiException = new ApiException(
            exception.getMessage(),
            httpStatus
        );


        return new  ResponseEntity<Object>(apiException, httpStatus);

    }

}
