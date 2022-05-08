package logOut;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logIn.services.DBUtils;

public class logOutController{

    @FXML
    private Button LogOut_button;
    @FXML
    private AnchorPane Scene_LogOut;

    Stage stage;



    public void logout(javafx.event.ActionEvent actionEvent) {

        stage = (Stage) Scene_LogOut.getScene().getWindow();
        System.out.println("You successfully logged out");

        DBUtils.changeScene(actionEvent, "LogInInterface.fxml", "Log in!", null, null, null);

    }
}