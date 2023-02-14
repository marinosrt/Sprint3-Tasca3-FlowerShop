package FlowerShop.domain;

import java.util.ArrayList;
import java.util.List;

public class FlowerShop {
    private String name;
    private List<Ticket> purchases;
    private Stock stock;

    public FlowerShop(String name) {
        this.name = name;
        this.purchases = new ArrayList<>();
        this.stock = new Stock();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Ticket> purchases) {
        this.purchases = purchases;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
