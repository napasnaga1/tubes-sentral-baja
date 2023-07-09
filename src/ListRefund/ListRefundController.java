package ListRefund;

import java.io.IOException;

import AppTransition.NavigationController;
import Chat.ControllerChat;
import DaftarPesanan.ControllerDaftarPesanan;
import Profil.ControllerProfil;
import TokoSaya.ControllerTokoSaya;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ListRefundController {
    private NavigationController navigationController;

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @FXML
    private Label alasanRefundDatabase;

    @FXML
    private ImageView chatBtn;

    @FXML
    private ImageView daftarPesananBtn;

    @FXML
    private AnchorPane fotoDatabase;

    @FXML
    private Label keteranganDatabase;

    @FXML
    private Label kodePesananDatabase;

    @FXML
    private Button konfirmasiRefundBackBtn;

    @FXML
    private AnchorPane navigasi;

    @FXML
    private ImageView notifikasiBtn;

    @FXML
    private Button opsi1btn;

    @FXML
    private Button opsi2button;

    @FXML
    private Button opsi3button;

    @FXML
    private Button opsi5buttton;

    @FXML
    private Button opsi6button;

    @FXML
    private AnchorPane panerefund;

    @FXML
    private AnchorPane profilBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private Button terimaRefundButton;

    @FXML
    private AnchorPane tokoBtn;

    @FXML
    private Button tolakRefundButton;

    @FXML
    private AnchorPane permintaanRefund;

    @FXML
    void kembaliDaftar(ActionEvent event) {
        permintaanRefund.setVisible(false);
    }

    @FXML
    void backFromDaftarPermintaanRefund(MouseEvent event) {
        navigationController.navigateBack();
    }

    @FXML
    void pilihOpsi1(ActionEvent event) {
        permintaanRefund.setVisible(true);
    }

    @FXML
    void pilihOpsi2(ActionEvent event) {
        permintaanRefund.setVisible(true);
    }

    @FXML
    void pilihOpsi3(ActionEvent event) {
        permintaanRefund.setVisible(true);
    }

    @FXML
    void pilihOpsi4(ActionEvent event) {
        permintaanRefund.setVisible(true);
    }

    @FXML
    void pilihOpsi5(ActionEvent event) {
        permintaanRefund.setVisible(true);
    }

    @FXML
    void pilihOpsi6(ActionEvent event) {
        permintaanRefund.setVisible(true);
    }

    @FXML
    void searchBarAction(ActionEvent event) {

    }

    @FXML
    void tampilDaftarPesanan(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DaftarPesanan/DaftarPesanan.fxml")); 
        Parent root = loader.load();
        ControllerDaftarPesanan daftarPesananController = loader.getController();
        daftarPesananController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilPaneChat(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Chat/Chat.fxml")); 
        Parent root = loader.load();
        ControllerChat chatController = loader.getController();
        chatController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilPaneProfil(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Profil/Profil.fxml")); 
        Parent root = loader.load();
        ControllerProfil profilController = loader.getController();
        profilController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilToko(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TokoSaya/tokoSaya.fxml")); 
        Parent root = loader.load();
        ControllerTokoSaya tokoSayaController = loader.getController();
        tokoSayaController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void terimaPengajuanRefund(ActionEvent event) {
        permintaanRefund.setVisible(false);

    }

    @FXML
    void tolakRefund(ActionEvent event) {
        permintaanRefund.setVisible(false);
    }

}

