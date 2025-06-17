package com.example.myapp.Entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.example.myapp.Responses.CreateProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product Name is required")
    @Basic(optional = false)
    private String name;

    private double price;
    private String pictureUrl;
    public Product(CreateProduct product){
       
            this.name=product.getName();
            this.price=product.getPrice();
            this.pictureUrl=product.getPictureUrl();
        
    }
}
