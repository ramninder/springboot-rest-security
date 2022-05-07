package com.ramninder.security.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String productName;

    @NotBlank
    private String productPrice;

    @NotBlank
    private  String productQuantity;

    public Inventory(){

    }

    public Inventory(String productName, String productPrice, String productQuantity ){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }


}
