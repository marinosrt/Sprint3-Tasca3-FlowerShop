
package FlowerShop.domain;

public class Flower extends Product {
    private String color;
    private static long idCounter = 1;
    private long flowerId;


    public Flower(String name, String color, double price, int quantity) {
        super(name, price, quantity);
        this.color = color;
        this.flowerId = idCounter;
        idCounter++;

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
                "ID: " + this.flowerId
                + ". Color: " + this.color
                + ". Amount: " + super.getQuantity()
                + ". Price: " + super.getPrice();

    }

}

