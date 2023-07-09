package Refund;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ControllerRefund {
    private static final int MAX_UPLOADS = 20;
    private static final int NUM_COLUMNS = 4;
    private static final int NUM_ROWS = 5;

    private List<File> uploadedPictures = new ArrayList<>();

    private ImageView createImageView(File pictureFile) {
        ImageView imageView = new ImageView(new Image(pictureFile.toURI().toString()));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        imageView.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                deletePicture(imageView, pictureFile);
            }
        });

        return imageView;
    }

    private void deletePicture(ImageView imageView, File pictureFile) {
        uploadedPictures.remove(pictureFile);
        tampilanFotoRefund.getChildren().remove(imageView);
    }

    @FXML
    private AnchorPane paneRefund;

    @FXML
    private MenuButton pilihAlasanRefundDrawer;

    @FXML
    private GridPane tampilanFotoRefund;

    @FXML
    void pilihAlasanRefundAction(ActionEvent event) {
        MenuItem selectedMenuItem = (MenuItem) event.getSource();
        pilihAlasanRefundDrawer.setText(selectedMenuItem.getText());
    }

    @FXML
    void pilihFoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Pictures");
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png"));
        List<File> selectedPictures = fileChooser.showOpenMultipleDialog(null);

        if (selectedPictures != null) {
            int currentRow = 0;
            int currentColumn = 0;

            for (File pictureFile : selectedPictures) {
                if (uploadedPictures.size() >= MAX_UPLOADS) {
                    // Maximum number of uploads reached
                    break;
                }

                uploadedPictures.add(pictureFile);
                ImageView imageView = createImageView(pictureFile);
                tampilanFotoRefund.add(imageView, currentColumn, currentRow);

                currentColumn++;
                if (currentColumn >= NUM_COLUMNS) {
                    currentColumn = 0;
                    currentRow++;
                }
            }
        }
    }

    @FXML
    void submitFormRefund(ActionEvent event) {

    }

}
