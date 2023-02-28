package flowershop.domain;

import flowershop.repository.ReadWriteTxt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Ticket implements Serializable {
    private List<Product> products;
    protected long ticketId;
    private static long idCounter = updateID();

    public Ticket() {
        this.products = new ArrayList<>();
        idCounter++;
        this.ticketId = idCounter;
    }

    public static long updateID() {
        List<Ticket> ticketList;
        AtomicLong newID = new AtomicLong(0);

        ticketList = ReadWriteTxt.readTicketFile();

        if (ticketList != null) {

            ticketList.stream().reduce((first, second) -> second)
                    .ifPresent(ticket -> newID.set(ticket.getTicketId()));

        }
        return newID.longValue();
    }

    public void addProduct(String name, double price, int quantity) {
        this.products.add(new Product(name, price, quantity));
    }

    public long getTicketId() {
        return ticketId;
    }

    public double getTotalValue() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ticket ID " + ticketId + " { \n");
        for (Product p : products) {
            sb.append("  ").append(p.getName()).append(" (x").append(p.getQuantity()).append("): ").append(p.getPrice()).append("\n");
        }
        sb.append("  ---Total: ").append(getTotalValue()).append("€\n}");

        return sb.toString();
    }


}

