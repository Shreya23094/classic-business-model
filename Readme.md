# 📊 Classic Business Model Backend

## 📌 Overview

This project is a **Spring Boot REST API** that provides business insights and data retrieval for customers, orders, products, and payments.

It focuses on:

* Filtering data
* Handling relationships between entities
* Providing analytics like revenue and customer spending

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Pagenation
* JWT Security

---

## ✨ Features

* 🔍 Filter customers by country
* 🏆 Identify top customers
* 📦 Filter products by product line
* 📋 Filter orders by status
* 💰 Calculate total revenue
* 🔗 Fetch relational data (Customer → Orders, Orders → Products)
* 📊 Customer spending insights

---

## 🔗 API Endpoints

### 👥 Customers

| Endpoint                                        | Description                    |
| ----------------------------------------------- | ------------------------------ |
| `GET /api/customers?country=USA`                | Filter customers by country    |
| `GET /api/customers/top`                        | Get top customers              |
| `GET /api/customers/{id}/orders`                | Get all orders of a customer   |
| `GET /api/customers/{id}/orders?status=Shipped` | Get customer orders by status  |
| `GET /api/customers/{id}/payment/amount`        | Get total spending of customer |
| `GET /api/customers/{customerId}/support`       | Customer support data          |

---

### 📦 Products

| Endpoint                                    | Description                     |
| ------------------------------------------- | ------------------------------- |
| `GET /api/products?productLine=ClassicCars` | Filter products by product line |

---

### 📋 Orders

| Endpoint                         | Description                    |
| -------------------------------- | ------------------------------ |
| `GET /api/orders?status=Shipped` | Filter orders by status        |
| `GET /api/orders/{id}`           | Get order with product details |

---

### 💳 Payments

| Endpoint                    | Description       |
| --------------------------- | ----------------- |
| `GET /api/payments/revenue` | Get total revenue |

---

## 🔐 Authentication

* Can be secured using JWT (if implemented)
* Token-based authentication via headers

```http
Authorization: Bearer <token>
```

---

## 🧪 Example API Usage

### Request

```http
GET /api/customers?country=USA
```

### Response

```json
[
  {
    "id": 1,
    "name": "John Doe",
    "country": "USA"
  }
]
```

---

## ⚙️ Setup Instructions

### Clone Repository

```bash
git clone https://github.com/<your-username>/classicbusinessmodel.git
cd classicbusinessmodel
```

### Configure Database


```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

jwt.secretKey = ${SECRET_KEY}
```


### Run Application

```bash
mvn spring-boot:run
```

---

## 📂 Project Structure

```
src/main/java/com/businessmodel/
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
└── config/
```

---
