package ManajemenProduk;


public class Product {
    private String name;
    private int quantity;
    private double price;
    private String description;

    public Product(String name, int quantity, double price, String description) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Product(String username, String nama, String nomorHP, String alamat, String email, String password) {
    }

    // Tambahkan getter dan setter jika diperlukan
    // Misalnya:
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }



    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

 

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

