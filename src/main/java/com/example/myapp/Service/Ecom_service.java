package com.example.myapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.Entities.Product;
import com.example.myapp.Repository.ProductRepository;
import com.example.myapp.Responses.CreateProduct;

@Service
@Transactional
public class  Ecom_service{

    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getALLProducts(){
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
        
    }
    
    public Product createProduct(CreateProduct product){
        Product prod1=new Product(product);

        return productRepository.save(prod1);
    }
    
}
