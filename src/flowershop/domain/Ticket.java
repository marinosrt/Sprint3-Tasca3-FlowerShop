package flowershop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    private List<Product> products;
    protected long ticketId;
    private static long idCounter = 1;

    public Ticket() {
        this.products = new ArrayList<>();
        this.ticketId = idCounter;
        idCounter++;
    }

    public void addProduct(String name, double price, int quantity) {
        this.products.add(new Product(name, price, quantity));
    }

    public double getTotalValue() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ticket ID " + ticketId + " { \n");
        for (Product p : products) {
            sb.append("  ").append(p.getName()).append(" (x").append(p.getQuantity()).append("): ").append(p.getPrice()).append("\n");
        }
        sb.append("  ---Total: ").append(getTotalValue()).append("\n}");

        return sb.toString();
    }


}

