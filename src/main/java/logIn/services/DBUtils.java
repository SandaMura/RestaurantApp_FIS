package logIn.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class DBUtils { ///helper class


    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, String password, String role)
    {
        Parent root=null;

        if(username != null && password!=null){  ///daca merge logged in
            try{
                FXMLLoader loader=new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root=loader.load();

                ///schimba scena in functie de rol


            }catch(IOException e){
                e.toString();
            }
        }else{ //go to sign up

            try{
                root= FXMLLoader.load(Objects.requireNonNull(DBUtils.class.getResource(fxmlFile)));
                AlertBox("FXML Loader cu register.fxml");

            }catch(IOException eee){
                eee.printStackTrace();
            }

        }

        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 320, 240 ));
        stage.show();

    }

    public static void AlertBox(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message Here...");
        //alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(s);
        alert.showAndWait();
    }

}