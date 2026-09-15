package model;

public class Table {
    private int tableId;
    private int capacity;
    private String status; // AVAILABLE or BOOKED

    public Table(int tableId, int capacity) {
        this.tableId = tableId;
        this.capacity = capacity;
        this.status = "AVAILABLE";
    }

    public int getTableId() {
        return tableId;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return status.equals("AVAILABLE");
    }

    @Override
    public String toString() {
        return "Table #" + tableId + " | Capacity: " + capacity + " | Status: " + status;
    }
}
