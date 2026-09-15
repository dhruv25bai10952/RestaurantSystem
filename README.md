# RestaurantSystem
# Restaurant Table Reservation & Billing System

A simple console-based Java application that manages restaurant table reservations, food orders, and bill generation.

## Overview

This project simulates the core operations of a small restaurant: booking tables for customers, taking their food orders from a menu, and generating an itemized bill with tax and optional discount. It was built as a course project to demonstrate object-oriented design, modular architecture, and basic file-based persistence in Java.

## Features

- **Table Reservation**
  - View available tables
  - Book a table with customer name, phone number, and reservation time
  - Cancel an existing reservation (frees the table)
  - View all reservations and their status

- **Order Management**
  - Browse a preloaded food menu
  - Add multiple items with quantities to an order
  - Finalize an order once all items are added
  - View all orders placed

- **Billing**
  - Generate a bill from a finalized order
  - Automatic 5% tax calculation
  - Optional 10% loyalty discount
  - Mark bills as paid, which frees up the table again
  - Every generated bill is also logged to `data/transactions_log.txt` for record-keeping

## Technologies / Tools Used

- Java 17+ (tested on JDK 21)
- No external libraries — pure core Java (Collections, File I/O)
- Plain text file for transaction logging
- Version control: Git

## Project Structure

```
RestaurantSystem/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── Table.java
│   │   ├── Reservation.java
│   │   ├── MenuItem.java
│   │   ├── OrderItem.java
│   │   ├── Order.java
│   │   └── Bill.java
│   ├── service/
│   │   ├── ReservationService.java
│   │   ├── OrderService.java
│   │   └── BillingService.java
│   ├── data/
│   │   └── FileStorage.java
│   └── util/
│       └── Validator.java
├── data/
│   └── transactions_log.txt   (created automatically at runtime)
├── README.md
└── statement.md
```

## Steps to Install & Run

### Option A: Run in VS Code
1. Install the **"Extension Pack for Java"** extension in VS Code.
2. Open the `RestaurantSystem` folder in VS Code.
3. Open `src/Main.java` and click the **Run** button above the `main` method.
4. Interact with the console menu in the integrated terminal.

### Option B: Run via command line
```bash
# From the RestaurantSystem/ directory
mkdir out
javac -d out $(find src -name "*.java")
java -cp out Main
```

## Instructions for Testing

1. Start the application.
2. Choose **1** to view available tables.
3. Choose **2** to book a table (enter table ID, customer name, 10-digit phone number, and time).
4. Choose **4** to take an order for the reservation you just created — add one or more menu items, then enter `0` to finish.
5. Choose **6** to generate the bill for that order (choose whether to apply the loyalty discount).
6. Choose **7** to mark the bill as paid — this frees up the table again.
7. Choose **8** or **5** anytime to review all reservations/orders.
8. Choose **0** to exit.



## Screenshots
<img width="1920" height="1080" alt="Screenshot (1220)" src="https://github.com/user-attachments/assets/51e1e05d-a31e-4a8f-b73c-40d7d41abca9" />
<img width="1920" height="1080" alt="Screenshot (1219)" src="https://github.com/user-attachments/assets/9e8b6157-4917-4efe-82de-3b63823a0c55" />
<img width="1920" height="1080" alt="Screenshot (1218)" src="https://github.com/user-attachments/assets/dfad52a2-ee7e-4f5c-b91f-285d5a3a95cd" />
<img width="1920" height="1080" alt="Screenshot (1217)" src="https://github.com/user-attachments/assets/a77147eb-743d-46ed-a6a5-fb47e677f130" />
<img width="1920" height="1080" alt="Screenshot (1216)" src="https://github.com/user-attachments/assets/911dbc9a-d47f-4ad6-8102-6a32757af04d" />
<img width="1920" height="1080" alt="Screenshot (1215)" src="https://github.com/user-attachments/assets/67239edf-75a9-4750-9ec1-078d6190f31c" />
<img width="1920" height="1080" alt="Screenshot (1214)" src="https://github.com/user-attachments/assets/c90ec0e0-f596-4ca8-a620-5c1862fb34de" />
<img width="1920" height="1080" alt="Screenshot (1213)" src="https://github.com/user-attachments/assets/4f033c47-25c0-4f63-a856-3cea41f6fc3a" />
<img width="1920" height="1080" alt="Screenshot (1212)" src="https://github.com/user-attachments/assets/372e99c7-8a9d-42fb-92ea-cb4bb3abdf04" />
<img width="1920" height="1080" alt="Screenshot (1211)" src="https://github.com/user-attachments/assets/b522ce83-da45-4eef-b90f-9329db0df7a9" />
<img width="1920" height="1080" alt="Screenshot (1210)" src="https://github.com/user-attachments/assets/c4e8d6fb-cd6b-451d-be32-678d37453eee" />
<img width="1920" height="1080" alt="Screenshot (1209)" src="https://github.com/user-attachments/assets/e8be9a4f-2c6a-497e-83e0-ea6b0da764a5" />
<img width="1920" height="1080" alt="Screenshot (1208)" src="https://github.com/user-attachments/assets/388720b0-266a-4ffe-b3e6-fe7509a84448" />
<img width="1920" height="1080" alt="Screenshot (1207)" src="https://github.com/user-attachments/assets/cabad71f-5e8d-40e1-a730-2cdedf03cf3a" />


