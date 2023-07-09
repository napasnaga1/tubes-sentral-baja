package Ulasan;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ControllerUlasan {

    @FXML
    private ImageView bintang;

    @FXML
    private ImageView bintang0;

    @FXML
    private ImageView bintang1;

    @FXML
    private ImageView bintang2;

    @FXML
    private ImageView bintang3;

    @FXML
    private ImageView bintang4;

    @FXML
    private ImageView bintang5;

    @FXML
    private ImageView foto;

    @FXML
    void b1(ActionEvent event) {
        bintang1.setImage(bintang.getImage());
        bintang2.setImage(bintang0.getImage());
        bintang3.setImage(bintang0.getImage());
        bintang4.setImage(bintang0.getImage());
        bintang5.setImage(bintang0.getImage());
    }

    @FXML
    void b2(ActionEvent event) {
        bintang1.setImage(bintang.getImage());
        bintang2.setImage(bintang.getImage());
        bintang3.setImage(bintang0.getImage());
        bintang4.setImage(bintang0.getImage());
        bintang5.setImage(bintang0.getImage());
    }

    @FXML
    void b3(ActionEvent event) {
        bintang1.setImage(bintang.getImage());
        bintang2.setImage(bintang.getImage());
        bintang3.setImage(bintang.getImage());
        bintang4.setImage(bintang0.getImage());
        bintang5.setImage(bintang0.getImage());
    }

    @FXML
    void b4(ActionEvent event) {
        bintang1.setImage(bintang.getImage());
        bintang2.setImage(bintang.getImage());
        bintang3.setImage(bintang.getImage());
        bintang4.setImage(bintang.getImage());
        bintang5.setImage(bintang0.getImage());
    }

    @FXML
    void b5(ActionEvent event) {
        bintang1.setImage(bintang.getImage());
        bintang2.setImage(bintang.getImage());
        bintang3.setImage(bintang.getImage());
        bintang4.setImage(bintang.getImage());
        bintang5.setImage(bintang.getImage());
    }

    @FXML
    void tambahFoto(ActionEvent event) throws IOException {
        FileChooser Chooser = new FileChooser();

        FileChooser.ExtensionFilter exxFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter exxFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");

        Chooser.getExtensionFilters().addAll(exxFilterJPG,exxFilterPNG);

        File file = Chooser.showOpenDialog(null);
        BufferedImage bufferedimg = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedimg, null);
        foto.setImage(image);
    }

}
