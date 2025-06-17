package com.example.myapp.Controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.Entities.Order;
import com.example.myapp.Responses.CreateOrderResponse;
import com.example.myapp.Responses.OrderResponse;
import com.example.myapp.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    

    @GetMapping
    public @NotNull List<OrderResponse> findAll() {
        List<Order> orders = orderService.findALL();
        return orders.stream().map(OrderResponse::new).collect(Collectors.toList());

    }
    @PostMapping("/create")
public CreateOrderResponse createOrder(@RequestBody CreateOrderResponse order){
    order.setOrderDate(LocalDate.now());
    Order order1=orderService.create(order);
    return new CreateOrderResponse(order1);
}

    
    
    
}
