package model;

public class Bill {
    private int billId;
    private Order order;
    private double subtotal;
    private double taxAmount;
    private double discountAmount;
    private double total;
    private String paymentStatus; // PAID or UNPAID

    private static final double TAX_RATE = 0.05;      // 5% tax
    private static final double DISCOUNT_RATE = 0.10;  // 10% discount if applicable

    public Bill(int billId, Order order, boolean applyDiscount) {
        this.billId = billId;
        this.order = order;
        this.subtotal = order.getSubtotal();
        this.taxAmount = subtotal * TAX_RATE;
        this.discountAmount = applyDiscount ? (subtotal * DISCOUNT_RATE) : 0;
        this.total = subtotal + taxAmount - discountAmount;
        this.paymentStatus = "UNPAID";
    }

    public int getBillId() {
        return billId;
    }

    public Order getOrder() {
        return order;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getTotal() {
        return total;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void markPaid() {
        this.paymentStatus = "PAID";
    }

    @Override
    public String toString() {
        return "----- BILL #" + billId + " -----\n" +
                "Customer: " + order.getReservation().getCustomerName() + "\n" +
                "Table #: " + order.getReservation().getTable().getTableId() + "\n" +
                "Subtotal: Rs. " + String.format("%.2f", subtotal) + "\n" +
                "Tax (5%): Rs. " + String.format("%.2f", taxAmount) + "\n" +
                "Discount: Rs. " + String.format("%.2f", discountAmount) + "\n" +
                "TOTAL: Rs. " + String.format("%.2f", total) + "\n" +
                "Payment Status: " + paymentStatus + "\n" +
                "-------------------------";
    }
}
