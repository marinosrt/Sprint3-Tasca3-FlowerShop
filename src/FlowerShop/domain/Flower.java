
package FlowerShop.domain;

import FlowerShop.repository.ReadWriteTxt;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The Flower class represents a type of product that is a flower, with a name, color, price and quantity.
 * It extends the class Product.
 */
public class Flower extends Product {
    private String color;
    private static long idCounter = 1;


    public Flower(String name, String color, double price, int quantity) {
        super(name, price, quantity);
        this.color = color;
        idCounter = updateID() + 1;
        super.productId = idCounter;
    }

    /**
     * Updates the ID of the Flower by getting the maximum ID from the productList and adding 1.
     * @return the new ID.
     */
    public static long updateID() {
        List<Product> productList;
        AtomicLong newID = new AtomicLong();

        productList = ReadWriteTxt.readProductFile();

        if (productList != null) {
            productList.stream()
                    .filter(product -> product.getClass().equals(Flower.class))
                    .reduce((first, second) -> second)
                    .ifPresent(product -> {
                        newID.set(product.getProductId());
                    });
            return newID.longValue();
        } else {
            return 0;
        }
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Adds a quantity to the Tree's total quantity.
     * @param quantity the quantity to be added.
     */
    @Override
    public void changeSUMquantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    /**
     * Subtracts a quantity from the Tree's total quantity.
     * @param quantity the quantity to be subtracted.
     */
    @Override
    public void changeRESTquantity(int quantity) {
        this.quantity = this.quantity - quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {

        return "- Flower. Type: " + super.getName() + "\n" +
                "ID: " + super.productId
                + ". Color: " + this.color
                + ". Total amount: " + super.getQuantity()
                + ". Price per unit: " + super.getPrice();
    }

}

