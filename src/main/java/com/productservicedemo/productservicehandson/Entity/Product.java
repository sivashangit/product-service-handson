package com.productservicedemo.productservicehandson.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producttablehandson")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private String productType;
    private int quantity;
    private double price;
    private String supplierName;
    private String supplierCode;
}
