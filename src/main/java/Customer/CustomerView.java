package Customer;

import App.RestaurantApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CustomerView {

    @FXML
    private Button goToLogOut;
    @FXML
    private Button goReview;

    @FXML
    private Button MakeOrder;


    @FXML
    private Button timerButton;



    @FXML
    public void goToTimerScene(ActionEvent actionEvent)
    {
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



    public void goToLogOutScene(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) goToLogOut.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("CustomerLogOut.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void OpenReviewForm(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) goReview.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("ReviewN.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DisplayMenu(ActionEvent actionEvent) {
        Stage stage;
        Parent root;

        stage = (Stage) MakeOrder.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("DisplayMenu.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
