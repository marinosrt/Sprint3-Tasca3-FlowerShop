package FlowerShop.domain;

import FlowerShop.repository.ReadWriteTxt;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The Decoration class represents a type of product that is a decoration, with a name, material, price and quantity.
 * It extends the class Product.
 */
public class Decoration extends Product {
    private String material;
    private static long idCounter = updateID();


    public Decoration(String name, String material, double price, int quantity) {
        super(name, price, quantity);
        this.material = material;
        idCounter = updateID() + 1;
        super.productId = idCounter;
    }

    /**
     * Updates the ID of the Decoration by getting the maximum ID from the productList and adding 1.
     * @return the new ID.
     */
    public static long updateID() {
        List<Product> productList;
        AtomicLong newID = new AtomicLong();

        productList = ReadWriteTxt.readProductFile();

        if (productList != null) {
            productList.stream()
                    .filter(product -> product.getClass().equals(Decoration.class))
                    .reduce((first, second) -> second)
                    .ifPresent(product -> {
                        newID.set(product.getProductId());
                    });
            return newID.longValue();
        } else {
            return 0;
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    public String toString() {

        return "- Decoration. Type: " + super.getName()
                + "\nID: " + super.productId
                + ". Material: " + this.material
                + ". Total amount: " + super.getQuantity()
                + ". Price per unit: " + super.getPrice();
    }

}

