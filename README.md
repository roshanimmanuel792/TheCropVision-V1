# 🌾 Crop Disease Detector

Crop Disease Detector is a full-stack application designed to help farmers and agronomists identify crop diseases through image analysis. The system consists of a robust Spring Boot backend for data management and a user-friendly JavaFX desktop frontend.

## 🚀 Features

- **Crop Record Management:** Full CRUD (Create, Read, Update, Delete) operations for crop health records.
- **Disease Detection UI:** Integrated interface for uploading crop images and receiving analysis results (Backend integration in progress).
- **Location Tracking:** Associate crop records with specific locations for better regional analysis.
- **AI-Ready:** Designed to integrate with machine learning models for automated disease identification.

## 🛠️ Tech Stack

- **Backend:** 
  - [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
  - [Spring Boot 3.5.7](https://spring.io/projects/spring-boot)
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
  - [MySQL](https://www.mysql.com/)
- **Frontend:**
  - [JavaFX 21.0.2](https://openjfx.io/)
- **Build Tool:** [Maven](https://maven.apache.org/)

## 📂 Project Structure

```text
TheCropVision-V1/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── CropDiseaseDetectorApplication.java  # Backend Entry Point
│   │   │   ├── CropController.java                 # API Endpoints
│   │   │   ├── CropRecord.java                     # Data Model
│   │   │   ├── CropRepository.java                 # Data Access Layer
│   │   │   └── FrontendApp.java                    # JavaFX Frontend
│   │   └── resources/
│   │       └── application.properties              # Configuration
└── pom.xml                                         # Project Dependencies
```

## ⚙️ Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.6+
- MySQL Server

### Database Setup

1. Create a MySQL database named `cropdb`:
   ```sql
   CREATE DATABASE cropdb;
   ```
2. Update `src/main/resources/application.properties` with your MySQL credentials:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### Running the Backend

```bash
./mvnw spring-boot:run
```
The API will be available at `http://localhost:8080/api/crops`.

### Running the Frontend

To run the JavaFX application:
```bash
./mvnw exec:java -Dexec.mainClass="com.example.demo.FrontendApp"
```

### Running Tests

```bash
./mvnw test
```

## 🔌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/crops` | Fetch all crop records |
| GET    | `/api/crops/{id}` | Fetch a specific record |
| POST   | `/api/crops` | Add a new crop record |
| PUT    | `/api/crops/{id}` | Update an existing record |
| DELETE | `/api/crops/{id}` | Delete a record |

## 📝 License

This project is licensed under the MIT License.
