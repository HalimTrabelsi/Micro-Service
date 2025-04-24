# 🧩 Microservices Project with Kafka, MongoDB, and Docker

A microservices-based backend application designed for modularity, real-time communication, and scalability. This project is built with **Node.js**, **Express.js**, **MongoDB Atlas**, **Apache Kafka**, and **Docker**. It includes the following services:

- 📦 **Stock Service**: Manages product inventory.
- 👤 **User Service**: Handles authentication and user management.
- 🔔 **Notification Service**: Sends alerts and messages based on events.
- 📨 **Kafka Broker**: Enables asynchronous communication between services.

---

## 📁 Project Structure

. ├── stock-service/ 
├── user-service/ 
├── notification-service/ 
├── kafka/ 
│ └── docker-compose.yml └── README.md

Each service is self-contained with its own:
- `Dockerfile`
- `routes`, `controllers`, and `models`
- `.env` configuration

---

## 🚀 Features

- ✅ Microservice architecture
- ✅ MongoDB Atlas integration
- ✅ Kafka messaging for real-time event handling
- ✅ Docker & Docker Compose setup
- ✅ Environment-based configuration
- ✅ Clean code using MVC structure

---

## 🔧 Technologies Used

- **Backend**: Node.js, Express.js
- **Database**: MongoDB Atlas
- **Messaging**: Apache Kafka
- **Containerization**: Docker & Docker Compose
- **Security**: JWT, bcrypt

---

## 📦 Installation

### 1. Clone the repository

cd microservices-kafka-app
POST /api/stocks
Content-Type: application/json
{
  "name": "Product A",
  "price": 12.99,
  "quantity": 100,
  "type": "Electronics"
}
docker build -t stock-service ./stock-service
# Go to a service folder
cd stock-service

# Install dependencies
npm install

# Run the service
npm run dev

---

Let me know if you want this README customized with badges, diagrams, or API docs!
