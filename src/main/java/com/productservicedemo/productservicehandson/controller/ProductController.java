package com.productservicedemo.productservicehandson.controller;

import com.productservicedemo.productservicehandson.Entity.Product;
import com.productservicedemo.productservicehandson.dto.APIResponse;
import com.productservicedemo.productservicehandson.service.Productservice;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private Productservice productservice;

    private final Logger logger=LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to product service";
    }

    @GetMapping("/product/{productid}")
    public ResponseEntity<?> getproductByid(@PathVariable int productid){

        //return new ResponseEntity<>(productservice.getProductByid(productid), HttpStatus.OK) test;
        logger.info("ProductController.getproductByid execution started....");
        Product product=productservice.getProductByid(productid);
        APIResponse<Product> response=APIResponse
                .<Product>builder()
                .status("success")
                .ststuscode(HttpStatusCode.valueOf(200).toString())
                .results(product).build();
        logger.info("ProductController.getproductByid execution ended....");
        return new ResponseEntity<>(response,HttpStatus.OK);


    }

}
