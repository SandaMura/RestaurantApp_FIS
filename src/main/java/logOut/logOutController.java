package logOut;

import App.RestaurantApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;
import logIn.services.DBUtils;

import java.io.IOException;
import java.util.Objects;

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

    @FXML
            private Button backToMainAdmin;

    @FXML
            private Button backToMainCook;

    @FXML
            private Button backToMainCustomer;
   Stage stage;



    public void logout2(javafx.event.ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) CookLogOut.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("LogInInterface.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setScene(new Scene(root, 600, 450));
        stage.show();

    }
    public void logout1(javafx.event.ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) CustomerLogOut.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("LogInInterface.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setScene(new Scene(root, 600, 450));
        stage.show();

    }
    public void logout3(javafx.event.ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) AdminLogOut.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("LogInInterface.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setScene(new Scene(root, 600, 450));
        stage.show();

    }


    public void backToMainAdmin(ActionEvent actionEvent) {



        System.out.println("backToMainAdmin method");

        Stage stage;
        Parent root;
        stage = (Stage) backToMainAdmin.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Admin_view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setScene(new Scene(root, 600, 450));
        stage.show();


    }

    public void backToCookMain(ActionEvent actionEvent) {


        System.out.println("backToCookMain method");

        Stage stage;
        Parent root;
        stage = (Stage) CookLogOut.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("Cook_view.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backToCustomerMain(ActionEvent actionEvent) {


        System.out.println("backToCookMain method");

        Stage stage;
        Parent root;
        stage = (Stage) CustomerLogOut.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("Customer_view.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}