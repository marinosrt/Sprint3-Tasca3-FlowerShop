package FlowerShop.domain;

public class Decoration implements Product {
    private String material;
    private double price;

    public Decoration(String material, double price) {
        this.material = material;
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getType() {
        return "Decoration";
    }
}
