package FlowerShop.domain;

import java.io.Serializable;

/**
 * The Product class represents any product sold in the flower shop.
 * It works as the superclass of Decoration, Tree and Flower.
 */
public class Product implements Serializable {

    protected String name;
    protected double price;
    protected int quantity;
    protected long productId;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

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

    /**
     * Adds a quantity to the Tree's total quantity.
     * @param quantity the quantity to be added.
     */
    public void changeSUMquantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    /**
     * Subtracts a quantity from the Tree's total quantity.
     * @param quantity the quantity to be subtracted.
     */
    public void changeRESTquantity(int quantity) {
        this.quantity = this.quantity - quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){

        return "name:" + name + ", price:" + price + ", quantity:" + quantity;

    }

}