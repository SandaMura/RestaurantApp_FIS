package logOut;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import logIn.services.DBUtils;

public class logOutController{

    @FXML
    private Button LogOut_button;
    @FXML
    private AnchorPane Scene_LogOut;

    Stage stage;
    @FXML
    public void logout(ActionEvent event){
        stage = (Stage) Scene_LogOut.getScene().getWindow();
        System.out.println("You successfully logged out");

        DBUtils.changeScene(event, "LogInInterface.fxml", "Log in!", null, null, null);

    }

}