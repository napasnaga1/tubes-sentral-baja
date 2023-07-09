package AppTransition;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class NavigationController {
    private NavigationController navigationController;
    private Stage stage;
    private Stack<Scene> history;

    public NavigationController(Stage stage) {
        this.stage = stage;
        this.history = new Stack<>();
    }

    public void navigateTo(Parent root) {
        Scene scene = new Scene(root);
        history.push(stage.getScene());
        stage.setScene(scene);
        stage.sizeToScene();
    }

    public void navigateBack() {
        if (!history.isEmpty()) {
            Scene previousScene = history.pop();
            stage.setScene(previousScene);
            stage.sizeToScene();
        }
    }

    public void navigateToMenu() {
        while (!history.isEmpty()) {
            Scene previousScene = history.pop();
            if (history.size()==1) {
                break;
            }
            stage.setScene(previousScene);
            stage.sizeToScene();
        }
    }
}
