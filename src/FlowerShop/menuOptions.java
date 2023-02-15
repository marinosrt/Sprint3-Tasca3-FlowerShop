package FlowerShop;

import FlowerShop.domain.*;

public class menuOptions {

    public static void createFlowerShop() {

        FlowerShop flowerShop = new FlowerShop(Keyboard.getString("Type the flower shop's name"));
    }

    public static void addTree() {

        Product tree = new Tree(Keyboard.getDouble("Type the tree's height."),
                                Keyboard.getDouble("Type the tree's retail price."));
        WriteTxt.writeFile(tree.toString());
    }

    public static void addFlower() {

        Product flower = new Flower(Keyboard.getString("Type the flower's color."),
                                    Keyboard.getDouble("Type the flower's retail price."));
        WriteTxt.writeFile(flower.toString());
    }

    public static void addDecoration() {

        Product decoration = new Decoration(Keyboard.getString("Type the decoration's material"),
                                            Keyboard.getDouble("Type the decoration's retail price."));
        WriteTxt.writeFile(decoration.toString());
    }

    public static void printAllStock() {

        ReadTxt.readFile("stock.txt");
    }

    public static void retrieveTree() {

        Keyboard.getString("Type the tree do you want to retrieve.")
    }

    public static void retrieveFlower() {
    }

    public static void retrieveDecoration() {
    }

    public static void printStockAndQuantities() {
    }

    public static void printFullValue() {
    }

    public static void createPurchaseTicket() {
    }

    public static void printOldPurchases() {
    }

    public static void printTotalSumPurchases() {
    }
}
