package FlowerShop.domain;

import FlowerShop.repository.ReadWriteTxt;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Decoration extends Product {
    private String material;
    private static long idCounter = updateID();
    private long decorationId;


    public Decoration(String name, String material, double price, int quantity) {
        super(name, price, quantity);
        this.material = material;
        idCounter++;
        super.productId = idCounter;

    }

    public static long updateID(){
        List<Product> productList;
        AtomicLong newID = new AtomicLong();

        productList = ReadWriteTxt.readProductFile();

        productList.stream()
                .filter(product -> product.getClass().equals(Flower.class))
                .reduce((first, second) -> second)
                .ifPresent(product -> {
                    newID.set(product.getProductId());
                });

        return newID.longValue();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String toString() {

        return "- Decoration. Type: " + super.getName()
                + "\nID: " + this.decorationId
                + ". Material: " + this.material
                + ". Amount: " + super.getQuantity()
                + ". Price: " + super.getPrice();

    }

}

