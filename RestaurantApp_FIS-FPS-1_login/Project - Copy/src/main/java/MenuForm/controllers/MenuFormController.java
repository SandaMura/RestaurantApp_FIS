package MenuForm.controllers;


import App.RestaurantApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Objects;

import static logIn.services.DBUtils.AlertBox;


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
            private ImageView Picture;

    @FXML
            private Button Back;
    Stage stage;



    public void SubmitAction(ActionEvent event){

        System.out.println("vreau sa inserez" + food_name.getText());
            try {
                MenuService.addFood(food_name.getText(), food_ingredients.getText(), Integer.parseInt(prep_time.getText()), txt_filename.getText());
                AlertBox("Dish created and added to the database successfully!");
            } catch (foodAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }



    }


    public void AttachAction(ActionEvent actionEvent) {
         /* stage = (Stage) ScrollingForm1.getScene().getWindow();
        System.out.println("You successfully logged out");
        stage.close();*/

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        AlertBox("fisier " + f.toString());
        String filename = f.toString();
        txt_filename.setText(filename);///show address of the image

        Image getPath = null;
        ImageIcon icon = new ImageIcon(filename);
        Image image = new Image(filename);
        Picture.setImage(image);
    }

    public void backToMain(ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) Back.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("Admin_view.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

