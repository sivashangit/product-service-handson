package com.productservicedemo.productservicehandson.Repository;

import com.productservicedemo.productservicehandson.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
