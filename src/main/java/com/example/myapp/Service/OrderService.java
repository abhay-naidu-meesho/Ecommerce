package com.example.myapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.Entities.Order;
import com.example.myapp.Repository.OrderRepository;
import com.example.myapp.Responses.CreateOrderResponse;
@Service
@Transactional

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> findALL(){
        return orderRepository.findAll();
    }
    public Order findById(Long id){
        return orderRepository.findById(id).orElse(null);
    }
    public Order create(CreateOrderResponse order){
        Order order1= new Order(order);
        return orderRepository.save(order1);
    }
    public Order update(Order order){
        return orderRepository.save(order);
    }
}
