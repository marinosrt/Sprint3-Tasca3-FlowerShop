package FlowerShop;

import FlowerShop.domain.*;
import FlowerShop.repository.ReadWriteTxt;

import java.io.IOException;
import java.util.concurrent.Flow;


public class menuOptions {

    static FlowerShop flowerShop;

    public static void createFlowerShop() {

        flowerShop = new FlowerShop(Keyboard.getString("Type the flower's shop name."));

    }

    public static void addTree() {

        Product tree = new Tree(Keyboard.getString("What kind of tree is?"),
                Keyboard.getDouble("Type the tree's height."),
                Keyboard.getDouble("Enter the tree's retail price."),
                Keyboard.getInt("How many trees are you adding?"));

        try {
            ReadWriteTxt.addProduct(tree);
            System.out.println("Tree has been added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFlower() {

        Product flower = new Flower(Keyboard.getString("What kind of flower is?"),
                Keyboard.getString("Type the flower's color."),
                Keyboard.getDouble("Enter the flower's retail price."),
                Keyboard.getInt("How many flowers are you adding?"));
        try {
            ReadWriteTxt.addProduct(flower);
            System.out.println("Flower has been added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addDecoration() {

        Product decoration = new Decoration(Keyboard.getString("What kind of decoration is?"),
                Keyboard.getString("It is plastic or wood made?"),
                Keyboard.getDouble("Enter the decoration's retail price."),
                Keyboard.getInt("How many decorations are you adding?"));
        try {
            ReadWriteTxt.addProduct(decoration);
            System.out.println("Decoration has been added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printAllStock() {

        ReadWriteTxt.readProductFile().forEach(System.out::println);
    }

    public static void removeTree() throws IOException {

        ReadWriteTxt.removeProduct(Keyboard.getString("Type the name of the tree you want to remove"),
                                    Keyboard.getInt("Type the amount of trees you want to remove"));
        System.out.println("Tree has been removed");
    }

    public static void removeFlower() throws IOException {

        ReadWriteTxt.removeProduct(Keyboard.getString("Type the name of the flower you want to remove"),
                Keyboard.getInt("Type the amount of flowers you want to remove"));
        System.out.println("Flower has been removed");
    }

    public static void removeDecoration() throws IOException {

        ReadWriteTxt.removeProduct(Keyboard.getString("Type the name of the decoration you want to remove"),
                Keyboard.getInt("Type the amount of decorations you want to remove"));
        System.out.println("Decoration has been removed");
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
