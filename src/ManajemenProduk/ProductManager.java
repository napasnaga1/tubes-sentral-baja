package ManajemenProduk;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    // Metode lainnya untuk operasi produk lainnya (seperti menghapus produk, mencari produk, dsb.) bisa ditambahkan di sini.

    // Contoh metode untuk mendapatkan daftar produk yang ada:
    public List<Product> getProductList() {
        return productList;
    }
}
