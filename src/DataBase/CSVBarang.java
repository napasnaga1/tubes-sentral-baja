package DataBase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ManajemenProduk.Product;

public class CSVBarang {
    private String csvFilePath = "dataBarang.csv";
    ;

    public CSVBarang(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public List<Product> readProductsFromCSV() {
        List<Product> productList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0].trim();
                    int quantity = Integer.parseInt(data[1].trim());
                    double price = Double.parseDouble(data[2].trim());
                    String description = data[3].trim();

                    Product product = new Product(name, quantity, price, description);
                    productList.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public void writeProductsToCSV(List<Product> productList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            for (Product product : productList) {
                String line = product.getName() + "," +
                        product.getQuantity() + "," +
                        product.getPrice() + "," +
                        product.getDescription();
    
                bw.write(line);
                bw.newLine();
            }
    
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

