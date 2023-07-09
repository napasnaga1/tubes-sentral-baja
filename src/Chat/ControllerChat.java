package Chat;

import java.io.IOException;

import AppTransition.NavigationController;
import DaftarPesanan.ControllerDaftarPesanan;
import Profil.ControllerProfil;
import TokoSaya.ControllerTokoSaya;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerChat {
    private NavigationController navigationController;

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @FXML
    private AnchorPane navigasi;

    @FXML
    private ImageView chatBtn;

    @FXML
    private ImageView daftarPesananBtn;

    @FXML
    private ImageView notifikasiBtn;

    @FXML
    private AnchorPane profilBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private AnchorPane tokoBtn;

    @FXML
    private ImageView backbuttonfromchat;

    @FXML
    private AnchorPane chatPane;

    @FXML
    private ImageView p1;

    @FXML
    private ImageView p2;

    @FXML
    private ImageView p3;

    @FXML
    private ImageView p4;

    @FXML
    private ImageView p5;

    @FXML
    private ImageView profil;

    @FXML
    private Label u1;

    @FXML
    private Label u2;

    @FXML
    private Label u3;

    @FXML
    private Label u4;

    @FXML
    private Label u5;

    @FXML
    private Label username;

    @FXML
    void b1(ActionEvent event) {

    }

    @FXML
    void b2(ActionEvent event) {

    }

    @FXML
    void b3(ActionEvent event) {

    }

    @FXML
    void b4(ActionEvent event) {

    }

    @FXML
    void b5(ActionEvent event) {

    }

    @FXML
    void backFromChat(MouseEvent event) {
        navigationController.navigateBack();
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
