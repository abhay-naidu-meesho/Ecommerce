package com.example.myapp.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.Entities.OrderProduct;
import com.example.myapp.Responses.CreateOrderProdResponse;
import com.example.myapp.Responses.OrderProductResponse;
import com.example.myapp.Service.OrderProductService;
@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {
    @Autowired
    private OrderProductService orderProdService;
    @GetMapping("/{id}")
    public @NotNull List<OrderProductResponse> findByOrderId(@PathVariable Long id){
        List<OrderProduct>orderProducts=orderProdService.getOrderProducts(id);

        return orderProducts.stream().map(OrderProductResponse::new).collect(Collectors.toList());
     
    }
    @PostMapping("/create")
    public CreateOrderProdResponse createOrderProduct(@RequestBody CreateOrderProdResponse orderProduct){
        OrderProduct orderProduct1=orderProdService.create(orderProduct);
        return new CreateOrderProdResponse(orderProduct1);
    }
    
}
