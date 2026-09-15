package service;

import model.Bill;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class BillingService {
    private List<Bill> bills;
    private int nextBillId;

    public BillingService() {
        bills = new ArrayList<>();
        nextBillId = 1;
    }

    public Bill generateBill(Order order, boolean applyDiscount) {
        if (order.getItems().isEmpty()) {
            System.out.println("Error: Cannot generate bill for an empty order.");
            return null;
        }
        Bill bill = new Bill(nextBillId++, order, applyDiscount);
        bills.add(bill);
        return bill;
    }

    public boolean markBillPaid(int billId) {
        for (Bill b : bills) {
            if (b.getBillId() == billId) {
                b.markPaid();
                System.out.println("Bill #" + billId + " marked as PAID.");
                return true;
            }
        }
        System.out.println("Error: Bill not found.");
        return false;
    }

    public List<Bill> getAllBills() {
        return bills;
    }

    public Bill findBillById(int billId) {
        for (Bill b : bills) {
            if (b.getBillId() == billId) {
                return b;
            }
        }
        return null;
    }
}
