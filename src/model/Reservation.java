package model;

public class Reservation {
    private int reservationId;
    private Table table;
    private String customerName;
    private String customerPhone;
    private String time;
    private String status; // ACTIVE or CANCELLED

    public Reservation(int reservationId, Table table, String customerName, String customerPhone, String time) {
        this.reservationId = reservationId;
        this.table = table;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.time = time;
        this.status = "ACTIVE";
    }

    public int getReservationId() {
        return reservationId;
    }

    public Table getTable() {
        return table;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation #" + reservationId + " | Table #" + table.getTableId()
                + " | Customer: " + customerName + " (" + customerPhone + ")"
                + " | Time: " + time + " | Status: " + status;
    }
}
