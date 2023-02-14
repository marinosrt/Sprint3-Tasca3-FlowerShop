package FlowerShop.domain;

public class Flower implements Product {
    private String color;
    private double price;

    public Flower(String color, double price) {
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getType() {
        return "Flower";
    }
}
