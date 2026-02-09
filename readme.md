
# 🏦 Student Bank – Core Java Banking Application

> A console-based banking application built using **Core Java** with proper layered architecture.  
> Designed to demonstrate **OOP principles, exception handling, collections, and clean project structure**, with easy migration to **JDBC + MySQL** in the future.

---

## 🚀 Features

- Create Account
- Check Balance
- Deposit Money
- Withdraw Money
- Delete Account
- Custom Exception Handling
- Clean Layered Architecture (UI → Service → Repository → Entity)

---

## 🧱 Project Architecture

```

UI (Main)
↓
Service Layer (Business Logic)
↓
Repository Layer (HashMap Storage)
↓
Entity (Account Model)

```

This design ensures **loose coupling** and allows replacing the repository with **JDBC** without changing business logic.

---

## 📁 Package Structure

```

com.bankApp
┣━ entity
┃   ┗━ Account.java
┣━ exception
┃   ┣━ AccountNotFoundException.java
┃   ┗━ InsufficientBalanceException.java
┣━ repository
┃   ┗━ AccountRepository.java
┣━ service
┃   ┗━ BankService.java
┗━ Main.java

```

---

## 🛠️ Technologies Used

- Core Java
- OOP Concepts
- Collections (HashMap)
- Exception Handling
- Console (Scanner-based UI)

---

## ▶️ How to Run

1. Clone the repository
2. Open in any Java IDE (IntelliJ / Eclipse / VS Code)
3. Run `Main.java`
4. Use menu options in console

---

## 🧠 Concepts Demonstrated

- Layered Architecture in Core Java
- Separation of Concerns
- Custom Exceptions
- Object-Oriented Design
- Map as in-memory database
- Clean exception propagation (Service → UI)

---

## 🔮 Future Scope (JDBC Integration)

This project is intentionally designed to support easy migration to a database.

Future enhancements:

- Replace `HashMap` with **JDBC + MySQL**
- Add Transaction History
- Add Login for Admin/User
- Add Input Validation
- Add File Logging
- Convert to GUI / Web App

Only the **Repository layer** needs modification for JDBC.


## 📌 Requirements

- Java 8 or above
- Any Java IDE

---

## 👨‍💻 Author

**Bhushan Khandait**  
GitHub: https://github.com/khandaitBhushan  
LinkedIn: https://www.linkedin.com/in/khandaitbhushan

---
```

