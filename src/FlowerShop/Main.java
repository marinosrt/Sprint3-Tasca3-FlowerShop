package FlowerShop;

import java.io.IOException;

public class Main {

    /**
     * The main method is the entry point of the program. It calls the menu method to display the menu options.
     *
     * @param args the command line arguments
     * @throws IOException if an I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        menu();
    }

    /**
     * The menu method displays a menu with several options for the user to interact with the FlowerShop.
     *
     * @throws IOException if an I/O error occurs
     */
    private static void menu() throws IOException {

        int option;

        do {
            System.out.println("""
                    1- Create Flower Shop.
                    2. Add a tree.
                    3. Add a flower.
                    4. Add a decoration.
                    5. Print all the stock from the flower show.
                    6. Remove tree.
                    7. Remove flower.
                    8. Remove decoration.
                    9. Print stock & quantities.
                    10. Print full flower shop value.
                    11. Create a purchase ticket.
                    12. Print old purchases.
                    13. Print total sum of all purchases.""");
            option = Keyboard.getInt("Choose an option.");

            switch (option){
                case 1 -> menuOptions.createFlowerShop();
                case 2 -> menuOptions.addTree();
                case 3 -> menuOptions.addFlower();
                case 4 -> menuOptions.addDecoration();
                case 5 -> menuOptions.printAllStock();
                case 6 -> menuOptions.removeProduct("tree");
                case 7 -> menuOptions.removeProduct("flower");
                case 8 -> menuOptions.removeProduct("decoration");
                case 9 -> menuOptions.printStockAndQuantities();
                case 10 -> menuOptions.printFullValue();
                case 11 -> menuOptions.createPurchaseTicket();
                case 12 -> menuOptions.printOldPurchases();
                case 13 -> menuOptions.printTotalSumPurchases();
            }
        } while (option != 0);

    }
}