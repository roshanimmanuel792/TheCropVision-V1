# 🌾 TheCropVision-V1

[![Java Version](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![JavaFX](https://img.shields.io/badge/JavaFX-21.0.2-blue?style=for-the-badge&logo=java)](https://openjfx.io/)
[![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

**TheCropVision-V1** is an advanced, full-stack application designed to empower farmers and agronomists with AI-driven crop disease detection. By leveraging a robust Spring Boot backend and an intuitive JavaFX desktop interface, the system simplifies the process of monitoring crop health and managing records.

---

## 🌟 Key Features

-   **🔍 Smart Detection UI:** A seamless JavaFX interface for image selection and real-time disease analysis.
-   **📊 Comprehensive Data Management:** Full CRUD operations for managing crop health records via a RESTful API.
-   **📍 Precision Tracking:** Log detections with specific location data for regional disease mapping.
-   **🛡️ Secure & Scalable:** Built with Spring Boot and MySQL for reliable data persistence and performance.
-   **🤖 AI-Ready Architecture:** Designed for easy integration with state-of-the-art machine learning models.

---

## 🏗️ Architecture & Tech Stack

### Backend
- **Core:** Java 17, Spring Boot 3.5.7
- **Database:** MySQL with Spring Data JPA (Hibernate)
- **API:** RESTful Architecture
- **Communication:** Apache HttpClient 5

### Frontend
- **Framework:** JavaFX 21.0.2
- **UI Design:** FXML & Scene Builder compatible
- **Client:** Integrated HTTP Client for Backend Communication

---

## 📂 Project Structure

```text
TheCropVision-V1/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── CropDiseaseDetectorApplication.java  # 🚀 Backend Entry Point
│   │   │   ├── CropController.java                 # 🌐 REST API Endpoints
│   │   │   ├── CropRecord.java                     # 📦 Data Model (Entity)
│   │   │   ├── CropRepository.java                 # 💾 JPA Repository
│   │   │   └── FrontendApp.java                    # 💻 JavaFX Desktop App
│   │   └── resources/
│   │       └── application.properties              # ⚙️ Configuration
└── pom.xml                                         # 🛠️ Maven Dependencies
```

---

## 🚀 Getting Started

### 📋 Prerequisites
- **JDK 17+** (Required)
- **Maven 3.6+**
- **MySQL Server 8.0+**

### 🛠️ Installation & Setup

1.  **Clone the Repository**
    ```bash
    git clone https://github.com/yourusername/TheCropVision-V1.git
    cd TheCropVision-V1
    ```

2.  **Configure Database**
    - Create a database in MySQL:
      ```sql
      CREATE DATABASE cropdb;
      ```
    - Update `src/main/resources/application.properties` with your credentials:
      ```properties
      spring.datasource.username=your_username
      spring.datasource.password=your_password
      ```

3.  **Build the Project**
    ```bash
    ./mvnw clean install
    ```

---

## 🚦 Running the Application

### 1️⃣ Start the Backend
```bash
./mvnw spring-boot:run
```
> The API will be live at: `http://localhost:8080/api/crops`

### 2️⃣ Launch the Desktop Frontend
```bash
./mvnw exec:java -Dexec.mainClass="com.example.demo.FrontendApp"
```

---

## 🔌 API Documentation

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/crops` | Retrieve all health records |
| `GET` | `/api/crops/{id}` | Get details of a specific record |
| `POST` | `/api/crops` | Add a new crop analysis record |
| `PUT` | `/api/crops/{id}` | Update existing record information |
| `DELETE` | `/api/crops/{id}` | Remove a record from the database |

---

## 🛠️ How It Works

1.  **Image Input:** The user selects a crop image through the JavaFX `FrontendApp`.
2.  **Metadata Entry:** Users provide crop names and location details.
3.  **Analysis Request:** The frontend sends a multipart POST request to the backend.
4.  **Processing:** The backend (integrating with ML models) analyzes the image for diseases.
5.  **Persistence:** Results are stored in the MySQL database via Spring Data JPA.
6.  **Feedback:** The analysis result and recommendations are displayed back to the user in a clean dialog.

---

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.

---

## 📧 Contact

**Project Link:** [https://github.com/yourusername/TheCropVision-V1](https://github.com/yourusername/TheCropVision-V1)

---
<p align="center">Made with ❤️ for Sustainable Agriculture</p>
