package Profil;

import AppTransition.NavigationController;
import Chat.ControllerChat;
import DaftarPesanan.ControllerDaftarPesanan;
import TokoSaya.ControllerTokoSaya;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

public class ControllerProfil {
    private NavigationController navigationController;

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @FXML
    private AnchorPane navigasi;

    @FXML
    private TextField alamat;

    @FXML
    private Label alamat1;

    @FXML
    private ImageView chatBtn;

    @FXML
    private Circle circle;

    @FXML
    private ImageView daftarPesananBtn;

    @FXML
    private TextField email;

    @FXML
    private Label email1;

    @FXML
    private Rectangle greySquare;

    @FXML
    private TextField jenisKelamin;

    @FXML
    private TextField nama;

    @FXML
    private Label nama1;

    @FXML
    private TextField nomorHP;

    @FXML
    private Label nomorHP1;

    @FXML
    private ImageView notifikasiBtn;

    @FXML
    private AnchorPane paneProfil;

    @FXML
    private TextField password;

    @FXML
    private AnchorPane profilBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private ImageView square;

    @FXML
    private TextField tanggalLahir;

    @FXML
    private AnchorPane tokoBtn;

    @FXML
    private Label username1;

    @FXML
    private TextField usernameProfil;

    private List<String[]> dataPengguna = new ArrayList<>();
    private static final String CSV_FILE_PATH = "dataPengguna.csv";

    @FXML
    void initialize() {
        loadDataFromCSV();
        updateLabels();
    }

    @FXML
    void backFromProfil(MouseEvent event) {
        navigationController.navigateBack();
    }

    @FXML
    void gantiFoto(ActionEvent event) throws IOException {
        FileChooser Chooser = new FileChooser();

        FileChooser.ExtensionFilter exxFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter exxFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");

        Chooser.getExtensionFilters().addAll(exxFilterJPG,exxFilterPNG);

        File file = Chooser.showOpenDialog(null);
        BufferedImage bufferedimg = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedimg, null);
        square.setImage(image);
        circle.setFill(new ImagePattern(image));
        greySquare.setVisible(false);
    }

    @FXML
    void searchBarAction(ActionEvent event) {

    }

    @FXML
    void submit(MouseEvent event) {
        String usernamePengguna = usernameProfil.getText().trim();
        String nomorHPPengguna = nomorHP.getText().trim();
        String namaPengguna = nama.getText().trim();
        String alamatPengguna = alamat.getText().trim();
        String emailPengguna = email.getText().trim();
        String passwordPengguna = password.getText().trim();

        if (usernamePengguna.isEmpty() || nomorHPPengguna.isEmpty() || namaPengguna.isEmpty() || alamatPengguna.isEmpty() || emailPengguna.isEmpty()) {
            showAlert("Error", "Isilah data dengan lengkap");
            return;
        }

        try {
            dataPengguna.add(new String[]{usernamePengguna, nomorHPPengguna, namaPengguna, alamatPengguna, emailPengguna, passwordPengguna});
            updateLabels();
            saveDataToCSV();
            clearFields();
        } catch (IOException e) {
            showAlert("Error", "Data gagal disimpan");
        }
    }

    private void loadDataFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    dataPengguna.add(data);
                }
            }
        } catch (IOException e) {
            showAlert("Error", "Gagal memuat data");
        }
    }

    private void updateLabels() {
        if (!dataPengguna.isEmpty()) {
            String[] lastData = dataPengguna.get(dataPengguna.size() - 1);
            username1.setText(lastData[0]);
            nomorHP1.setText(lastData[1]);
            nama1.setText(lastData[2]);
            alamat1.setText(lastData[3]);
            email1.setText(lastData[4]);
        }
    }

    private void saveDataToCSV() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (String[] data : dataPengguna) {
                writer.write(String.join(",", data));
                writer.newLine();
            }
        }
    }

    private void clearFields() {
        usernameProfil.clear();
        nama.clear();
        nomorHP.clear();
        alamat.clear();
        email.clear();
        password.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
