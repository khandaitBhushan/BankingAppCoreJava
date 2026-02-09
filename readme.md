# 🏦 Student Bank – Core Java Banking Application

> A robust **Console-based Banking System** built with **Core Java**, adhering to strict **Layered Architecture**.  
> This project demonstrates professional software development practices including **OOP principles, Exception Handling, Collections**, and supports **Dual Data Persistence** strategies (In-Memory & MySQL Database).

---

## 🚀 Key Features

- **Account Management**: Create, Delete, and Update customer accounts.
- **Transaction Services**: Deposit and Withdraw functionalities with validation.
- **Balance Inquiry**: Real-time balance checking.
- **Dual Persistence Modes**:
    - **In-Memory Storage (HashMap)**: For quick testing and logic verification without a database.
    - **Persistent Storage (JDBC + MySQL)**: For permanent data storage using a relational database.
- **Custom Exception Handling**: Meaningful error messages (e.g., `InsufficientBalanceException`, `AccountNotFoundException`).
- **Clean Architecture**: Separation of concerns (UI → Service → Repository → Entity).

---

## 🧱 Project Architecture

The application follows a modular design pattern, allowing easy switching between storage mechanisms without affecting business logic.

```mermaid
graph TD
    UI[Console UI (Main.java)] -->|Calls| Service[Service Layer (BankService)]
    Service -->|Uses Interface| RepoInterface[AccountRepository Interface]
    RepoInterface <-->|Implements| MemoryRepo[AccountRepositoryMemory (HashMap)]
    RepoInterface <-->|Implements| JDBCRepo[AccountRepositoryJDBC (MySQL)]
```

### � Package Structure
```
com.bankApp
┣━ entity         → Data Model (Account.java)
┣━ exception      → Custom Exceptions
┣━ repository     → Data Access Layer (Interfaces & Implementations)
┣━ service        → Business Logic
┣━ db             → Database Connection Configuration
┗━ Main.java      → Application Entry Point (UI)
```

---

## 🛠️ Technologies Used

- **Language**: Java 8+
- **Database**: MySQL (for JDBC mode)
- **Concepts**:
    - Object-Oriented Programming (Abstraction, Polymorphism, Encapsulation)
    - Java Collections Framework (Map, List)
    - JDBC (Java Database Connectivity)
    - Exception Handling

---

## ⚙️ Setup & Configuration

### 1️⃣ Prerequisites
- Java Development Kit (JDK) 8 or higher.
- MySQL Server (if using Database mode).
- A Java IDE (IntelliJ IDEA, Eclipse, or VS Code).

### 2️⃣ Database Setup (Only for JDBC Mode)
If you wish to use the **Database Persistence** mode, follow these steps:

1.  **Create Database**:
    ```sql
    CREATE DATABASE bank_db;
    USE bank_db;
    ```
2.  **Create Table**:
    ```sql
    CREATE TABLE account (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(100),
        balance DOUBLE,
        account_type VARCHAR(20),
        address VARCHAR(200),
        phone_no VARCHAR(15)
    );
    ```
3.  **Configure Connection**:
    Open `src/com/bankApp/db/DbConnection.java` and update your MySQL credentials:
    ```java
    private static final String url = "jdbc:mysql://localhost:3306/bank_db";
    private static final String user = "root";       // Your MySQL Username
    private static final String password = "password"; // Your MySQL Password
    ```

---

## � Switching Storage Modes

You can switch between **In-Memory** (HashMap) and **Database** (MySQL) storage by changing just **one line** of code in `src/com/bankApp/service/BankService.java`.

**For Database Mode (Default):**
```java
AccountRepository repo = new AccountRepositoryJDBC();
```

**For In-Memory Mode:**
```java
// AccountRepository repo = new AccountRepositoryJDBC();
AccountRepository repo = new AccountRepositoryMemory();
```

---

## ▶️ How to Run

1.  Clone this repository:
    ```bash
    git clone https://github.com/khandaitBhushan/BankingAppCoreJava.git
    ```
2.  Open the project in your IDE.
3.  Ensure the MySQL JDBC Driver (Connector/J) is added to your project's libraries/classpath if using Database mode.
4.  Run `Main.java` as a Java Application.
5.  Follow the on-screen console instructions.

---

## 👨‍💻 Author

**Bhushan Khandait**  
- GitHub: [khandaitBhushan](https://github.com/khandaitBhushan)  
- LinkedIn: [Bhushan Khandait](https://www.linkedin.com/in/khandaitbhushan)

---
*Built for learning and demonstrating Core Java capabilities.*
