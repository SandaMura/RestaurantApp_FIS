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
    private Button view;
    @FXML
    private Button goToLogOut;
    @FXML
    public void ViewOrders(){
        Stage stage;
        Parent root;
        stage = (Stage) view.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("OrderList.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private Button timerButton;
    private Button stopwatch;
    @FXML
    private Button rev;
    public void goToLogOutScene(ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        System.out.println("Cook view");
        stage = (Stage) goToLogOut.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("CookLogOut.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToTimerScene(ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) timerButton.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("timer.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void reviewV(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) rev.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("DisplayReview.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
