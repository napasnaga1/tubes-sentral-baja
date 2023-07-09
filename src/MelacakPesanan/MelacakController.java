package MelacakPesanan;

import java.io.IOException;

import AppTransition.NavigationController;
import Chat.ControllerChat;
import DaftarPesanan.ControllerDaftarPesanan;
import DeskripsiProduk.ControllerDeskripsiProduk;
import Profil.ControllerProfil;
import TokoSaya.ControllerTokoSaya;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MelacakController {
    private NavigationController navigationController;

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }
    
    @FXML
    private ScrollPane DaftarPesanan;

    @FXML
    private Button cekresibtn;

    @FXML
    private ImageView chatBtn;

    @FXML
    private ImageView daftarPesananBtn;

    @FXML
    private Button lacakbackbtn;

    @FXML
    private Button lacakbtn;

    @FXML
    private AnchorPane lacakpane;

    @FXML
    private AnchorPane navigasi;

    @FXML
    private ImageView notifikasiBtn;

    @FXML
    private AnchorPane profilBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private AnchorPane tokoBtn;

    @FXML
    void backtodaftarfromlacak(ActionEvent event) {
        lacakpane.setVisible(false);
        DaftarPesanan.setDisable(false);
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
    

    @FXML
    void tampilpanelacak(ActionEvent event) {
        lacakpane.setVisible(true);
        DaftarPesanan.setDisable(true);
    }

    @FXML
    void tampiltabellacak(ActionEvent event) {

    }

    @FXML
    void backFromLacakPemasok(MouseEvent event) {
        navigationController.navigateBack();
    }
}
