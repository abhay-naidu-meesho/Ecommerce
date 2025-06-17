package com.example.myapp.Responses;


import com.example.myapp.Entities.Product;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@NoArgsConstructor
public class CreateProduct {
    private String name;
    private double price;
    private String pictureUrl;
    public CreateProduct(Product product){
        this.name=product.getName();
        this.price=product.getPrice();
        this.pictureUrl=product.getPictureUrl();
    }
}
