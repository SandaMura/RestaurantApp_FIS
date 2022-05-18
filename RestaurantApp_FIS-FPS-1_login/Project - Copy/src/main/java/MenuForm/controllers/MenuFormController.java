package MenuForm.controllers;


import App.RestaurantApplication;
import MenuForm.Food.Food;
import MenuForm.exceptions.WrongFoodException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import MenuForm.exceptions.foodAlreadyExistsException;
import MenuForm.services.MenuService;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static MenuForm.services.MenuService.checkDelete;
import static MenuForm.services.MenuService.foodRepository;
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
           private TextField price;


    @FXML
            private ImageView Picture;

    @FXML
            private Button Back;
    @FXML
        private Button ShowButton;
    Stage stage;



    @FXML public void initialize(){
        ShowButton.setOnAction(this::ShowData);
    }
    @FXML
    public void ShowData(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) ShowButton.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("DisplayMenu.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SubmitAction(ActionEvent event){

            System.out.println("vreau sa inserez" + food_name.getText());
            try {
                MenuService.addFood(food_name.getText(), food_ingredients.getText(), Integer.parseInt(prep_time.getText()), txt_filename.getText(), Double.parseDouble(price.getText()));
                AlertBox("Dish created and added to the database successfully!");
            } catch (foodAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }
        }

    public void DeleteAction(ActionEvent event) throws WrongFoodException {
        System.out.println("vreau sa sterg " + food_name.getText());
        try {
            MenuService.checkDelete(food_name.getText());
            AlertBox("Dish deleted from database successfully!");
            // catch (WrongFoodException e) {
            //   System.out.println(e.getMessage());
        }catch(WrongFoodException w){
            System.out.println(w.getMessage());
        }
    }
    public void UpdateTime(ActionEvent event){

        System.out.println("vreau sa modific timpul pentru " + food_name.getText());
        MenuService.UpdateTime(food_name.getText(),Integer.valueOf(prep_time.getText()));

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

