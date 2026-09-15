package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Reservation reservation;
    private List<OrderItem> items;
    private String status; // OPEN or FINALIZED

    public Order(int orderId, Reservation reservation) {
        this.orderId = orderId;
        this.reservation = reservation;
        this.items = new ArrayList<>();
        this.status = "OPEN";
    }

    public int getOrderId() {
        return orderId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.getLineTotal();
        }
        return subtotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderId)
          .append(" | Table #").append(reservation.getTable().getTableId())
          .append(" | Customer: ").append(reservation.getCustomerName())
          .append(" | Status: ").append(status).append("\n");
        for (OrderItem item : items) {
            sb.append("   - ").append(item).append("\n");
        }
        sb.append("   Subtotal: Rs. ").append(getSubtotal());
        return sb.toString();
    }
}
