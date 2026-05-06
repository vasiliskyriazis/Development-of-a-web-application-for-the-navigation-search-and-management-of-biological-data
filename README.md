# 🧬 VVDb  
### 🚀 Biological Data Navigation & Management Platform  

![Java](https://img.shields.io/badge/Backend-Spring%20Boot-green)
![Angular](https://img.shields.io/badge/Frontend-Angular-red)
![Database](https://img.shields.io/badge/Database-MySQL-blue)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A modern **full-stack bioinformatics platform** for exploring and managing genomic data, built for the course **Special Topics in Bioinformatics II**.

---

## ✨ Features

- 🔍 Advanced gene search with Boolean logic (AND / OR / NOT)
- 🧬 Integration of biological data from Ensembl BioMart and ClinVar
- 🔐 Secure authentication with role-based access control (USER / ADMIN)
- ⚡ Fast and responsive Single Page Application (SPA)
- 🎯 Real-time filtering and dynamic UI updates
- 🌗 Dark / Light mode toggle
- 🧪 Structured relational model for biological entities

---

## 🏗️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- JPA Criteria API

### Frontend
- Angular
- RxJS
- Bootstrap 5

### Database
- MySQL

---

## 🧠 Architecture

Client (Angular SPA)  
↓  
REST API (Spring Boot)  
↓  
Service Layer (Business Logic)  
↓  
JPA / Hibernate  
↓  
MySQL Database  

The system follows a Client–Server architecture, ensuring scalability, maintainability, and separation of concerns.

---

## 📊 Database Model

- **Gene**: Core biological entity containing Symbol, Description, GC Content, and related metadata
- **Transcript (1:N)**: Each gene is associated with multiple transcripts
- **Variant (M:N)**: Variants are linked to genes through a join table

---

## ⚙️ Installation & Setup

### 1️⃣ Database Setup

Create the database:

```sql
CREATE DATABASE vvdb;
```

Run the provided SQL scripts:

```bash
create_tables.sql
insert_data.sql
```

### 2️⃣ Backend Setup

```bash
cd gene_backend
./mvnw spring-boot:run
```

API endpoint:

`http://localhost:8080/api/genes`

### 3️⃣ Frontend Setup

```bash
cd gene_frontend
npm install
ng serve
```

Open in browser:

`http://localhost:4200`

---

## 🔐 Authentication

| Role | Permissions |
|------|-------------|
| USER | Read & Search |
| ADMIN | Full CRUD access |

Authentication is implemented using Spring Security with Basic Authentication.

---

## 📡 API Example

```http
GET /api/genes?symbol=TP53
Authorization: Basic <credentials>
```

---



## ⭐ Why this project matters

This project demonstrates:
- Real-world bioinformatics data modeling
- Advanced query system implementation
- Full-stack development using clean architecture principles
- Secure and scalable biological data management

---

## 📌 License

This project is licensed under the MIT License.
