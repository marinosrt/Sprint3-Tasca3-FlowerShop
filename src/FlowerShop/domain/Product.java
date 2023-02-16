package FlowerShop.domain;

import FlowerShop.repository.ReadWriteTxt;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Product implements Serializable {

    protected String name;
    protected double price;
    protected int quantity;

    protected long productId;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){

        return "name:" + name + ", price:" + price + ", quantity:" + quantity;

    }
}