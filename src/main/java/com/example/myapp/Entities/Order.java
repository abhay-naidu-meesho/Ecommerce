package com.example.myapp.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.myapp.Responses.CreateOrderResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="orders")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    private String status;

    @JsonManagedReference
    @OneToMany(mappedBy= "pk.order")
    private List<OrderProduct>orderProducts=new ArrayList<>();


    @Transient
    public double getTotalOrderPrice(){
        double sum=0D;
        List<OrderProduct>orderProducts=getOrderProducts();
        for(OrderProduct prod:orderProducts){
            sum+=prod.getTotalPrice();

        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts(){
        return this.orderProducts.size();

    }
    public Order(CreateOrderResponse order){
        this.orderDate=order.getOrderDate();
        this.status=order.getStatus();
        
    }

}
