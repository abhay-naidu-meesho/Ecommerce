package com.example.myapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.Entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
  

}
