package service;

import model.Reservation;
import model.Table;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private List<Table> tables;
    private List<Reservation> reservations;
    private int nextReservationId;

    public ReservationService() {
        tables = new ArrayList<>();
        reservations = new ArrayList<>();
        nextReservationId = 1;
        initializeTables();
    }

    // Sample data - modify counts/capacities as needed
    private void initializeTables() {
        tables.add(new Table(1, 2));
        tables.add(new Table(2, 2));
        tables.add(new Table(3, 4));
        tables.add(new Table(4, 4));
        tables.add(new Table(5, 6));
        tables.add(new Table(6, 8));
    }

    public List<Table> getAllTables() {
        return tables;
    }

    public List<Table> getAvailableTables() {
        List<Table> available = new ArrayList<>();
        for (Table t : tables) {
            if (t.isAvailable()) {
                available.add(t);
            }
        }
        return available;
    }

    public Table findTableById(int tableId) {
        for (Table t : tables) {
            if (t.getTableId() == tableId) {
                return t;
            }
        }
        return null;
    }

    public Reservation bookTable(int tableId, String customerName, String customerPhone, String time) {
        Table table = findTableById(tableId);
        if (table == null) {
            System.out.println("Error: Table not found.");
            return null;
        }
        if (!table.isAvailable()) {
            System.out.println("Error: Table #" + tableId + " is already booked.");
            return null;
        }
        table.setStatus("BOOKED");
        Reservation reservation = new Reservation(nextReservationId++, table, customerName, customerPhone, time);
        reservations.add(reservation);
        System.out.println("Success: Table #" + tableId + " booked for " + customerName + ".");
        return reservation;
    }

    public boolean cancelReservation(int reservationId) {
        for (Reservation r : reservations) {
            if (r.getReservationId() == reservationId && r.getStatus().equals("ACTIVE")) {
                r.setStatus("CANCELLED");
                r.getTable().setStatus("AVAILABLE");
                System.out.println("Reservation #" + reservationId + " cancelled. Table freed.");
                return true;
            }
        }
        System.out.println("Error: Active reservation not found.");
        return false;
    }

    public void freeTable(int tableId) {
        Table table = findTableById(tableId);
        if (table != null) {
            table.setStatus("AVAILABLE");
        }
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public Reservation findReservationById(int reservationId) {
        for (Reservation r : reservations) {
            if (r.getReservationId() == reservationId) {
                return r;
            }
        }
        return null;
    }
}
