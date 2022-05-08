package logIn.services;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
                root= FXMLLoader.load(DBUtils.class.getResource(fxmlFile));

            }catch(IOException eee){
                eee.printStackTrace();
            }

        }

        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 320, 240 ));
        stage.show();

    }

}