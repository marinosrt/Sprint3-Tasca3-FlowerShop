package FlowerShop.domain;


import FlowerShop.repository.ReadWriteTxt;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Tree extends Product {
    private double height;
    private static long idCounter;
    private long treeId;

    public Tree(String name, double height, double price, int quantity) {
        super(name, price, quantity);
        this.height = height;
        idCounter = updateID() + 1;
        super.productId = idCounter;
    }

    public static long updateID(){
        List<Product> productList;
        AtomicLong newID = new AtomicLong();

        productList = ReadWriteTxt.readProductFile();

        if (productList != null){
            productList.stream()
                    .filter(product -> product.getClass().equals(Tree.class))
                    .reduce((first, second) -> second)
                    .ifPresent(product -> {
                        newID.set(product.getProductId());
                    });
            return newID.longValue();
        } else {
            return 1;
        }

        /*if (productList != null){
            return productList.stream()
                    .filter(product -> product.getClass().equals(Tree.class))
                    .mapToLong(Product::getProductId)
                    .max()
                    .orElse(1L);
        } else {
            return 1;
        }*/



    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {

        return "- Tree. Type: " + super.getName()
                + "\nID: " + this.treeId
                + ". Height: " + this.height
                + ". Amount " + super.getQuantity()
                + ". Price: " + super.getPrice();

    }

}





