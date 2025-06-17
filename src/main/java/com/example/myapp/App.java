package com.example.myapp;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
/**
 * Hello world!
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.myapp.Entities.Order;
import com.example.myapp.Entities.OrderProduct;
import com.example.myapp.Entities.Product;
import com.example.myapp.Responses.CreateOrderProdResponse;
import com.example.myapp.Responses.CreateOrderResponse;
import com.example.myapp.Responses.CreateProduct;
import com.example.myapp.Service.Ecom_service;
import com.example.myapp.Service.OrderProductService;
import com.example.myapp.Service.OrderService;

@SpringBootApplication
@EnableJpaRepositories("com.example.myapp.Repository")
@EntityScan("com.example.myapp.Entities")
@ComponentScan("com.example.myapp")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Hello World!");
    }

    @Bean
    CommandLineRunner runner(Ecom_service productService, OrderService orderService,
            OrderProductService orderProdService) {
        return args -> {
            Object[][] productData = {
                    { "Chairs", 100.00, "https://via.placeholder.com/150" },
                    { "Tables", 200.00, "https://via.placeholder.com/150" },
                    { "Sofas", 300.00, "https://via.placeholder.com/150" },
                    { "Beds", 400.00, "https://via.placeholder.com/150" },
                    { "Dining Tables", 500.00, "https://via.placeholder.com/150" },
                    { "Coffee Tables", 600.00, "https://via.placeholder.com/150" },
                    { "Bookcases", 250.00, "https://via.placeholder.com/150" },
                    { "Wardrobes", 700.00, "https://via.placeholder.com/150" }
            };
            for (Object[] prod : productData) {
                CreateProduct prod1 = new CreateProduct();
                prod1.setName((String) prod[0]);
                prod1.setPrice((Double) prod[1]);
                prod1.setPictureUrl((String) prod[2]);
                productService.createProduct(prod1);

            }
            System.out.println("Sample products loaded!");

            Long[] prodIDs = { 1L, 2L, 3L, 4L };
            Object[][] orderData = {
                    { LocalDate.of(2024, 6, 1), "COMPLETED" },
                    { LocalDate.of(2024, 6, 10), "PENDING" },
                    { LocalDate.of(2024, 6, 15), "SHIPPED" }
            };
            int cnt = 0;
            for (Object[] order : orderData) {
                Order order1 = new Order();
                order1.setOrderDate((LocalDate) order[0]);
                order1.setStatus((String) order[1]);
                CreateOrderResponse op=new CreateOrderResponse(order1);
                Order order2=orderService.create(op);
                Product product1 = productService.getProductById(prodIDs[cnt % 4]);
                Product product2 = productService.getProductById(prodIDs[(cnt + 1) % 4]);
                System.out.println("Product1: " + product1);
                System.out.println("Product2: " + product2);
                System.out.println("Orderid :  "+ order2.getId());
                OrderProduct op1 = new OrderProduct(order2, product1, 1);
                OrderProduct op2 = new OrderProduct(order2, product2, 2);
                orderProdService.create(new CreateOrderProdResponse(op1));
                orderProdService.create(new CreateOrderProdResponse(op2));

                cnt++;
            }

            System.out.println("Sample orders loaded!");
        };
    }
}
