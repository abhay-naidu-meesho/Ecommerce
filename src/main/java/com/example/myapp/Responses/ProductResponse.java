package com.example.myapp.Responses;
import com.example.myapp.Entities.Product;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter

public class ProductResponse {
    private long id;
    private String name;
    private double price;
    private String pictureUrl;
    public ProductResponse(Product product){
        this.id=product.getId();
        this.name=product.getName();
        this.price=product.getPrice();
        this.pictureUrl=product.getPictureUrl();
    }
}
