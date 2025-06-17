package com.example.myapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.Entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
  
}
