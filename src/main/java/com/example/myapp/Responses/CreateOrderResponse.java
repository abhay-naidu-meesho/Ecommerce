package com.example.myapp.Responses;

import java.time.LocalDate;

import com.example.myapp.Entities.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse {
   private LocalDate orderDate;
   private String status;
  public CreateOrderResponse(Order order){
    this.orderDate=order.getOrderDate();
    this.status=order.getStatus();
  }
   
     

    
}
