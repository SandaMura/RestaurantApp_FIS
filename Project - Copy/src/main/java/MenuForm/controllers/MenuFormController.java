package MenuForm.controllers;


import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import MenuForm.exceptions.foodAlreadyExistsException;
import MenuForm.services.MenuService;

import javax.swing.*;
import java.io.File;
import java.text.BreakIterator;


public class MenuFormController{

    @FXML
    private Button Button_attach;
    @FXML
    private Button Button_submit;
    @FXML
    private ScrollPane ScrollingForm1;
    @FXML
            private TextField txt_filename;
    @FXML
            private TextField food_name;
    @FXML
            private TextField food_ingredients;
    @FXML
            private TextField prep_time;


    @FXML
            private ImageIcon picture;
    Stage stage;

    public void AttachAction(java.awt.event.ActionEvent event){
       /* stage = (Stage) ScrollingForm1.getScene().getWindow();
        System.out.println("You successfully logged out");
        stage.close();*/

       JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        txt_filename.setText(filename);///show address of the image
        /*
        Image getPath = null;
        ImageIcon icon = new ImageIcon(filename);
        Image image = new Image(filename);
        picture.setImage(image);*/
    }

    public void SubmitAction(ActionEvent event){


            try {
                MenuService.addFood(food_name.getText(), food_ingredients.getText(), Integer.parseInt(prep_time.getText()), txt_filename.getText());
                System.out.println("Dish created and added to the database successfully!");
            } catch (foodAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }



    }


}

