package Cook;

import App.RestaurantApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class CookView {


    @FXML
    private Button goToLogOut;
    public void goToLogOutScene(ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) goToLogOut.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("CookLogOut.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
