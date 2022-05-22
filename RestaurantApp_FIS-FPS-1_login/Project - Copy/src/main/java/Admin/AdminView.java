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

    Stage stage;
    Parent root;

   /* @FXML
    void OpenReviewForm(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) goReview.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("Review.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void goToDisplay(ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) DisplayItems.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("DisplayMenu.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToReviews(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) ShowReviews.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("ReviewN.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button view;



    @FXML
    void ViewReview(ActionEvent event){
        Stage stage;
        Parent root;
        stage = (Stage) view.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("DisplayReview.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
