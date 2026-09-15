import model.Bill;
import model.MenuItem;
import model.Order;
import model.Reservation;
import model.Table;
import service.BillingService;
import service.OrderService;
import service.ReservationService;
import util.Validator;
import data.FileStorage;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ReservationService reservationService = new ReservationService();
    private static OrderService orderService = new OrderService();
    private static BillingService billingService = new BillingService();

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" RESTAURANT TABLE RESERVATION & BILLING ");
        System.out.println("=========================================");

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    viewAvailableTables();
                    break;
                case 2:
                    bookTableFlow();
                    break;
                case 3:
                    cancelReservationFlow();
                    break;
                case 4:
                    takeOrderFlow();
                    break;
                case 5:
                    viewAllOrders();
                    break;
                case 6:
                    generateBillFlow();
                    break;
                case 7:
                    markBillPaidFlow();
                    break;
                case 8:
                    viewAllReservations();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("----------------- MENU -----------------");
        System.out.println("1. View Available Tables");
        System.out.println("2. Book a Table");
        System.out.println("3. Cancel Reservation");
        System.out.println("4. Take Order for a Table");
        System.out.println("5. View All Orders");
        System.out.println("6. Generate Bill");
        System.out.println("7. Mark Bill as Paid");
        System.out.println("8. View All Reservations");
        System.out.println("0. Exit");
        System.out.println("-----------------------------------------");
    }

    // ---------------- Table Reservation Module ----------------

    private static void viewAvailableTables() {
        System.out.println("--- Available Tables ---");
        List<Table> available = reservationService.getAvailableTables();
        if (available.isEmpty()) {
            System.out.println("No tables currently available.");
        } else {
            for (Table t : available) {
                System.out.println(t);
            }
        }
    }

    private static void bookTableFlow() {
        System.out.println("--- Book a Table ---");
        viewAvailableTables();
        int tableId = readInt("Enter Table ID to book: ");

        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        if (!Validator.isValidName(name)) {
            System.out.println("Error: Invalid name.");
            return;
        }

        System.out.print("Enter Customer Phone (10 digits): ");
        String phone = scanner.nextLine();
        if (!Validator.isValidPhone(phone)) {
            System.out.println("Error: Invalid phone number, must be 10 digits.");
            return;
        }

        System.out.print("Enter Reservation Time (e.g., 7:30 PM): ");
        String time = scanner.nextLine();
        if (!Validator.isValidTimeFormat(time)) {
            System.out.println("Error: Invalid time.");
            return;
        }

        reservationService.bookTable(tableId, name, phone, time);
    }

    private static void cancelReservationFlow() {
        System.out.println("--- Cancel Reservation ---");
        viewAllReservations();
        int reservationId = readInt("Enter Reservation ID to cancel: ");
        reservationService.cancelReservation(reservationId);
    }

    private static void viewAllReservations() {
        System.out.println("--- All Reservations ---");
        List<Reservation> reservations = reservationService.getAllReservations();
        if (reservations.isEmpty()) {
            System.out.println("No reservations yet.");
        } else {
            for (Reservation r : reservations) {
                System.out.println(r);
            }
        }
    }

    // ---------------- Order Management Module ----------------

    private static void takeOrderFlow() {
        System.out.println("--- Take Order ---");
        viewAllReservations();
        int reservationId = readInt("Enter Reservation ID to place order for: ");
        Reservation reservation = reservationService.findReservationById(reservationId);
        if (reservation == null || !reservation.getStatus().equals("ACTIVE")) {
            System.out.println("Error: Active reservation not found.");
            return;
        }

        Order order = orderService.createOrder(reservation);

        boolean addingItems = true;
        while (addingItems) {
            System.out.println("--- Menu ---");
            for (MenuItem item : orderService.getMenu()) {
                System.out.println(item);
            }
            int itemId = readInt("Enter Menu Item ID to add (0 to finish): ");
            if (itemId == 0) {
                addingItems = false;
                break;
            }
            int qty = readInt("Enter Quantity: ");
            orderService.addItemToOrder(order, itemId, qty);
        }

        orderService.finalizeOrder(order);
        System.out.println(order);
    }

    private static void viewAllOrders() {
        System.out.println("--- All Orders ---");
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            for (Order o : orders) {
                System.out.println(o);
                System.out.println();
            }
        }
    }

    // ---------------- Billing Module ----------------

    private static void generateBillFlow() {
        System.out.println("--- Generate Bill ---");
        viewAllOrders();
        int orderId = readInt("Enter Order ID to generate bill for: ");
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            System.out.println("Error: Order not found.");
            return;
        }

        System.out.print("Apply 10% loyalty discount? (y/n): ");
        String choice = scanner.nextLine();
        boolean applyDiscount = choice.trim().equalsIgnoreCase("y");

        Bill bill = billingService.generateBill(order, applyDiscount);
        if (bill != null) {
            System.out.println(bill);
            FileStorage.appendToFile(bill.toString());
        }
    }

    private static void markBillPaidFlow() {
        System.out.println("--- Mark Bill as Paid ---");
        List<Bill> bills = billingService.getAllBills();
        if (bills.isEmpty()) {
            System.out.println("No bills generated yet.");
            return;
        }
        for (Bill b : bills) {
            System.out.println(b);
        }
        int billId = readInt("Enter Bill ID to mark as paid: ");
        boolean success = billingService.markBillPaid(billId);
        if (success) {
            Bill bill = billingService.findBillById(billId);
            // free the table once payment is done
            int tableId = bill.getOrder().getReservation().getTable().getTableId();
            reservationService.freeTable(tableId);
            System.out.println("Table #" + tableId + " is now available again.");
        }
    }

    // ---------------- Helper ----------------

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            System.out.print(prompt);
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
}
