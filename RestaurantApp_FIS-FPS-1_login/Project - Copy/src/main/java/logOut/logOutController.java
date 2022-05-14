package logOut;

import javafx.event.ActionEvent;
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

    @FXML
            private Button CustomerLogOut;
    @FXML
            private Button CookLogOut;
    @FXML
            private Button AdminLogOut;

    Stage stage;



    public void logout(javafx.event.ActionEvent actionEvent) {

        stage = (Stage) Scene_LogOut.getScene().getWindow();
        System.out.println("You successfully logged out");

        DBUtils.changeScene(actionEvent, "LogInInterface.fxml", "Log in!", null, null, null);

    }


    public void backToMainAdmin(ActionEvent actionEvent) {



        System.out.println("backToMainAdmin method");

        Stage stage;
        Parent root;
        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getClassLoader().getResource("Admin_view.fxml"));

        stage.setScene(new Scene(root, 600, 450));
        stage.show();


    }

    public void backToCookMain(ActionEvent actionEvent) {


        System.out.println("backToCookMain method");

        Stage stage;
        Parent root;
        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getClassLoader().getResource("Cook_view.fxml"));

        stage.setScene(new Scene(root, 600, 450));
        stage.show();

        System.out.println("DEBUG: Utilizator s-a logat ADMIN");
    }

    public void backToCustomerMain(ActionEvent actionEvent) {


        System.out.println("backToCustomerMain method");

        Stage stage;
        Parent root;
        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getClassLoader().getResource("Customer_view.fxml"));

        stage.setScene(new Scene(root, 600, 450));
        stage.show();

    }
}