package DaftarPesanan;

import AppTransition.NavigationController;
import Chat.ControllerChat;
import Profil.ControllerProfil;
import TokoSaya.ControllerTokoSaya;

import java.io.IOException;

import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ControllerDaftarPesanan {
    private NavigationController navigationController;

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @FXML
    private AnchorPane daftarPesanan;

    @FXML
    private AnchorPane navigasi;

    @FXML
    private ImageView backFromDaftarBtn;

    @FXML
    private AnchorPane lacakPane;

    @FXML
    private ImageView chatBtn;

    @FXML
    private ImageView daftarPesananBtn;

    @FXML
    private ImageView notifikasiBtn;

    @FXML
    private AnchorPane profilBtn;

    @FXML
    private Button refundBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private Button selesaikanPemesananBtn;

    @FXML
    private Button statusPesanBtn;

    @FXML
    private AnchorPane tokoBtn;

    @FXML
    void backFromDaftarPesanan(MouseEvent event) {
        navigationController.navigateBack();
    }

    @FXML
    void closeStatusPemesanan(MouseEvent event) {
        lacakPane.setVisible(false);
    }

    @FXML
    void searchBarAction(ActionEvent event) {

    }

    @FXML
    void tampilPaneRefund(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Refund/Refund.fxml")); // Replace with the actual path to your Popup.fxml file
    Parent root = loader.load();
    
    Stage popupStage = new Stage();
    popupStage.initModality(Modality.APPLICATION_MODAL);
    popupStage.initOwner(((Node)event.getSource()).getScene().getWindow());
    
    Scene scene = new Scene(root);
    popupStage.setScene(scene);
    popupStage.showAndWait();
    }

    @FXML
    void tampilPemesananSelesai(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ulasan/Ulasan.fxml")); // Replace with the actual path to your Popup.fxml file
    Parent root = loader.load();
    
    Stage popupStage = new Stage();
    popupStage.initModality(Modality.APPLICATION_MODAL);
    popupStage.initOwner(((Node)event.getSource()).getScene().getWindow());
    
    Scene scene = new Scene(root);
    popupStage.setScene(scene);
    popupStage.showAndWait();
    }

    @FXML
    void tampilStatusPemesanan(MouseEvent event) {
        lacakPane.setVisible(true);
    }

    @FXML
    void tampilDaftarPesanan(MouseEvent event) throws IOException {
        
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
