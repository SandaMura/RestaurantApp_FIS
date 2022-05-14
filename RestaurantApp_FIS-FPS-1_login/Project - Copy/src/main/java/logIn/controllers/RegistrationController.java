package logIn.controllers;

import App.RestaurantApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logIn.exceptions.UsernameAlreadyExistsException;
import logIn.services.UserService;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox<String> role;

    @FXML
    private Button backToLogin;

    @FXML
    public void initialize() {
        role.getItems().addAll("Customer", "Cook", "Admin");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }



    public void backToLogIn(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) backToLogin.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(RestaurantApplication.class.getClassLoader().getResource("LogInInterface.fxml")));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
