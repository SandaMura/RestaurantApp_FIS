package MenuForm.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import static logIn.services.DBUtils.AlertBox;


public class OrderController{
    @FXML
    public ListView<String> listO=new ListView<String>();
        public void getOrder(ActionEvent actionEvent) {
            if(!DisplayMenuController.getList3().isEmpty()){
                listO.setItems(DisplayMenuController.getList3());
            }
            else{
                AlertBox("NIMIC");
            }


        }


}
