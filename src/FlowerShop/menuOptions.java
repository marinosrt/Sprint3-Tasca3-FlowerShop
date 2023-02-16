package FlowerShop;

import FlowerShop.domain.*;
import FlowerShop.repository.ReadWriteTxt;

import java.io.IOException;


public class menuOptions {

    static FlowerShop flowerShop;

    public static void createFlowerShop() {

        flowerShop = new FlowerShop(Keyboard.getString("Type the flower's shop name."));

    }

    public static void addTree() {

        Tree tree = new Tree(Keyboard.getString("What kind of tree is?"),
                Keyboard.getDouble("Type the tree's height."),
                Keyboard.getDouble("Enter the tree's retail price."),
                Keyboard.getInt("How many trees are you adding?"));

        try {
            ReadWriteTxt.addProduct(tree);
            System.out.println("Products successfully added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addFlower() {

        Product flower = new Flower(Keyboard.getString("What kind of flower is?"),
                Keyboard.getString("Type the flower's color."),
                Keyboard.getDouble("Enter the flower's retail price."),
                Keyboard.getInt("How many flowers are you adding?"));

        //comprobar si la flor existeix TRUE - actualitzar quantitat

        try {
            ReadWriteTxt.addProduct(flower);
            System.out.println("Products successfully added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addDecoration() {

        int howMany;

        Product decoration = new Decoration(Keyboard.getString("What kind of decoration is?"),
                Keyboard.getString("It is plastic or wood made?"),
                Keyboard.getDouble("Enter the decoration's retail price."),
                howMany = Keyboard.getInt("How many decorations are you adding?"));

        try {
            ReadWriteTxt.addProduct(decoration);
            System.out.println("Products successfully added!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*do {
            try {
                ReadWriteTxt.addProduct(decoration);
                System.out.println("Products successfully added!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            howMany--;
        } while (howMany != 0);*/

    }

    public static void printAllStock() {

        ReadWriteTxt.readProductFile().forEach(System.out::println);
    }

    public static void removeProduct(String product) throws IOException {

        ReadWriteTxt.removeProductFromFile(Keyboard.getString("Type the name of the " + product + " you want to remove"),
                Keyboard.getInt("Type the amount of " + product + "s you want to remove"));
        System.out.println("Products successfully removed!");

    }

    public static void removeTree() throws IOException {

        ReadWriteTxt.removeProductFromFile(Keyboard.getString("Type the name of the tree you want to remove"),
                                    Keyboard.getInt("Type the amount of trees you want to remove"));
        System.out.println("Tree has been removed");
    }

    public static void removeFlower() throws IOException {

        ReadWriteTxt.removeProductFromFile(Keyboard.getString("Type the name of the flower you want to remove"),
                Keyboard.getInt("Type the amount of flowers you want to remove"));
        System.out.println("Flower has been removed");
    }

    public static void removeDecoration() throws IOException {

        ReadWriteTxt.removeProductFromFile(Keyboard.getString("Type the name of the decoration you want to remove"),
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
