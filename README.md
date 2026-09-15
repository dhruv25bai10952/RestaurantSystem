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
<img width="1920" height="1080" alt="Screenshot (1207)" src="https://github.com/user-attachments/assets/07db5a87-3ccb-47e3-b43a-4e7cb36d0f43" />
<img width="1920" height="1080" alt="Screenshot (1208)" src="https://github.com/user-attachments/assets/36cae504-7b04-4024-9b32-0da9c31ed09f" />
<img width="1920" height="1080" alt="Screenshot (1209)" src="https://github.com/user-attachments/assets/40095eca-0785-4eee-8e6e-a46f2d8a3c37" />
<img width="1920" height="1080" alt="Screenshot (1210)" src="https://github.com/user-attachments/assets/795995b2-1bec-4735-b050-3212342bcd27" />
<img width="1920" height="1080" alt="Screenshot (1211)" src="https://github.com/user-attachments/assets/b6f16444-4265-41f7-991b-d9ab6f40564b" />
<img width="1920" height="1080" alt="Screenshot (1212)" src="https://github.com/user-attachments/assets/f8cfb732-b19b-40cf-82e0-28cc270b4bcc" />
<img width="1920" height="1080" alt="Screenshot (1213)" src="https://github.com/user-attachments/assets/9a409a32-2610-43cd-8d83-1aa5931f0939" />
<img width="1920" height="1080" alt="Screenshot (1214)" src="https://github.com/user-attachments/assets/f75e3b14-8154-43fd-bb83-bfdc90d8d04a" />
<img width="1920" height="1080" alt="Screenshot (1215)" src="https://github.com/user-attachments/assets/0443bb37-b77a-4d4d-ae67-5e8789d12a98" />
<img width="1920" height="1080" alt="Screenshot (1216)" src="https://github.com/user-attachments/assets/5c2c13f2-083b-42e1-93f4-1a553de6a20f" />
<img width="1920" height="1080" alt="Screenshot (1217)" src="https://github.com/user-attachments/assets/bb1e4494-f1fd-4e95-8308-122544f7a0f8" />
<img width="1920" height="1080" alt="Screenshot (1218)" src="https://github.com/user-attachments/assets/fa7067fd-870d-4d8d-b120-4786558538ff" />
<img width="1920" height="1080" alt="Screenshot (1219)" src="https://github.com/user-attachments/assets/7bf2636d-c176-4d35-b7b1-43e2c23cee86" />
<img width="1920" height="1080" alt="Screenshot (1220)" src="https://github.com/user-attachments/assets/a22f81ae-0b58-49a1-8864-c23490df4ad9" />




