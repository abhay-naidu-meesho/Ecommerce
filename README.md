# 🛒 E-Commerce Spring Boot App

A REST API for e-commerce with product and order management.

##  Tech Stack
- **Java 8** | **Spring Boot 2.7.18** | **Maven** | **H2 Database** | **JPA/Hibernate**

##  Quick Start

```bash
# Clone and run
git clone https://github.com/abhay-naidu-meesho/Ecommerce.git
mvn spring-boot:run
```

**Access:** `http://localhost:8080`  
**Database Console:** `http://localhost:8080/h2-console`

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| POST | `/api/products/create` | Create product |
| GET | `/api/orders` | Get all orders |
| GET | `/api/order-products/{orderId}` | Get order items |
| POST | `/api/orders/create` | Create an Order |
| POST | `/api/order-products/create` | Add item to order |

##  Features

- ✅ Product CRUD operations
- ✅ Order management with line items
- ✅ Many-to-many Order-Product relationships
- ✅ Auto-loaded sample data
- ✅ H2 in-memory database
- ✅ JSON REST APIs

##  Sample Usage

**Create Product:**
```bash
curl -X POST http://localhost:8080/api/products/create
  -H "Content-Type: application/json" \
  -d '{"name": "Chair", "price": 100.0, "pictureUrl": "url"}'
```

**Add Product to Order:**
```bash
curl -X POST http://localhost:8080/api/order-products/create
  -H "Content-Type: application/json" \
  -d '{"order_id": 1, "product_id": 1, "quantity": 2}'
```

## 🗂️ Project Structure
```bash
src/main/java/com/example/myapp/
├── Controllers/ # REST endpoints
├── Entities/ # JPA entities (Product, Order, OrderProduct)
├── Repository/ # Data access layer
├── Service/ # Business logic
└── Responses/ # DTOs
```

## 💾 Database Schema

- **Product**: id, name, price, pictureUrl
- **Order**: id, orderDate, status  
- **OrderProduct**: composite key (order_id, product_id), quantity

---

**Author:** [Abhay Naidu](https://github.com/abhay-naidu-meesho)
