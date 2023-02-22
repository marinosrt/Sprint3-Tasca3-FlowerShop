package FlowerShop.domain;


import FlowerShop.repository.ReadWriteTxt;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The Tree class represents a type of product that is a tree, with a name, height, price and quantity.
 * It extends the class Product.
 */
public class Tree extends Product {
    private double height;
    private static long idCounter;


    public Tree(String name, double height, double price, int quantity) {
        super(name, price, quantity);
        this.height = height;
        idCounter = updateID() + 1;
        super.productId = idCounter;
    }

    /**
     * Updates the ID of the Tree by getting the maximum ID from the productList and adding 1.
     * @return the new ID.
     */
    public static long updateID(){
        List<Product> productList;
        AtomicLong newID = new AtomicLong();

        productList = ReadWriteTxt.readProductFile();

        if (productList != null){
            productList.stream()
                    .filter(product -> product.getClass().equals(Tree.class))
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {

        return "- Tree. Type: " + super.getName()
                + "\nID: " + super.productId
                + ". Height: " + this.height
                + ". Total amount " + super.getQuantity()
                + ". Price per unit: " + super.getPrice();
    }

}





