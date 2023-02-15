package FlowerShop.domain;

public class Decoration extends Product {
    private String material;
    private static long idCounter = 1;
    private long decorationId;


    public Decoration(String name, double price, int quantity, String material) {
        super(name, price, quantity);
        this.material = material;
        this.decorationId = idCounter;
        idCounter++;

    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String toString() {

        return "id: " + decorationId + ", material: " + material;

    }

}

