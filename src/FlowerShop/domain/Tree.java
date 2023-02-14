package FlowerShop.domain;

public class Tree implements Product {
    private double height;
    private double price;

    public Tree(double height, double price) {
        this.height = height;
        this.price = price;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getType() {
        return "Tree";
    }
}
