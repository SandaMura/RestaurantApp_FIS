package Review.controllers;

import MenuForm.controllers.DisplayMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import static logIn.services.DBUtils.AlertBox;

public class DisplayReviewForAdminController {
    @FXML
    public ListView<String> listRv=new ListView<>();
    @FXML
    public void deleteRv(ActionEvent actionEvent) {
        DisplayReviewController.deleteR();
    }

    @FXML
    public void showRv(ActionEvent actionEvent) {
            if(!DisplayReviewController.getNewList().isEmpty()){
                listRv.setItems(DisplayReviewController.getNewList());
            }
            else{
                AlertBox("NIMIC");
            }


        }
    }





