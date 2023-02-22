package flowershop.domain;

/**
 * The Tree class represents a type of product that is a tree, with a name, height, price and quantity.
 * It extends the class Product.
 */
public class Tree extends Product {
    private final double height;

    public Tree(String name, double height, double price, int quantity) {
        super(name, price, quantity);
        this.height = height;

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
    public void changeSumQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    /**
     * Subtracts a quantity from the Tree's total quantity.
     * @param quantity the quantity to be subtracted.
     */
    @Override
    public void changeSubstractQuantity(int quantity) {
        this.quantity = this.quantity - quantity;
    }

    public String toString() {

        return "- Tree. Type: " + super.getName()
                + "\nID: " + super.productId
                + ". Height: " + this.height
                + ". Total amount " + super.getQuantity()
                + ". Price per unit: " + super.getPrice();
    }

}





