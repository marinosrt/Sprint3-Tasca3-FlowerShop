
package FlowerShop.domain;

public class Flower extends Product {
    private String color;
    private static long idCounter = 1;
    private long flowerId;


    public Flower(String name, double price, int quantity, String material) {
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

    public String toString() {

        return "id: " + flowerId + ", color: " + color;

    }

}

