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
<img width="1920" height="1080" alt="Screenshot (1220)" src="https://github.com/user-attachments/assets/5b72916e-7b59-4269-ae5e-74e99b8961f5" />
<img width="1920" height="1080" alt="Screenshot (1219)" src="https://github.com/user-attachments/assets/b599f95c-f42a-4c59-96bc-3909453736c4" />
<img width="1920" height="1080" alt="Screenshot (1218)" src="https://github.com/user-attachments/assets/5a5bb8d1-36fd-4159-81b7-92585a0813aa" />
<img width="1920" height="1080" alt="Screenshot (1217)" src="https://github.com/user-attachments/assets/0e75761b-10da-4e8d-8803-8d68f079fe66" />
<img width="1920" height="1080" alt="Screenshot (1216)" src="https://github.com/user-attachments/assets/1e209e93-4531-41da-8bf2-3cee1b388689" />
<img width="1920" height="1080" alt="Screenshot (1215)" src="https://github.com/user-attachments/assets/b7343311-82a0-4f3c-9f8e-51b17300297c" />
<img width="1920" height="1080" alt="Screenshot (1214)" src="https://github.com/user-attachments/assets/47a52c41-a568-4b25-8d8b-d85eb21c2d3e" />
<img width="1920" height="1080" alt="Screenshot (1213)" src="https://github.com/user-attachments/assets/3e33afbf-ec1d-4a18-919c-15293314c45b" />
<img width="1920" height="1080" alt="Screenshot (1212)" src="https://github.com/user-attachments/assets/63d9cf40-9145-4594-8eee-981b966e0725" />
<img width="1920" height="1080" alt="Screenshot (1211)" src="https://github.com/user-attachments/assets/79160056-972a-4350-90f6-c15c866147c6" />
<img width="1920" height="1080" alt="Screenshot (1210)" src="https://github.com/user-attachments/assets/b9bd57d1-d014-455d-ba9e-096d208763d5" />
<img width="1920" height="1080" alt="Screenshot (1209)" src="https://github.com/user-attachments/assets/c01659cb-f423-4026-9b1d-cbf1ecdb52ae" />
<img width="1920" height="1080" alt="Screenshot (1208)" src="https://github.com/user-attachments/assets/85da1ed9-ef15-4a29-81fa-a00d1f8331a6" />
<img width="1920" height="1080" alt="Screenshot (1207)" src="https://github.com/user-attachments/assets/85729fbf-6810-4174-95d9-f8c801ab16bf" />



