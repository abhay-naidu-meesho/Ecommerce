package com.example.myapp.Responses;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.myapp.Entities.Order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
public class OrderResponse {
    private long id;
    private LocalDate orderDate;
    private String status;
    private List<OrderProductResponse> orderProducts;
    private double totalPrice;
    private int numberOfProducts;
    public OrderResponse(Order order){
        this.id=order.getId();
        this.orderDate=order.getOrderDate();
        this.status=order.getStatus();
        this.orderProducts=order.getOrderProducts().stream().map(OrderProductResponse::new).collect(Collectors.toList());
        this.totalPrice=order.getTotalOrderPrice();
        this.numberOfProducts=order.getNumberOfProducts();
    }
}
