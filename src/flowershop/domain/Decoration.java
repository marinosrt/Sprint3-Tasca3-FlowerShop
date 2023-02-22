package flowershop.domain;

/**
 * The Decoration class represents a type of product that is a decoration, with a name, material, price and quantity.
 * It extends the class Product.
 */
public class Decoration extends Product {
    private final String material;

    public Decoration(String name, String material, double price, int quantity) {
        super(name, price, quantity);
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

        return "- Decoration. Type: " + super.getName()
                + "\nID: " + super.productId
                + ". Material: " + this.material
                + ". Total amount: " + super.getQuantity()
                + ". Price per unit: " + super.getPrice();
    }
}

