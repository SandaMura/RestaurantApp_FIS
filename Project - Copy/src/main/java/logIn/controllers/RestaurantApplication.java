package logIn.controllers;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logIn.services.UserService;

import java.io.IOException;

public class RestaurantApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        UserService.initDatabase();
        FXMLLoader fxmlLoader = new FXMLLoader(RestaurantApplication.class.getClassLoader().getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Project_FIS_restaurant");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
