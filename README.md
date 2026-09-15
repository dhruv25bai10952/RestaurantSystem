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
<img width="1920" height="1080" alt="Screenshot (1220)" src="https://github.com/user-attachments/assets/c1375dd4-4b0a-41d4-b9c7-af54f60a967c" />
<img width="1920" height="1080" alt="Screenshot (1219)" src="https://github.com/user-attachments/assets/8d1866a1-3c89-4d71-bda4-384b6cfd4154" />
<img width="1920" height="1080" alt="Screenshot (1218)" src="https://github.com/user-attachments/assets/d922b62c-20db-42de-8a18-ecca50e770b2" />
<img width="1920" height="1080" alt="Screenshot (1217)" src="https://github.com/user-attachments/assets/1cc36fda-ad9b-42ca-b409-f30c6faf1874" />
<img width="1920" height="1080" alt="Screenshot (1216)" src="https://github.com/user-attachments/assets/6a432c85-0a2a-41a2-aad1-b97383ca1e1b" />
<img width="1920" height="1080" alt="Screenshot (1215)" src="https://github.com/user-attachments/assets/7607fb81-54cd-4903-9fcf-2cb5fa92e367" />
<img width="1920" height="1080" alt="Screenshot (1214)" src="https://github.com/user-attachments/assets/8ad2344b-2985-4aba-8773-7700973fdc3e" />
<img width="1920" height="1080" alt="Screenshot (1213)" src="https://github.com/user-attachments/assets/524512f0-6083-4b8b-8653-87c435a69fd4" />
<img width="1920" height="1080" alt="Screenshot (1212)" src="https://github.com/user-attachments/assets/639def7c-f002-4c70-8123-4aa764133fc3" />
<img width="1920" height="1080" alt="Screenshot (1211)" src="https://github.com/user-attachments/assets/c32919ac-b353-4b3c-886d-de2de678ce6c" />
<img width="1920" height="1080" alt="Screenshot (1210)" src="https://github.com/user-attachments/assets/77e5dd9c-f1fc-4a4c-9a44-51ac18cc02f8" />
<img width="1920" height="1080" alt="Screenshot (1209)" src="https://github.com/user-attachments/assets/9b37e3ca-f773-4cff-ad54-3ac224295c2b" />
<img width="1920" height="1080" alt="Screenshot (1208)" src="https://github.com/user-attachments/assets/c8c150c1-b465-486c-926a-aa3531767d70" />
<img width="1920" height="1080" alt="Screenshot (1207)" src="https://github.com/user-attachments/assets/3f28336f-50f1-478d-95d5-97cd6abf4cbe" />



