package com.example.myapp.Responses;
import com.example.myapp.Entities.OrderProduct;

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
public class CreateOrderProdResponse {
    private long product_id;

    private long order_id;

    private int quantity;

    public CreateOrderProdResponse(OrderProduct orderProduct){
        this.product_id=orderProduct.getProduct().getId();
        this.order_id=orderProduct.getPk().getOrder().getId();
        this.quantity=orderProduct.getQuantity();
    }
}
