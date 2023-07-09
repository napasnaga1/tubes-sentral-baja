package TokoSaya;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Chat.ControllerChat;
import DaftarPesanan.ControllerDaftarPesanan;
import ListRefund.ListRefundController;
import ManajemenProduk.ManajemenProdukController;
import MelacakPesanan.MelacakController;
import PesananMasuk.ControllerPesananMasuk;
import Profil.ControllerProfil;
import javafx.scene.Node;

import AppTransition.NavigationController;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerTokoSaya {
    private NavigationController navigationController;

    public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @FXML
    private TextField inputNamaToko;
    @FXML
    private TextField inputAlamatToko;
    @FXML
    private TextField inputEmailToko;
    @FXML
    private TextField inputNomorToko;

    @FXML 
    private Button tombolSimpanData;

    @FXML
    private Label outNamaToko;

    @FXML
    private Label outAlamatToko;

    @FXML
    private Label outEmailToko;

    @FXML
    private Label outNomorToko;

    @FXML
    private ImageView chatBtn;

    @FXML
    private ImageView daftarPesananBtn;

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
    private ImageView daftarPesananbtn;

    @FXML
    private ImageView daftarPesananbtn1;

    @FXML
    private Button tokoSayaManajemen;

    @FXML
    private Button tokoSayaPesananMasuk;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    private AnchorPane tokoSaya;

    @FXML
    private ImageView square;

    @FXML
    private Scene circle;

    ModelProfilToko model = new ModelProfilToko();
    private Node greySquare;


    @FXML
    void backFromToko(MouseEvent event) {
        navigationController.navigateBack();
    }

    @FXML
    void searchBarAction(ActionEvent event) {

    }

    // @FXML
    // private void openManagement() {
    //     try {
    //         FXMLLoader loader = new FXMLLoader(getClass().getResource("managementProduct.fxml"));
    //         Parent root = loader.load();
    //         Stage stage = new Stage();
    //         stage.setScene(new Scene(root));
    //         stage.show();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    @FXML
    void gantiFoto(ActionEvent event) throws IOException {
        FileChooser Chooser = new FileChooser();

        FileChooser.ExtensionFilter exxFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter exxFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");

        Chooser.getExtensionFilters().addAll(exxFilterJPG,exxFilterPNG);

        File file = Chooser.showOpenDialog(null);
        java.awt.image.BufferedImage bufferedimg = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedimg, null);
        square.setImage(image);
        circle.setFill(new ImagePattern(image));
        greySquare.setVisible(false);
    }

    @FXML
    void tombolSimpanDataToko(ActionEvent event) {
        outNamaToko.setText(inputNamaToko.getText());
        outAlamatToko.setText(inputAlamatToko.getText());
        outEmailToko.setText(inputEmailToko.getText());
        outNomorToko.setText(inputNomorToko.getText());

        model.setNama(inputNamaToko.getText());
        model.setNomorHP(inputNomorToko.getText());
        model.setAlamat(inputAlamatToko.getText());
        model.setEmail(inputEmailToko.getText());
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
    void tampilManajemenProduk(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ManajemenProduk/ManajemenProduk.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ManajemenProdukController manajemenProdukController = loader.getController();
        manajemenProdukController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilPesananMasuk(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PesananMasuk/PesananMasuk.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ControllerPesananMasuk pesananMasukController = loader.getController();
        pesananMasukController.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilDaftarPesananPemasok(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MelacakPesanan/MelacakPesanan.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        MelacakController controllerMelacak = loader.getController();
        controllerMelacak.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }

    @FXML
    void tampilDaftarRefundPemasok(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ListRefund/ListRefund.fxml")); // Replace with the actual path to your Deskripsi.fxml file
        Parent root = loader.load();
        ListRefundController controllerListRefund = loader.getController();
        controllerListRefund.setNavigationController(navigationController);
        navigationController.navigateTo(root);
    }
}