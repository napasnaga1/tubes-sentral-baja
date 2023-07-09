package ManajemenProduk;

import java.io.IOException;

import DataBase.CSVBarang;
import AppTransition.NavigationController;
import Chat.ControllerChat;
import DaftarPesanan.ControllerDaftarPesanan;
import Profil.ControllerProfil;
import TokoSaya.ControllerTokoSaya;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ManajemenProdukController extends Application {
    private NavigationController navigationController;

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @FXML
    private AnchorPane manajemenProduk;
    
    @FXML
    private ImageView chatBtn;

    @FXML
    private AnchorPane navigasi;

    @FXML
    private AnchorPane profilBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private AnchorPane tokoBtn;

    @FXML
    private ImageView daftarPesananBtn;
    
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField descriptionTextArea;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private TableView<Product> productTableView;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, Integer> quantityColumn;

    @FXML
    private TableColumn<Product, Double> priceColumn;

    @FXML
    private TextField ubahNamaItem;

    @FXML
    private TextField ubahJumlahItem;

    @FXML
    private TextField ubahHargaItem;

    @FXML
    private TextField  isiDeskripsiItem;

    @FXML
    private Button buttonUbahItem;

    @FXML
    private TextField cariItem;

    @FXML
    private String savedDescription;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    private final String csvFilePath = "dataBarang.csv";
    private CSVBarang csvManager;
    private ObservableList<Product> productList;
    private ProductManager productManager;

    public void initialize() {
        productManager = new ProductManager();
        productList = FXCollections.observableArrayList();
        csvManager = new CSVBarang(csvFilePath);
        productList.addAll(csvManager.readProductsFromCSV());
    
        // Menghubungkan kolom dengan properti pada kelas Product
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    
        productTableView.setItems(productList);

        productTableView.refresh();
    
        productTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
                ubahNamaItem.setText(selectedProduct.getName());
                ubahHargaItem.setText(Double.toString(selectedProduct.getPrice()));
                ubahJumlahItem.setText(Integer.toString(selectedProduct.getQuantity()));
                isiDeskripsiItem.setText(selectedProduct.getDescription());
                
            } else {
                clearFields();
            }
            productTableView.refresh();
        });
    }

    @FXML
    void backFromManajemen(MouseEvent event) {
        navigationController.navigateBack();
    }

    @FXML
    private void handleProductTableClick(MouseEvent event) {
        if (event.getClickCount() == 1) { // Memastikan hanya menangani satu klik
            Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
            if (selectedProduct != null) {
                ubahNamaItem.setText(selectedProduct.getName());
                ubahHargaItem.setText(Double.toString(selectedProduct.getPrice()));
                ubahJumlahItem.setText(Integer.toString(selectedProduct.getQuantity()));
                isiDeskripsiItem.setText(selectedProduct.getDescription());
            }
        }
    }

    @FXML
    private void handleCariItemButtonAction() {
        String searchText = cariItem.getText().toLowerCase();
        for (Product product : productList) {
            if (product.getName().toLowerCase().equals(searchText)) {
                ubahNamaItem.setText(product.getName());
                ubahHargaItem.setText(Double.toString(product.getPrice()));
                ubahJumlahItem.setText(Integer.toString(product.getQuantity()));
                isiDeskripsiItem.setText(product.getDescription());
                break;
            }
        }
    }

    @FXML
    private void handleAddButtonAction() {
        String name = nameTextField.getText();
        String quantityText = quantityTextField.getText();
        String priceText = priceTextField.getText();
        String description = descriptionTextArea.getText();
    
        
    
        if (name.isEmpty() || quantityText.isEmpty() || priceText.isEmpty()) {
            showAlert("Error", "Semua input harus diisi.");
            return;
        }
    
        try {
            int quantity = Integer.parseInt(quantityText);
            double price = Double.parseDouble(priceText);
            Product product = new Product(name, quantity, price,description);
            product.setDescription(description);
            productManager.addProduct(product);
            productList.add(product);
            csvManager.writeProductsToCSV(productList);
            showAlert("Success", "Produk berhasil ditambahkan.");
            clearFields();
    
            // Menampilkan deskripsi produk pada isiDeskripsiItem
    

        } catch (NumberFormatException e) {
            showAlert("Error", "Jumlah dan harga produk harus berupa angka.");
        }

        if (!description.isEmpty()) {
            Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
            if (selectedProduct != null) {
                selectedProduct.setDescription(description);
                showAlert("Success", "Deskripsi produk berhasil ditambahkan.");
                clearFields();
            }
        }
    
    }
    
    private void clearFields() {
        nameTextField.clear();
        quantityTextField.clear();
        priceTextField.clear();
        descriptionTextArea.clear();
        ubahJumlahItem.clear();
        ubahHargaItem.clear();
        isiDeskripsiItem.clear();
        ubahNamaItem.clear();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @FXML
    private void handleUpdateButtonAction() {
        Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            try {
                int newQuantity = Integer.parseInt(ubahJumlahItem.getText());
                double newPrice = Double.parseDouble(ubahHargaItem.getText());
                String newName = ubahNamaItem.getText();
                String newDescription = isiDeskripsiItem.getText();

                selectedProduct.setQuantity(newQuantity);
                selectedProduct.setPrice(newPrice);
                selectedProduct.setName(newName);
                selectedProduct.setDescription(newDescription);

                // Menyegarkan tampilan tabel setelah data diperbarui
                productTableView.refresh();
                csvManager.writeProductsToCSV(productList);

                showAlert("Success", "Produk berhasil diperbarui.");
                clearFields();
            } catch (NumberFormatException e) {
                showAlert("Error", "Jumlah dan harga produk harus berupa angka.");
            }
        } else {
            // Tampilkan pesan jika tidak ada produk yang dipilih
            showAlert("Error", "Pilih produk yang ingin diperbarui.");
        }
    }

    @FXML
    private void handleDeleteButtononAction() {
        Product selectedProduct = productTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            productList.remove(selectedProduct);
            csvManager.writeProductsToCSV(productList);
            showAlert("Success", "Produk berhasil dihapus.");
            clearFields();
        } else {
            showAlert("Error", "Pilih produk yang ingin dihapus.");
        }
    }


        
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
        }

    @FXML
    void searchBarAction(ActionEvent event) {
    
    }

    @FXML
    void tampilDaftarPesanan(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DaftarPesanan/DaftarPesanan.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ControllerDaftarPesanan daftarPesananController = loader.getController();
        daftarPesananController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilPaneChat(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Chat/Chat.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ControllerChat chatController = loader.getController();
        chatController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilPaneProfil(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Profil/Profil.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ControllerProfil profilController = loader.getController();
        profilController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilToko(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TokoSaya/tokoSaya.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ControllerTokoSaya tokoSayaController = loader.getController();
        tokoSayaController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }
}