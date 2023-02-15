package FlowerShop.domain;


public class Tree extends Product {
    private String height;
    private static long idCounter = 1;
    private long treeId;

    public Tree(String name, double price, int quantity, String height, long id) {
        super(name, price, quantity);
        this.height = height;
        this.treeId = idCounter;
        idCounter++;


    }
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String toString() {

        return "id: " + treeId + ", height: " + height;

    }

}





