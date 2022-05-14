package logIn.controllers;

import App.RestaurantApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logIn.exceptions.loginFailed;
import logIn.services.DBUtils;
import logIn.services.UserSearch;

import java.io.IOException;


public class LogInController {

    @FXML
    private Button ExitButton;

    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    @FXML
    private RadioButton customerCheckRB;
    @FXML
    private RadioButton cookCheckRB;
    @FXML
    private RadioButton adminCheckRB;

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField CUIfield;


    @FXML
    private Button Test;

    private void AlertBox(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message Here...");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void loginButtonAction(ActionEvent e) {
        System.out.println("DEBUG: Utilizator incearca sa se logheze");

        //AlertBox("DEBUG: Utilizator a apasat butonul LOGIN");


        ///verific daca username-ul si parola sunt in baza de date USERS: database
        ///Daca nu sunt in baza de date, notific utilizatorul
        ///Daca sunt deja inregistrati, deschid interfata corespunzator rolului

        try {
            if (customerCheckRB.isSelected()) {
                //search in database for the customer role
                AlertBox("Utilizatorul este CUSTOMER");
                System.out.println("DEBUG: Utilizator incearca sa se logheze drept CUSTOMER");
                if (UserSearch.searchUserCustomer(usernameField.getText(), passwordField.getText())) {
                    ///change the scene

                    Stage stage;
                    Parent root;
                    stage = (Stage) loginButton.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("Customer_view.fxml"));

                    stage.setScene(new Scene(root, 600, 450));
                    stage.show();

                }

                System.out.println("DEBUG: Utilizator s-a logat CUSTOMER");
            }



        if (cookCheckRB.isSelected()) {
            ///search in database for the cook role
            AlertBox("Utilizatorul este COOK");
            System.out.println("DEBUG: Utilizator incearca sa se logheze drept COOK");

            if (UserSearch.searchUserCook(usernameField.getText(), passwordField.getText())) {
                ///change the scene
                Stage stage;
                Parent root;
                stage = (Stage) loginButton.getScene().getWindow();
                root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("Cook_view.fxml"));

                stage.setScene(new Scene(root, 600, 450));
                stage.show();
                System.out.println("DEBUG: Utilizator s-a logat COOK");
            }
        }
        if (adminCheckRB.isSelected()) {
            if (CUIfield.getText().equals("CUI111")) {
                System.out.println("DEBUG: Utilizator incearca sa se logheze drept ADMIN cu username-ulRATATATA " + usernameField.getText() );
                //AlertBox("Utilizatorul este ADMIN");
                if (UserSearch.searchUserAdmin(usernameField.getText(), passwordField.getText())) {
                    ///change the scene
                    ///AlertBox("Utilizatorul este ADMIN si are cont");
                    System.out.println("DEBUG: ADMINN");
                    Stage stage;
                    Parent root;
                    stage = (Stage) loginButton.getScene().getWindow();
                    root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("Admin_view.fxml"));

                    stage.setScene(new Scene(root, 600, 450));
                    stage.show();

                    System.out.println("DEBUG: Utilizator s-a logat ADMIN");
                } else{
                   // AlertBox("Utilizatorul este ADMIN si NU are cont");
                    System.out.println("DEBUG: else ADMINN");
                }
            } else {
                AlertBox("Adminul nu a introdus CUI corect");

            }
        }
    }catch(loginFailed incorrect){
                loginFailed.setText(incorrect.getMessage());
            AlertBox("Ati introdus username-ul sau parola incorecta");
               } catch (IOException ex) {

            AlertBox("Ati introdus username-ul sau parola incorecta");
            throw new RuntimeException(ex);

        }
    }
    public void exitButtonAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage) ExitButton.getScene().getWindow();
        stage.close();

    }

    public void registerButton(ActionEvent actionEvent) {
       // AlertBox("The user wants to create a new account");
        Stage stage;
        Parent root;
        stage = (Stage) registerButton.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("register.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }




        AlertBox("The changeScene method happened");
    }
    /*
    public void test(ActionEvent actionEvent) {

        Stage stage;
        Parent root;
        stage = (Stage) Test.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("FormInterface.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

}
