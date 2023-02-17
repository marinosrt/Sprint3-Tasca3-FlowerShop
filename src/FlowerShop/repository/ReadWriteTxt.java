package FlowerShop.repository;

import FlowerShop.domain.Product;
import FlowerShop.domain.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteTxt {

    private static final String productPath = "products.txt";
    private static final String ticketPath = "ticket.txt";



    //read from txt file
    public static List<Product> readProductFile(){
        List<Product> data = null;
        ObjectInputStream fis = null;
        Product product;
        File file;

        try {

            file = new File(productPath);

            if (file.exists()){
                data = new ArrayList<>();
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

    public static List<Ticket> readTicketFile(){
        List<Ticket> data = new ArrayList<>();
        ObjectInputStream fis = null;
        Ticket ticket;

        try {

            fis = new ObjectInputStream(new FileInputStream(ticketPath));

            while (fis.available() > 0) {
                ticket = (Ticket) fis.readObject();
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

    //write txt file

    public static void addProduct(Product product) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream writer = null;
        List<Product> data;
        boolean exit = false;

        File file = new File(productPath);

        if (file.exists()) {
            data = readProductFile();
        } else {
            file.createNewFile();
            data = new ArrayList<>();
        }

        //comprovem si ja hi ha un producte d'aquest tipus. si hi és, actualitzem
        //quantitats però no afegim un nou producte. Si no hi ha Flower "rosa" (per exemple)
        //afegim la rosa a la llista

        do{
            for (Product prodList : data){
                if (product.getName().equalsIgnoreCase(prodList.getName())){
                    prodList.setQuantity(product.getQuantity());
                    exit = true;
                } else {
                    data.add(product);
                }
            }
        } while(!exit);



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

    public static void addTicket(Ticket ticket) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream writer = null;
        List<Ticket> data;

        File file = new File(ticketPath);


        if (file.exists()) {
            data = readTicketFile();
        } else {
            file.createNewFile();
            data = new ArrayList<>();
        }

        data.add(ticket);

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


}
