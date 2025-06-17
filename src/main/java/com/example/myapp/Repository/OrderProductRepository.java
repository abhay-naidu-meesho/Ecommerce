package com.example.myapp.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.Entities.OrderProduct;
import com.example.myapp.Entities.OrderProductPK;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct,OrderProductPK>{

    List<OrderProduct> findByPkOrderId(Long id);
} 
