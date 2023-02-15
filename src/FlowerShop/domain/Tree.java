package FlowerShop.domain;


public class Tree extends Product {
    private double height;
    private static long idCounter = 1;
    private long treeId;

    public Tree(String name, double height, double price, int quantity) {
        super(name, price, quantity);
        this.height = height;
        this.treeId = idCounter;
        idCounter++;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {

        return "id: " + treeId + ", height: " + height;

    }

}





