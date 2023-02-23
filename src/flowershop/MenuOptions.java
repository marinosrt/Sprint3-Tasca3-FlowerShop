package flowershop;

import flowershop.domain.*;
import flowershop.repository.ReadWriteTxt;
import java.io.IOException;
import java.util.List;

/**
 * This class contains a series of static methods that allow to interact with the program's menu and its options.
 */
public class MenuOptions {
    static FlowerShop flowerShop;

    static {
        try {
            if (ReadWriteTxt.checkFlowerShop() != null){
                flowerShop = ReadWriteTxt.checkFlowerShop();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a flower shop and assigns the name provided by the user.
     */
    public static void createFlowerShop() throws IOException {

        if (ReadWriteTxt.checkFlowerShop() != null) {
            flowerShop = ReadWriteTxt.checkFlowerShop();
            System.out.println("We already have a flower shop: " + flowerShop.getName());
        } else {
            flowerShop = FlowerShop.getInstance(Keyboard.getString("Type the flower's shop name."));
            System.out.println(flowerShop.getName() + " created!");

            ReadWriteTxt.createFlowerShop(flowerShop);
        }
    }

    public static int searchDuplicated(String newProduct) {
        boolean match = false;
        int i = 0;
        int indexProduct = -1;
        Product product;

        if (flowerShop.getInventory() != null) {

            while (i < flowerShop.getInventory().size() && !match) {
                product = flowerShop.getInventory().get(i);
                if (product.getName().equalsIgnoreCase(newProduct)) {
                    indexProduct = i;
                    match = true;
                }
                i++;
            }
        }

        return indexProduct;


    }

    public static void changeQuantityExistingProduct(int indexProduct, String newProductName) throws IOException {

        int option;
        int newQuantity;
        List<Product> databaseList;

        option = Keyboard.getInt("This type of product already exist. Do you want to:\n" +
                "1. Add more stock to this product.\n" +
                "2. Quit.");

        if (option == 1) {
            newQuantity = Keyboard.getInt("How many more " + newProductName + " you want to add?");
            databaseList = flowerShop.getInventory();
            databaseList.get(indexProduct).changeSumQuantity(newQuantity);
            flowerShop.updateInventory(databaseList);
            System.out.println("Stock successfully updated!");
        } else {
            System.out.println("Quitting.");
        }
    }

    /**
     * Adds a new Tree object to the stock.
     */
    public static void addTree() throws IOException {

        String newTree;
        int found;
        Product tree;

        if (ReadWriteTxt.checkFlowerShop() != null) {
            newTree = Keyboard.getString("What kind of tree is?");
            found = searchDuplicated(newTree);

            if (found != -1){
                changeQuantityExistingProduct(found, newTree);
            } else {
                tree = new Tree(newTree,
                        Keyboard.getDouble("Type the tree's height."),
                        Keyboard.getDouble("Enter the tree's retail price."),
                        Keyboard.getInt("How many trees are you adding?"));
                try {
                    flowerShop.addProductToInventory(tree);
                    System.out.println("Products successfully added!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

    /**
     * Adds a new Flower object to the stock.
     */
    public static void addFlower() throws IOException {

        String newFlower;
        int found;
        Product flower;

        if (ReadWriteTxt.checkFlowerShop() != null) {
            newFlower = Keyboard.getString("What kind of flower is?");
            found = searchDuplicated(newFlower);

            if (found != -1){
                changeQuantityExistingProduct(found, newFlower);
            } else {
                flower = new Flower(newFlower,
                        Keyboard.getString("Type the flower's color."),
                        Keyboard.getDouble("Enter the flower's retail price."),
                        Keyboard.getInt("How many flowers are you adding?"));
                try {
                    flowerShop.addProductToInventory(flower);
                    System.out.println("Products successfully added!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

    /**
     * Adds a new Decoration object to the stock.
     */
    public static void addDecoration() throws IOException {

        String newDecoration;
        int found;
        Product decoration;

        if (ReadWriteTxt.checkFlowerShop() != null) {
            newDecoration = Keyboard.getString("What kind of decoration is?");
            found = searchDuplicated(newDecoration);

            if (found != -1){
                changeQuantityExistingProduct(found, newDecoration);
            } else {
                decoration = new Decoration(newDecoration,
                        Keyboard.getString("It is plastic or wood made?"),
                        Keyboard.getDouble("Enter the decoration's retail price."),
                        Keyboard.getInt("How many decorations are you adding?"));
                try {
                    flowerShop.addProductToInventory(decoration);
                    System.out.println("Products successfully added!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

    /**
     * Prints a list of all the products in the stock, showing their name, type and quantity.
     */
    public static void printAllStock() throws IOException {

        if (ReadWriteTxt.checkFlowerShop() != null) {
            if (!flowerShop.getInventory().isEmpty()) {
                flowerShop.getInventory().forEach(System.out::println);
            } else {
                System.out.println("You need to add some products first!");
            }
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

    /**
     * Removes a product from the stock.
     *
     * @param product the name of the product to be removed
     * @throws IOException if there is an error accessing the file
     */
    public static void removeProduct(String product) throws IOException {

        String removeProduct;

        if (ReadWriteTxt.checkFlowerShop() != null) {
            if (!flowerShop.getInventory().isEmpty()) {
                removeProduct = Keyboard.getString("Type the name of the " + product + " you want to remove");
                if(searchDuplicated(removeProduct) != -1) {
                    flowerShop.removeProductFromInventory(removeProduct);
                    System.out.println("Products successfully removed!");
                } else {
                    System.out.println("There's no product with this name in our inventory");
                }

            } else {
                System.out.println("You need to add some products first!");
            }
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

    /**
     * Prints the stock and quantities of all products.
     */
    public static void printStockAndQuantities() throws IOException {

        if (ReadWriteTxt.checkFlowerShop() != null) {
            if (!flowerShop.getInventory().isEmpty()) {
                flowerShop.getInventory().forEach(p -> System.out.println("Name: " + p.getName() + " - Quantity: " + p.getQuantity()));
            } else {
                System.out.println("You need to add some products first!");
            }
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

    /**
     * Prints the total value of all products in stock.
     */
    public static void printFullValue() throws IOException {

        if (ReadWriteTxt.checkFlowerShop() != null) {
            double totalValue =
                    flowerShop.getInventory().stream()
                            .mapToDouble(p -> p.getQuantity() * p.getPrice())
                            .sum();
            System.out.println("The total value of stock is: " + totalValue + "€");
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

    /**
     * Creates a new purchase ticket and adds products to it.
     *
     * @throws IOException if there is an error accessing the file
     */
    public static void createPurchaseTicket() throws IOException {

        Product product = null;
        Ticket ticket = null;
        String productName;
        boolean found;
        int option, productAmountTicket, index = 0;

        if (ReadWriteTxt.checkFlowerShop() != null) {
            if (!flowerShop.getInventory().isEmpty()){
                do {
                    System.out.println("""
                        1- Add Product.
                        2. Finish the ticket.""");
                    option = Keyboard.getInt("Choose an option.");

                    switch (option) {
                        case 1 -> {
                            productName = Keyboard.getString("Type the name of the product you want to buy");
                            found = false; // agregar aquesta línia per reiniciar el valor de la variable
                            int i = 0; //reiniciar abans de cada iteració
                            while (i < flowerShop.getInventory().size() && !found) {
                                if (flowerShop.getInventory().get(i).getName().equalsIgnoreCase(productName)) {
                                    index = i;
                                    product = flowerShop.getInventory().get(i);
                                    found = true;
                                }
                                i++;
                            }
                            if (found){
                                productAmountTicket = Keyboard.getInt("Type the amount you want to buy");

                                assert product != null;
                                ticket = new Ticket();
                                createPurchaseTicketCalcul(product, productAmountTicket, ticket, index);
                            } else {
                                System.out.println("We don't have this type of product.");
                            }

                        }
                        case 2 -> {
                            if(ticket != null) {
                                flowerShop.addTicketToInvoices(ticket);
                            }
                        }
                    }
                } while (option != 2);
            } else {
                System.out.println("First add some products!");
            }
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

    /**
     * Adds a product to the purchase ticket.
     *
     * @param product the product to add
     */
    public static void createPurchaseTicketCalcul(Product product, int productAmountTicket, Ticket ticket, int index) {

        List<Product> databaseList;

        if (product.getQuantity() >= productAmountTicket) {
            ticket.addProduct(product.getName(), product.getPrice(), productAmountTicket);

            product.changeSubstractQuantity(productAmountTicket);
            try {
                databaseList = flowerShop.getInventory();
                databaseList.get(index).changeSubstractQuantity(productAmountTicket);
                flowerShop.updateInventory(databaseList);
                System.out.println("Stock successfully updated!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (product.getQuantity() == 0){ //si la quantity es queda a 0 dp d'afegir a ticket, eliminar producte
                try {
                    flowerShop.removeProductFromInventory(product.getName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Product added to ticket");
        } else {
            System.out.println("The desired quantity exceeds the stock.");
        }
    }

    /**
     * Prints all old purchase tickets.
     */
    public static void printOldPurchases() throws IOException {

        if (ReadWriteTxt.checkFlowerShop() != null) {
            if (!flowerShop.getInvoices().isEmpty()) {
                System.out.println("All " + flowerShop.getName() + " purchases are:");
                flowerShop.getInvoices().forEach(System.out::println);
            } else {
                System.out.println("Create a ticket first!");
            }
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

    /**
     * Prints the total value of all the sells made
     */
    public static void printTotalSumPurchases() throws IOException {

        double totalValue = 0;

        if (ReadWriteTxt.checkFlowerShop() != null) {
            if (!flowerShop.getInvoices().isEmpty()) {
                for (Ticket ticket : flowerShop.getInvoices()){
                    totalValue = totalValue + ticket.getTotalValue();
                }

                System.out.println("The flower shop " + flowerShop.getName() + " has sold a total value of " + totalValue + "€.");
            } else {
                System.out.println("Create a ticket first!");
            }
        } else {
            System.out.println("First create a flower shop, for God's sake!");
        }
    }

}
