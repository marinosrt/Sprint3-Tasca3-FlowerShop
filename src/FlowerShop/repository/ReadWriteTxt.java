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
        List<Ticket> data = null;
        ObjectInputStream fis = null;
        Ticket ticket;
        File file;

        try {

            file = new File(ticketPath);

            if (file.exists()){
                data = new ArrayList<>();
                fis = new ObjectInputStream(new FileInputStream(ticketPath));

                while ((ticket = (Ticket) fis.readObject()) != null){
                    data.add(ticket);
                }
                /*while (fis.available() > 0) {
                    ticket = (Ticket) fis.readObject();
                    data.add(ticket);
                }*/
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
        boolean match = false;

        File file = new File(productPath);

        //comprovem si ja hi ha un producte d'aquest tipus. si hi és, actualitzem
        //quantitats però no afegim un nou producte. Si no hi ha Flower "rosa" (per exemple)
        //afegim la rosa a la llista

        if (file.exists()) {
            data = readProductFile();
            for (Product prodList : data){
                if (product.getName().equalsIgnoreCase(prodList.getName())){
                    prodList.changeSUMquantity(product.getQuantity());
                    match = true;
                }
            }
            if (!match){
                data.add(product);
            }
        } else {
            file.createNewFile();
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

    public static void addTicket(Ticket ticket) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream writer = null;
        List<Ticket> data = null;

        File file = new File(ticketPath);


        if (file.exists()) {
            data = readTicketFile();
            data.add(ticket);
        } else {
            file.createNewFile();
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
