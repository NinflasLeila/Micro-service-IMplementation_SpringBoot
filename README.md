# Customer & Bank Account Microservice

A Spring Boot microservice for managing **customers and their bank accounts**, exposing both **REST** and **GraphQL APIs**.

The project demonstrates the implementation of a microservice architecture with Spring Boot, Spring Data JPA, REST APIs, and GraphQL.

## 🚀 Features

* Customer management
* Bank account management
* REST API
* GraphQL API
* CRUD operations
* Customer–Account relationship
* Data persistence with JPA
* DTO-based API design
* Exception handling
* Entity-to-DTO mapping

## 🏗️ Architecture

The application follows a layered architecture:

```text
Client
  │
  ├─────────────── REST API
  │                    │
  │                    ▼
  │              Controllers
  │                    │
  │                    ▼
  │                 Services
  │                    │
  │                    ▼
  │               Repositories
  │                    │
  │                    ▼
  │                Database
  │
  └────────────── GraphQL API
                       │
                       ▼
                  GraphQL Controller
                       │
                       ▼
                    Services
                       │
                       ▼
                  Repositories
```

## 🛠️ Technologies

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **Spring Web / REST**
* **Spring for GraphQL**
* **Maven**
* **Lombok**
* **DTO Pattern**
* **JPA / Hibernate**
* **SQL Database**

## 📡 REST API

The REST API provides endpoints for managing customers and bank accounts.

### Customer

Example operations:

```http
GET    /customers
GET    /customers/{id}
POST   /customers
PUT    /customers/{id}
DELETE /customers/{id}
```

### Bank Account

Example operations:

```http
GET    /accounts
GET    /accounts/{id}
POST   /accounts
PUT    /accounts/{id}
DELETE /accounts/{id}
```

## 🔗 GraphQL API

The application also exposes a GraphQL API for flexible querying and mutations.

### Queries

Get all accounts:

```graphql
query {
    accountList {
        id
        balance
        currency
        type
    }
}
```

Get an account by ID:

```graphql
query {
    accountById(id: "account-id") {
        id
        balance
        currency
        type
    }
}
```

### Mutations

Create an account:

```graphql
mutation {
    addAccount(
        bankAccount: {
            balance: 1000
            currency: "MAD"
            type: "CURRENT"
        }
    ) {
        id
        balance
        currency
        type
    }
}
```

Update an account:

```graphql
mutation {
    updateAccount(
        id: "account-id"
        bankAccount: {
            balance: 2000
            currency: "MAD"
            type: "SAVINGS"
        }
    ) {
        id
        balance
        currency
        type
    }
}
```

Delete an account:

```graphql
mutation {
    deleteAccount(id: "account-id")
}
```

## 📂 Project Structure

```text
src/
└── main/
    ├── java/
    │   └── org/id/bank_account_service/
    │       ├── entities/
    │       ├── repositories/
    │       ├── service/
    │       ├── dto/
    │       ├── mapper/
    │       ├── web/
    │       └── exceptions/
    │
    └── resources/
        ├── application.properties
        └── graphql/
            └── schema.graphqls
```

## ⚙️ Getting Started

### Prerequisites

Make sure you have installed:

* Java 17+
* Maven
* A relational database

### Clone the repository

```bash
git clone <repository-url>
cd <project-directory>
```

### Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

Or:

```bash
mvn spring-boot:run
```

## 🎯 Project Objective

The main objective of this project is to implement a **banking microservice** capable of managing customers and their accounts while exposing the same business functionality through two different API paradigms:

* **REST** for resource-oriented communication
* **GraphQL** for flexible and client-driven data querying

This project also aims to demonstrate good practices in Spring Boot application development, including layered architecture, DTOs, service/repository separation, persistence, and exception handling.

## 👩‍💻 Author

**Laila Nineflas**

GitHub: [NinFlasLeila](https://github.com/NinFlasLeila)
