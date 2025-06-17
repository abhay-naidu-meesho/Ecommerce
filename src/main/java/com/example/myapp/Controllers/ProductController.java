package com.example.myapp.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.Entities.Product;
import com.example.myapp.Responses.CreateProduct;
import com.example.myapp.Responses.ProductResponse;
import com.example.myapp.Service.Ecom_service;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private Ecom_service ecom_service;
    @GetMapping
    public @NotNull List<ProductResponse>getALLProducts(){

        List<Product > products=ecom_service.getALLProducts();
        List<ProductResponse> actProducts=products.stream().map(ProductResponse::new).collect(Collectors.toList());
        return actProducts;
    }
    @PostMapping("/create")
    public CreateProduct createProduct(@RequestBody CreateProduct product ){

        Product prod=ecom_service.createProduct(product);
        return new CreateProduct(prod);

    }
}
