package MenuUtama;

import AppTransition.NavigationController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private NavigationController navigationController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuUtama.fxml"));
        Parent root = loader.load();

        navigationController = new NavigationController(primaryStage);
        ControllerMenuUtama ControllermenuUtama = loader.getController();
        ControllermenuUtama.setNavigationController(navigationController);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
