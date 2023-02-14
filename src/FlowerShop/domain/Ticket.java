package FlowerShop.domain;

import java.util.ArrayList;

class Ticket {
    private ArrayList<Product> products;
    private double totalValue;

    public Ticket() {
        this.products = new ArrayList<Product>();
        this.totalValue = 0;
    }

    public void addProduct(Product p) {
        products.add(p);
        totalValue += p.getPrice();
    }

    public void removeProduct(Product p) {
        products.remove(p);
        totalValue -= p.getPrice();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotalValue() {
        return totalValue;
    }
}
