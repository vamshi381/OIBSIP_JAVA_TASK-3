# ATM Interface

A console-based ATM Machine simulation developed using **Java and Object-Oriented Programming (OOP)** concepts.

The application allows users to securely log in using a User ID and PIN and perform common banking operations such as checking transaction history, withdrawing money, depositing money, and transferring money between accounts.

---

## 📌 Project Overview

The ATM Interface is a Java console application designed to simulate the basic functionality of an ATM.

The project demonstrates important Java and OOP concepts including:

* Classes and Objects
* Encapsulation
* Constructors
* Methods
* ArrayList
* Collections
* Switch-case
* Exception Handling
* User Authentication
* Transaction Management
* Date and Time API
* Object-oriented design

---

## ✨ Features

### 1. User Authentication

* User enters User ID and PIN.
* The system validates the credentials.
* Users are given a maximum of **3 login attempts**.
* Access is denied after three incorrect attempts.

### 2. Transaction History

Users can view all transactions performed during the current session.

The history displays:

* Transaction type
* Amount
* Description
* Date and time
* Current account balance

### 3. Withdraw

Users can withdraw money from their account.

The system:

* Accepts the withdrawal amount.
* Checks whether the account has sufficient balance.
* Displays **"Insufficient Funds"** when the balance is too low.
* Updates the account balance.
* Records the transaction.

### 4. Deposit

Users can deposit money into their account.

The system:

* Accepts the deposit amount.
* Updates the account balance.
* Records the deposit in transaction history.

### 5. Transfer

Users can transfer money to another account.

The system:

* Accepts the recipient account ID.
* Validates whether the recipient exists.
* Checks the sender's balance.
* Prevents transfers to the same account.
* Deducts money from the sender.
* Adds money to the recipient.
* Records the transfer for both accounts.

### 6. Quit

Users can safely exit the ATM application.

A goodbye message is displayed before the application terminates.

---

## 🛠️ Technologies Used

| Technology       | Purpose                           |
| ---------------- | --------------------------------- |
| Java             | Application development           |
| Java OOP         | Object-oriented design            |
| ArrayList        | Storing accounts and transactions |
| Java Collections | Managing application data         |
| LocalDateTime    | Transaction date and time         |
| IntelliJ IDEA    | Development environment           |
| JDK 21           | Java runtime and development      |

---

## 📂 Project Structure

```text
ATM-INTERFACE/
│
├── src/
│   └── atm/
│       ├── Main.java
│       ├── ATM.java
│       ├── Bank.java
│       ├── Account.java
│       └── Transaction.java
│
└── README.md
```

---

## 🏗️ Class Responsibilities

### Main.java

The entry point of the application.

Responsibilities:

* Creates the `Bank` object.
* Creates the `ATM` object.
* Starts the ATM application.

---

### ATM.java

Handles the main ATM functionality.

Responsibilities:

* User authentication
* Login attempt management
* Displaying the ATM menu
* Withdrawals
* Deposits
* Transfers
* Transaction history
* Exiting the application

---

### Bank.java

Manages the bank's accounts.

Responsibilities:

* Store multiple accounts.
* Find an account using the account ID.
* Authenticate users using User ID and PIN.
* Add new accounts.

---

### Account.java

Represents an individual bank account.

Stores:

* Account ID
* Account holder name
* PIN
* Balance
* Transaction history

Responsibilities:

* Deposit money
* Withdraw money
* Store transactions

---

### Transaction.java

Represents an individual transaction.

Stores:

* Transaction type
* Transaction amount
* Description
* Date and time

---

## 🔐 Sample Login Credentials

The application contains three sample accounts for testing.

### Account 1

```text
User ID: 1001
PIN: 1234
Name: Vamshi
Balance: ₹10,000
```

### Account 2

```text
User ID: 1002
PIN: 2345
Name: Rahul
Balance: ₹8,000
```

### Account 3

```text
User ID: 1003
PIN: 3456
Name: Suresh
Balance: ₹15,000
```

---

## ▶️ How to Run

### Prerequisites

Make sure you have:

* JDK 21 or later
* IntelliJ IDEA

### Steps

1. Clone or download the project.
2. Open the project in IntelliJ IDEA.
3. Make sure the JDK is configured.
4. Open:

```text
src/atm/Main.java
```

5. Right-click `Main.java`.
6. Select **Run 'Main.main()'**.
7. Enter the User ID and PIN.

---

## 💻 Application Flow

```text
Start
  │
  ▼
Enter User ID
  │
  ▼
Enter PIN
  │
  ├── Invalid → Retry
  │
  └── 3 Failed Attempts → Access Denied
  │
  ▼
Successful Login
  │
  ▼
ATM Menu
  │
  ├── 1. Transaction History
  │
  ├── 2. Withdraw
  │
  ├── 3. Deposit
  │
  ├── 4. Transfer
  │
  └── 5. Quit
```

---

## 🧪 Example

After successful login:

```text
==========================================
              ATM MENU
==========================================
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
==========================================
Enter your choice:
```

Example withdrawal:

```text
Enter your choice: 2

==========================================
              WITHDRAW
==========================================

Enter withdrawal amount: ₹2000

Withdrawal successful!
Amount Withdrawn: ₹2000.00
Remaining Balance: ₹8000.00
```

Example insufficient balance:

```text
Enter withdrawal amount: ₹20000

Insufficient Funds
Available Balance: ₹8000.00
```

---

## 🧠 OOP Concepts Demonstrated

### Encapsulation

Account information is protected using private fields.

```text
private double balance;
private String accountId;
private String name;
```

Access is provided through methods such as getters and business methods.

### Objects

The application creates objects such as:

```text
Bank
ATM
Account
Transaction
```

### ArrayList

Transactions are stored using:

```text
ArrayList<Transaction>
```

This allows multiple transactions to be maintained for each account.

### Composition

An `Account` contains its transaction history.

### Abstraction

The user interacts with ATM operations without needing to know the internal implementation.

---

## 📋 Requirements Implemented

| Requirement                    | Status |
| ------------------------------ | ------ |
| User ID and PIN authentication | ✅      |
| Maximum 3 incorrect attempts   | ✅      |
| Transaction History            | ✅      |
| Withdraw                       | ✅      |
| Deposit                        | ✅      |
| Transfer                       | ✅      |
| Balance validation             | ✅      |
| Insufficient Funds message     | ✅      |
| ArrayList transaction history  | ✅      |
| Multiple accounts              | ✅      |
| OOP design                     | ✅      |
| Five Java classes              | ✅      |
| Console application            | ✅      |
| Quit option                    | ✅      |

---

## 🚀 Future Enhancements

The current application is a console-based simulation. It can be extended in the future with:

* Database integration using MySQL
* JDBC
* User registration
* Account creation
* PIN change
* Balance inquiry
* ATM cash denomination management
* Admin panel
* Login security improvements
* GUI using Java Swing or JavaFX
* Transaction persistence
* Receipt generation

---

## 👨‍💻 Author

**Vamshi**

Java Full Stack Developer — Fresher

### Skills Demonstrated

* Core Java
* Object-Oriented Programming
* Collections
* Exception Handling
* Java Date & Time API
* Console Application Development

---

## 📄 License

This project is created for **educational and portfolio purposes**.
