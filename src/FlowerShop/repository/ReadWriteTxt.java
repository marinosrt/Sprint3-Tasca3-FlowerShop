package FlowerShop.repository;

import FlowerShop.domain.Product;
import FlowerShop.domain.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteTxt {

    private static final String pathProduct = "products.txt";
    private static final String pathTicket = "tickets.txt";

    //read from txt file
    public static List<Product> readProductFile(){
        List<Product> data = new ArrayList<>();
        ObjectInputStream fis = null;
        Product product;

        try {
            fis = new ObjectInputStream(new FileInputStream(pathProduct));
            while ((product = (Product) fis.readObject()) != null){
                data.add(product);
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

    public static List<Ticket> readTicketFile(){
        List<Ticket> data = new ArrayList<>();
        ObjectInputStream fis = null;
        Ticket ticket;

        try {
            fis = new ObjectInputStream(new FileInputStream(pathTicket));
            while ((ticket = (Ticket) fis.readObject()) != null){
                data.add(ticket);
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

    //fer un archivo índice per accedir a aquell objecte en concret sense llegir tot el file
    //caldria lligar amb el NOM del producte? amb ID?
    /*public static Product getProduct(){

    }*/


    //write txt file
    /*
    Com que estem guardant OBJECTES al -txt, no hi ha manera amb java de simplement afegir
    al final de la llista. S'ha de tornar a llegir tot (per això cridem al metode read, que retorna un array)
    afegir el object i tornar a escriure
     */
    public static void addProduct(Product product) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream writer = null;
        List<Product> data;

        File file = new File(pathProduct);

        if (file.exists()) {
            data = readProductFile();
        } else {
            file.createNewFile();
            data = new ArrayList<>();
        }

        data.add(product);

        try {
            fos = new FileOutputStream(pathProduct);
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

    public static void addTicket(Ticket ticket) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream writer = null;
        List<Ticket> data;

        File file = new File(pathTicket);

        if (file.exists()) {
            data = readTicketFile();
        } else {
            file.createNewFile();
            data = new ArrayList<>();
        }

        data.add(ticket);

        try {
            fos = new FileOutputStream(pathTicket);
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

    public static void removeProduct(String nameProduct, int amount) throws IOException {

        ObjectOutputStream writer = null;
        FileOutputStream fos = null;

        List<Product> data = readProductFile();

        do {
            //data.removeIf(product -> product.getName().equalsIgnoreCase(nameProduct));
            amount--;
        } while (amount !=0);

        try {
            fos = new FileOutputStream(pathProduct);
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


}
