package flowershop.domain;

import flowershop.repository.ReadWriteTxt;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The Product class represents any product sold in the flower shop.
 * It works as the superclass of Decoration, Tree and Flower.
 */
public class Product implements Serializable {

    protected String name;
    protected double price;
    protected int quantity;
    protected long productId;
    private static long idCounter = updateID();

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        idCounter++;
        this.productId = idCounter;

    }

    public static long updateID() {
        List<Product> productList;
        AtomicLong newID = new AtomicLong(0);

        productList = ReadWriteTxt.readProductFile();

        if (productList != null) {

            productList.stream().reduce((first, second) -> second)
                    .ifPresent(product -> newID.set(product.getProductId()));

        }
        return newID.longValue();
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



    /**
     * Adds a quantity to the Tree's total quantity.
     * @param quantity the quantity to be added.
     */
    public void changeSumQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    /**
     * Subtracts a quantity from the Tree's total quantity.
     * @param quantity the quantity to be subtracted.
     */
    public void changeSubstractQuantity(int quantity) {
        this.quantity = this.quantity - quantity;
    }

    @Override
    public String toString(){

        return "name:" + name + ", price:" + price + ", quantity:" + quantity;

    }

}