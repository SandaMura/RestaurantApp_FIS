package logIn.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import static logIn.services.UserSearch;




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


    public void exitButtonAction(ActiveEvent e){
        Stage stage=(Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonAction(ActionEvent e){
        System.out.println("DEBUG: Utilizator incearca sa se logheze");

        ///verific daca username-ul si parola sunt in baza de date USERS: database
        ///Daca nu sunt in baza de date, notific utilizatorul
        ///Daca sunt deja inregistrati, deschid interfata corespunzator rolului
        if(customerCheckRB.isSelected()){
                //search in database for the customer role

            System.out.println("DEBUG: Utilizator incearca sa se logheze drept CUSTOMER");
            if(cookCheck(usernameField.getText(), passwordField.getText())){
                ///change the scene
                System.out.println("DEBUG: Utilizator s-a logat CUSTOMER");
            }

            }
        }
        if(cookCheckRB.isSelected()){
                   ///search in database for the cook role
            System.out.println("DEBUG: Utilizator incearca sa se logheze drept COOK");

            if(cookCheck(usernameField.getText(), passwordField.getText())){
                ///change the scene
                System.out.println("DEBUG: Utilizator s-a logat COOK");
            }
        }
        if(adminCheckRB.isSelected()){
                   if(CUIfield.getText()=="CUI111");
            System.out.println("DEBUG: Utilizator incearca sa se logheze drept ADMIN");

            if(adminCheck(usernameField.getText(), passwordField.getText())){
                ///change the scene
                System.out.println("DEBUG: Utilizator s-a logat ADMIN");
            }


        }
    }
  ///change scene: from login to sign up
    public static void registerButton(ActionEvent e, String fxmlFile) throws IOException {

    }


}
