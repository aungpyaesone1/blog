package com.aps.demo.exception;

import com.aps.demo.model.ExceptionResponse;
import com.aps.demo.util.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> exception(Exception ex){
        ExceptionResponse er = new ExceptionResponse(ResponseEnum.ResponseCode.SERVER_ERROR.code(), ex.getMessage(), new Date().toString());
        return new ResponseEntity(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
