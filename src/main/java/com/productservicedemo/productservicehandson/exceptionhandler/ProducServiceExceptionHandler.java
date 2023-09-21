package com.productservicedemo.productservicehandson.exceptionhandler;

import com.productservicedemo.productservicehandson.dto.APIResponse;
import com.productservicedemo.productservicehandson.dto.ErrorDTO;
import com.productservicedemo.productservicehandson.exception.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;

@RestControllerAdvice
public class ProducServiceExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public APIResponse<?> handleproductnotfoundexception(ProductNotFoundException exception){

        APIResponse<?> exceptionresponse=new APIResponse<>();
        exceptionresponse.setStatus("FAILURE");
       // exceptionresponse.setErrors(Collections.singletonList(new ErrorDTO("",exception.getMessage())));
        exceptionresponse.setStstuscode(HttpStatusCode.valueOf(404).toString());
        exceptionresponse.setErrormessage(exception.getMessage());
        return  exceptionresponse;
    }
}
