package FlowerShop;

import FlowerShop.domain.*;
import FlowerShop.repository.ReadWriteTxt;

import java.io.IOException;


public class menuOptions {

    static boolean flowershopCreated = false;

    static FlowerShop flowerShop;
    static Ticket ticket;

    public static void createFlowerShop() {

        flowerShop = FlowerShop.getInstance(Keyboard.getString("Type the flower's shop name."));
        flowershopCreated = true;
    }

    public static void addTree() {

        if (flowershopCreated){
            Product tree = new Tree(Keyboard.getString("What kind of tree is?"),
                    Keyboard.getDouble("Type the tree's height."),
                    Keyboard.getDouble("Enter the tree's retail price."),
                    Keyboard.getInt("How many trees are you adding?"));

            try {
                ReadWriteTxt.addProduct(tree);
                System.out.println("Products successfully added!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("First create a flower shop!");
        }


    }

    public static void addFlower() {

        if (flowershopCreated){
            Product flower = new Flower(Keyboard.getString("What kind of flower is?"),
                    Keyboard.getString("Type the flower's color."),
                    Keyboard.getDouble("Enter the flower's retail price."),
                    Keyboard.getInt("How many flowers are you adding?"));

            try {
                ReadWriteTxt.addProduct(flower);
                System.out.println("Products successfully added!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("First create a flower shop!");
        }


    }

    public static void addDecoration() {

        if (flowershopCreated){
            Product decoration = new Decoration(Keyboard.getString("What kind of decoration is?"),
                    Keyboard.getString("It is plastic or wood made?"),
                    Keyboard.getDouble("Enter the decoration's retail price."),
                    Keyboard.getInt("How many decorations are you adding?"));

            try {
                ReadWriteTxt.addProduct(decoration);
                System.out.println("Products successfully added!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("First create a flower shop!");
        }



    }

    public static void printAllStock() {

        if (flowershopCreated){
            ReadWriteTxt.readProductFile().forEach(System.out::println);
        } else {
            System.out.println("First create a flower shop!");
        }
    }

    public static void removeProduct(String product) throws IOException {

        if (flowershopCreated){
            ReadWriteTxt.removeProductFromFile(Keyboard.getString("Type the name of the " + product + " you want to remove"));
            System.out.println("Products successfully removed!");
        } else {
            System.out.println("First create a flower shop!");
        }
    }

    /* METODES QUE NO FEM SERVIR. ELIMINEM?
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
    }*/

    public static void printStockAndQuantities() {

        if (flowershopCreated){

        } else {
            System.out.println("First create a flower shop!");
        }

    }

    public static void printFullValue() {

        if (flowershopCreated){

        } else {
            System.out.println("First create a flower shop!");
        }

    }

    public static void createPurchaseTicket() throws IOException {

        Product purchaseProduct;
        int option;
        ticket = new Ticket();

        if (flowershopCreated){
            do {
                System.out.println("""
                    1- Add Product.
                    2. Stop adding product to ticket.""");
                option = Keyboard.getInt("Choose an option.");

                switch (option){
                    case 1 -> {
                        purchaseProduct = new Product(Keyboard.getString("Type the name of the product you want to buy"),
                                Keyboard.getInt("Type the amount you want to buy"));
                        createPurchaseTicketCalcul(purchaseProduct);
                    }
                    case 2 -> ReadWriteTxt.addTicket(ticket);

                }
            } while (option != 2);
        } else {
            System.out.println("First create a flower shop!");
        }


    }

    public static void createPurchaseTicketCalcul(Product purchaseProduct) throws IOException {

        int amount;

        if (flowershopCreated){
            amount = ReadWriteTxt.readProductFile().stream()
                    .filter(databaseProduct -> databaseProduct.getName().equalsIgnoreCase(purchaseProduct.getName()))
                    .mapToInt(Product::getQuantity)
                    .sum();

            if (amount >= purchaseProduct.getQuantity()) {
                ticket.addProduct(purchaseProduct);
                ReadWriteTxt.removeProductFromFile(purchaseProduct.getName());
                System.out.println("Product added to ticket");
            } else {
                System.out.println("The desired quantity exceeds the stock.");
            }
        } else {
            System.out.println("First create a flower shop!");
        }

        //s'ha canviat el mètode add i ara no cal recorrer tota la llista,
        // ja que tots els productes que siguin iguals s'ajunataran en un i es sumarà la quantitat
        //un cop trobem el producte parar de buclejar
    }

    public static void printOldPurchases() {

        if (flowershopCreated){
            ReadWriteTxt.readTicketFile().forEach(System.out::println);
        } else {
            System.out.println("First create a flower shop!");
        }
    }

    public static void printTotalSumPurchases() {

        if (flowershopCreated){

        } else {
            System.out.println("First create a flower shop!");
        }
    }
}
