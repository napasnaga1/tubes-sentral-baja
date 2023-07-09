package Pembayaran;

import AppTransition.NavigationController;
import Chat.ControllerChat;
import DaftarPesanan.ControllerDaftarPesanan;
import Profil.ControllerProfil;
import TokoSaya.ControllerTokoSaya;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ControllerPembayaran {
    private NavigationController navigationController;

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @FXML
    private AnchorPane halamanBayar;

    @FXML
    private ScrollPane halamanBayarSP;

    @FXML
    private AnchorPane navigasi;

    @FXML
    private ImageView backFromCheckoutBtn;

    @FXML
    private AnchorPane konfirmasiPemesanan;

    @FXML
    private Button bayarBtn;

    @FXML
    private ImageView chatBtn;

    @FXML
    private ImageView daftarPesananBtn;

    @FXML
    private AnchorPane pemesananBerhasil;

    @FXML
    private ImageView notifikasiBtn;

    @FXML
    private Label kuantitas;
    private int count = 0;

    @FXML
    private MenuButton pilihKurirDrawer;

    @FXML
    private MenuButton pilihPengirimanDrawer;

    @FXML
    private AnchorPane profilBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private AnchorPane tokoBtn;

    @FXML
    private Label estimasi;

    @FXML
    void backFromCheckout(MouseEvent event) {
        navigationController.navigateBack();
    }

    @FXML
    void backToMenuUtama(MouseEvent event) {
        navigationController.navigateToMenu();
    }

    @FXML
    void batalBayar(ActionEvent event) {
        konfirmasiPemesanan.setVisible(false);
        halamanBayarSP.setDisable(false);
        navigasi.setDisable(false);
    }

    @FXML
    void kurangKuantitas(MouseEvent event) {
        if (count > 0) {
            count--;
            kuantitas.setText(String.valueOf(count));
        }
    }

    @FXML
    void lanjutBayar(ActionEvent event) {
        pemesananBerhasil.setVisible(true);
    }

    @FXML
    void pilihKurirAction(ActionEvent event) {
        MenuItem selectedMenuItem = (MenuItem) event.getSource();
        pilihKurirDrawer.setText(selectedMenuItem.getText());
    }

    @FXML
    void pilihPengirimanAction(ActionEvent event) {
        MenuItem selectedMenuItem = (MenuItem) event.getSource();
        pilihPengirimanDrawer.setText(selectedMenuItem.getText());
    }

    @FXML
    void searchBarAction(ActionEvent event) {

    }

    @FXML
    void tambahKuantitas(MouseEvent event) {
        if (count < 10) {
            count++;
            kuantitas.setText(String.valueOf(count));
        }
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

    @FXML
    void tampilKonfirmasi(ActionEvent event) {
        konfirmasiPemesanan.setVisible(true);
        halamanBayarSP.setDisable(true);
        navigasi.setDisable(true);
    }
}
