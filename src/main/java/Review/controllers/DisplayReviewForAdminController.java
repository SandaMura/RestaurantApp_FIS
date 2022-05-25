package Review.controllers;

import App.RestaurantApplication;
import MenuForm.controllers.DisplayMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

import static logIn.services.DBUtils.AlertBox;

public class DisplayReviewForAdminController {
   @FXML
   private Button backAdmin;
    @FXML
    public ListView<String> listRv = new ListView<>();

    @FXML
    public void deleteRv(ActionEvent actionEvent) {
        DisplayReviewController.deleteR();
    }

    @FXML
    public void showRv(ActionEvent actionEvent) {
        if (!DisplayReviewController.getNewList().isEmpty()) {
            listRv.setItems(DisplayReviewController.getNewList());
        } else {
            AlertBox("NIMIC");
        }


    }


    public void backToAdmin(ActionEvent actionEvent) {
            Stage stage;
            Parent root;
            stage = (Stage) backAdmin.getScene().getWindow();
            try {
                root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("Admin_view.fxml"));
                stage.setScene(new Scene(root, 600, 450));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            
        }
    }
}





