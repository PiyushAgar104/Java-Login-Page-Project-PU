# Java-Login-Page-Project-PU
# 🔐 JavaLoginPage

### Secure Java Login & Registration System

A complete web-based authentication system built using **Java Servlets, JSP, JDBC, MySQL, Maven and Apache Tomcat 11**.

This project demonstrates a complete authentication workflow — from user registration and password hashing to login, session management and logout.

---

## 🚀 Features

* 📝 User Registration
* 🔑 User Login
* 🔒 Password Hashing using SHA-256
* 🗄️ MySQL Database Integration
* 🔌 JDBC Connectivity
* 👤 Session-Based Authentication
* 🚪 Logout
* 🛡️ Protected Dashboard
* ✅ Form Validation
* 📧 Email Validation
* 🚫 Duplicate Email Detection
* 🌐 JSP Web Interface
* 📦 Maven Build System
* 🐱 Apache Tomcat 11 Support

---

## 🛠️ Tech Stack

| Technology          | Purpose               |
| ------------------- | --------------------- |
| ☕ Java 25           | Backend               |
| 🌐 Jakarta Servlet  | Request Handling      |
| 🎨 JSP              | Frontend Pages        |
| 🗄️ MySQL           | Database              |
| 🔌 JDBC             | Database Connectivity |
| 🐱 Apache Tomcat 11 | Web Server            |
| 📦 Maven            | Build & Dependencies  |
| 🎨 HTML/CSS         | User Interface        |

---

## 🏗️ Project Structure

```text
JavaLoginPage/
│
├── pom.xml
├── README.md
├── .gitignore
│
└── src/
    └── main/
        │
        ├── java/
        │   └── com/
        │       └── loginsystem/
        │           │
        │           ├── AuthFilter.java
        │           ├── DBConnection.java
        │           ├── HelloServlet.java
        │           ├── LoginServlet.java
        │           ├── LogoutServlet.java
        │           ├── PasswordUtil.java
        │           ├── RegisterServlet.java
        │           └── TestDB.java
        │
        └── webapp/
            │
            ├── login.jsp
            ├── register.jsp
            └── home.jsp
```

---

## 🔄 Authentication Flow

```text
                    ┌─────────────────┐
                    │   Register.jsp  │
                    └────────┬────────┘
                             │
                             ▼
                   ┌──────────────────┐
                   │ RegisterServlet  │
                   └────────┬─────────┘
                            │
                            ▼
                   ┌──────────────────┐
                   │ Password Hashing │
                   └────────┬─────────┘
                            │
                            ▼
                    ┌──────────────┐
                    │    MySQL     │
                    │  users table │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │   Login.jsp  │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │ LoginServlet │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │   Password   │
                    │ Verification │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │ HTTP Session │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │   Home.jsp   │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │    Logout    │
                    └──────────────┘
```

---

## 🗄️ Database Setup

Create the database:

```sql
CREATE DATABASE login_system;

USE login_system;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

Check the table:

```sql
DESCRIBE users;
```

---

## ⚙️ Database Configuration

Configure your MySQL connection in `DBConnection.java`.

```java
private static final String URL =
        "jdbc:mysql://localhost:3306/login_system";

private static final String USER =
        "root";

private static final String PASSWORD =
        "YOUR_DATABASE_PASSWORD";
```

> ⚠️ Never upload your real database password to GitHub.

For production applications, use environment variables or a secrets manager.

---

## ▶️ Run the Project

### 1. Clone Repository

```bash
git clone https://github.com/PiyushAgar104/JavaLoginPage.git
```

### 2. Open Project

Open the project using:

```text
IntelliJ IDEA
```

### 3. Configure MySQL

Make sure MySQL is running and create the `login_system` database.

### 4. Build with Maven

```bash
mvn clean package
```

Or use the Maven tool inside IntelliJ IDEA.

### 5. Deploy on Apache Tomcat

Use:

```text
Apache Tomcat 11
```

Deploy the generated WAR application.

### 6. Open Application

```text
http://localhost:8080/LoginSystem/login.jsp
```

---

## 🔐 Security Concepts

### Password Hashing

Passwords are not stored as plain text.

```text
User Password
      ↓
SHA-256 Hash
      ↓
MySQL Database
```

### Session Authentication

After successful login:

```text
Login
  ↓
Authentication
  ↓
HTTP Session
  ↓
Protected Dashboard
```

### Input Validation

The application validates:

* Required fields
* Email format
* Password length
* Duplicate email

---

## 📱 Application Pages

### 📝 Registration

Users can create an account with:

* First Name
* Surname
* Email
* Password

### 🔑 Login

Registered users can authenticate using their email and password.

### 🏠 Dashboard

After successful authentication, users are redirected to a personalized dashboard displaying their account information.

### 🚪 Logout

Logout destroys the active session and returns the user to the login page.

---

## 📚 Concepts Practiced

This project helped me practice:

* Java Servlets
* JSP
* HTTP GET & POST
* JDBC
* MySQL
* Password Hashing
* HTTP Sessions
* Authentication
* Authorization
* Form Validation
* Maven
* Apache Tomcat
* Web Application Deployment
* MVC-style Web Architecture

---

## 🔮 Future Improvements

* 🔐 BCrypt / Argon2 Password Hashing
* 📧 Email Verification
* 🔄 Forgot Password
* 👨‍💼 Admin Dashboard
* 🛡️ CSRF Protection
* 🚦 Login Rate Limiting
* 🔑 Remember Me
* 📱 Improved Responsive UI
* 🔒 Environment-Based Configuration

---

## 👨‍💻 Author

### Piyush Agar

**B.Tech — Artificial Intelligence & Data Science**

```text
Java • Python • AI/ML • Data Science • Full Stack Development
```

---

## ⭐ Support

If you found this project useful, consider giving the repository a ⭐.

---

## 📄 License

This project was created for educational and learning purposes.
