package flowershop.repository;

import flowershop.MenuOptions;
import flowershop.domain.FlowerShop;
import flowershop.domain.Product;
import flowershop.domain.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides functionality for reading and writing data to and from text files.
 */
public class ReadWriteTxt {

    private static final String productPath = "Products.txt";
    private static final String ticketPath = "Ticket.txt";
    private static final String flowerShopPath = "FlowerShop.txt";

    public static FlowerShop checkFlowerShop() throws IOException {

        File file = new File(flowerShopPath);
        FlowerShop flowerShop = null;

        ObjectInputStream fis = null;


        try {

            if (file.exists()){

                fis = new ObjectInputStream(new FileInputStream(flowerShopPath));

                while ((flowerShop = (FlowerShop) fis.readObject()) != null){
                    flowerShop = (FlowerShop) fis.readObject();
                }
            }

        } catch (EOFException ex) {
            //
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return flowerShop;

    }

    public static void createFlowerShop(FlowerShop flowerShop) {
        ObjectOutputStream writer;
        FileOutputStream fos;


        try {
            fos = new FileOutputStream(flowerShopPath);

            writer = new ObjectOutputStream(fos);

            writer.writeObject(flowerShop);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads a list of Product objects from a text file.
     *
     * @return a list of Product objects, or null if the file doesn't exist
     */
    public static List<Product> readProductFile(){
        List<Product> data = new ArrayList<>();
        ObjectInputStream fis = null;
        Product product;
        File file;

        try {

            file = new File(productPath);

            if (file.exists()){
                fis = new ObjectInputStream(new FileInputStream(productPath));

                while ((product = (Product) fis.readObject()) != null){
                    data.add(product);
                }
            }

        } catch (EOFException ex) {
            // No hagas nada, es normal que llegue al final del archivo
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;

    }

    /**
     * Adds a Product object to a text file.
     *
     * @param product the Product object to add
     * @throws IOException if there is an error while writing to the file
     */
    public static void addProduct(Product product) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream writer = null;
        List<Product> data;

        File file = new File(productPath);

        //comprovem si ja hi ha un producte d'aquest tipus. si hi és, actualitzem
        //quantitats però no afegim un nou producte. Si no hi ha Flower "rosa" (per exemple)
        //afegim la rosa a la llista

        if (file.exists()) {
            data = readProductFile();
            data.add(product);
        } else {
            data = new ArrayList<>();
            data.add(product);
        }

        try {

            fos = new FileOutputStream(productPath);

            writer = new ObjectOutputStream(fos);

            for (Product p : data) {
                writer.writeObject(p);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * Removes a specified amount of products with the given name from products.txt file.
     *
     * @param nameProduct the name of the product to remove
    //* @param amount the amount of products to remove
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public static void removeProductFromFile(String nameProduct) throws IOException {

        ObjectOutputStream writer = null;
        FileOutputStream fos = null;

        List<Product> data = readProductFile();

        data.removeIf(product -> product.getName().equalsIgnoreCase(nameProduct));

        try {
            fos = new FileOutputStream(productPath);

            writer = new ObjectOutputStream(fos);

            for (Product product : data) {
                writer.writeObject(product);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * Reads a list of Ticket objects from a text file.
     *
     * @return a list of Ticket objects
     */
    public static List<Ticket> readTicketFile(){
        List<Ticket> data = new ArrayList<>();
        ObjectInputStream fis = null;
        Ticket ticket;
        File file;
        boolean endOfFile = false;

        try {

            file = new File(ticketPath);

            if (file.exists()){
                fis = new ObjectInputStream(new FileInputStream(ticketPath));

                while (!endOfFile) {
                    try {
                        ticket = (Ticket) fis.readObject();
                        data.add(ticket);
                    } catch (EOFException e) {
                        endOfFile = true;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        } finally {
            try {
                if (fis != null){
                    fis.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return data;
    }

    /**
     * Adds a Ticket object to a text file.
     *
     * @param ticket the Ticket object to add
     * @throws IOException if there is an error while writing to the file
     */
    public static void addTicket(Ticket ticket) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream writer = null;
        List<Ticket> data;

        File file = new File(ticketPath);


        if (file.exists()) {
            data = readTicketFile();
            data.add(ticket);
        } else {
            data = new ArrayList<>();
            data.add(ticket);
        }


        try {
            fos = new FileOutputStream(ticketPath);

            writer = new ObjectOutputStream(fos);

            for (Ticket p : data) {
                writer.writeObject(p);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (fos != null) {
                fos.close();
            }
        }

    }

    public static void updateProduct(List<Product> inventory) {

        FileOutputStream fos = null;
        ObjectOutputStream writer = null;

        File file = new File(productPath);

        // Check if file exists, if not create it
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }

        // Write the products to the file
        try {
            fos = new FileOutputStream(productPath);
            writer = new ObjectOutputStream(fos);

            for (Product product : inventory) {
                writer.writeObject(product);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // Close the output stream and object stream
            try {
                if(writer != null){
                    writer.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}



