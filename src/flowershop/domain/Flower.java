package flowershop.domain;

/**
 * The Flower class represents a type of product that is a flower, with a name, color, price and quantity.
 * It extends the class Product.
 */
public class Flower extends Product {
    private final String color;

    public Flower(String name, String color, double price, int quantity) {
        super(name, price, quantity);
        this.color = color;

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

    @Override
    public String toString() {

        return "- Flower. Type: " + super.getName() + "\n" +
                "ID: " + super.productId
                + ". Color: " + this.color
                + ". Total amount: " + super.getQuantity()
                + ". Price per unit: " + super.getPrice();
    }
}

