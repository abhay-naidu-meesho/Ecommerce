package com.example.myapp.Responses;
import com.example.myapp.Entities.OrderProduct;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter

public class OrderProductResponse {
    private long id;
    private String name;
    private double price;
    private int quantity;
    private double totalPrice;
    public OrderProductResponse(OrderProduct orderProduct){
        this.id=orderProduct.getProduct().getId();
        this.name=orderProduct.getProduct().getName();
        this.price=orderProduct.getProduct().getPrice();
        this.quantity=orderProduct.getQuantity();
        this.totalPrice=orderProduct.getTotalPrice();
    }


}
