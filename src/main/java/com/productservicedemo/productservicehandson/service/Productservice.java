package com.productservicedemo.productservicehandson.service;


import com.productservicedemo.productservicehandson.Entity.Product;
import com.productservicedemo.productservicehandson.Repository.ProductRepository;
import com.productservicedemo.productservicehandson.dto.APIResponse;
import com.productservicedemo.productservicehandson.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class Productservice {

    @Autowired
    private ProductRepository productRepository;
    public Product getProductByid(int productid){

        Product product;
        try {
            log.info("productservice.productid execution starting....");

              product = productRepository.findById(productid)
                    .orElseThrow(()->new ProductNotFoundException("product not found"+productid));
            /*if (!product.isPresent()) {
                throw new RuntimeException("product not found" + productid);
            }*/

            log.debug("Productservice.getProductByid getting the product from DB {} details is {} ", productid, product);
            log.info("productservice.productid execution ended....");

        }catch (Exception e){

            throw new ProductNotFoundException("Product Not Found in database id is"+productid);
        }

        return product;
    }


}
