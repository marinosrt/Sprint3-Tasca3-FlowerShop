
package FlowerShop.domain;

import FlowerShop.repository.ReadWriteTxt;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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

    public static long updateID() {
        List<Product> productList;
        AtomicLong newID = new AtomicLong();

        productList = ReadWriteTxt.readProductFile();

        if (productList != null) {
            productList.stream()
                    .filter(product -> product.getClass().equals(Flower.class))
                    .reduce((first, second) -> second)
                    .ifPresent(product -> {
                        newID.set(product.getProductId());
                    });
            return newID.longValue();
        } else {
            return 0;
        }

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

