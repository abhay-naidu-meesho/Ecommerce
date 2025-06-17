package com.example.myapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.Entities.Order;
import com.example.myapp.Entities.OrderProduct;
import com.example.myapp.Entities.Product;
import com.example.myapp.Repository.OrderProductRepository;
import com.example.myapp.Responses.CreateOrderProdResponse;

@Service
public class OrderProductService {
    @Autowired
    private OrderProductRepository orderProdRepo;
    @Autowired
    private OrderService orderService;
    @Autowired 
    private Ecom_service ecomService;

    public OrderProduct create(CreateOrderProdResponse orderProduct){
        Order order=orderService.findById(orderProduct.getOrder_id());
        Product product=ecomService.getProductById(orderProduct.getProduct_id());
        OrderProduct op=new OrderProduct(orderProduct,order,product);
        return orderProdRepo.save(op);
    }
    public List<OrderProduct> getOrderProducts(Long id){
        return orderProdRepo.findByPkOrderId(id);

    }
    

    
    
}
