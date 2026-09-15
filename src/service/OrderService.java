package service;

import model.MenuItem;
import model.Order;
import model.OrderItem;
import model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<MenuItem> menu;
    private List<Order> orders;
    private int nextOrderId;

    public OrderService() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
        nextOrderId = 1;
        initializeMenu();
    }

    // Sample menu data - modify items/prices as needed
    private void initializeMenu() {
        menu.add(new MenuItem(1, "Paneer Butter Masala", 220.0));
        menu.add(new MenuItem(2, "Dal Makhani", 180.0));
        menu.add(new MenuItem(3, "Veg Biryani", 200.0));
        menu.add(new MenuItem(4, "Butter Naan", 40.0));
        menu.add(new MenuItem(5, "Masala Papad", 60.0));
        menu.add(new MenuItem(6, "Cold Drink", 50.0));
        menu.add(new MenuItem(7, "Gulab Jamun (2 pcs)", 70.0));
        menu.add(new MenuItem(8, "Paneer Tikka", 210.0));
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public MenuItem findMenuItemById(int itemId) {
        for (MenuItem m : menu) {
            if (m.getItemId() == itemId) {
                return m;
            }
        }
        return null;
    }

    public Order createOrder(Reservation reservation) {
        Order order = new Order(nextOrderId++, reservation);
        orders.add(order);
        System.out.println("New order #" + order.getOrderId() + " started for Table #"
                + reservation.getTable().getTableId());
        return order;
    }

    public boolean addItemToOrder(Order order, int menuItemId, int quantity) {
        if (order.getStatus().equals("FINALIZED")) {
            System.out.println("Error: Order already finalized, cannot add items.");
            return false;
        }
        MenuItem item = findMenuItemById(menuItemId);
        if (item == null) {
            System.out.println("Error: Menu item not found.");
            return false;
        }
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be greater than zero.");
            return false;
        }
        order.addItem(new OrderItem(item, quantity));
        System.out.println("Added: " + item.getName() + " x " + quantity);
        return true;
    }

    public void finalizeOrder(Order order) {
        order.setStatus("FINALIZED");
        System.out.println("Order #" + order.getOrderId() + " finalized.");
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order findOrderById(int orderId) {
        for (Order o : orders) {
            if (o.getOrderId() == orderId) {
                return o;
            }
        }
        return null;
    }
}
