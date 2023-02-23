package flowershop.domain;

import flowershop.repository.ReadWriteTxt;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlowerShop implements Serializable {
    private final String name;
    private List<Ticket> invoices;
    private List<Product> inventory;
    private static FlowerShop instance;

    private FlowerShop(String name) {
        this.name = name;
        this.invoices = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Ticket> getInvoices() {

        invoices = ReadWriteTxt.readTicketFile();
        return invoices;
    }

    public List<Product> getInventory() {
        inventory = ReadWriteTxt.readProductFile();
        return inventory;
    }

    public void removeProductFromInventory(String product) throws IOException {
        ReadWriteTxt.removeProductFromFile(product);
    }

    public void addProductToInventory(Product product) throws IOException {
        ReadWriteTxt.addProduct(product);
    }

    public void addTicketToInvoices(Ticket ticket) throws IOException {
        ReadWriteTxt.addTicket(ticket);
        System.out.println("Your shopping ticket is:\n" + ticket.toString());
    }

    public void updateInventory(List<Product> inventory) throws IOException {
        ReadWriteTxt.updateProduct(inventory);

    }

    public static FlowerShop getInstance(String name) {
        if (instance == null) {
            instance = new FlowerShop(name);
        }
        return instance;
    }

}
