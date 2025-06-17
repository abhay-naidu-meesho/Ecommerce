package com.example.myapp.Entities;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.example.myapp.Responses.CreateOrderProdResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    @EmbeddedId 
    @JsonIgnore
    private OrderProductPK pk;


    @Column(nullable=false)
    private int quantity;

    public OrderProduct(Order order ,Product product ,int quantity){
        pk=new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity=quantity;
    }
    @Transient
    public Product getProduct(){
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice(){
        return getProduct().getPrice()*quantity;

    }
    public OrderProduct(CreateOrderProdResponse orderProduct,Order order ,Product product){
        this.quantity=orderProduct.getQuantity();
        
        this.pk=new OrderProductPK();
        this.pk.setOrder(order);
        this.pk.setProduct(product);
        
    }



}
