package Admin;

import App.RestaurantApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logIn.exceptions.loginFailed;
import logIn.services.DBUtils;
import logIn.services.UserSearch;

import java.io.IOException;
import java.util.Objects;


public class AdminView {


    @FXML
    private Button OpenFillForm;
    @FXML
    private Button ShowReviews;

    @FXML
    private Button DisplayItems;

    @FXML
    private Button goToLogOut;


    public void OpenForm(ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) OpenFillForm.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("FormInterface.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToLogOut(ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) goToLogOut.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("AdminLogOut.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private Button viewR;
    @FXML

    public void viewRev(ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) viewR.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("DisplayReviewForAdmin.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
