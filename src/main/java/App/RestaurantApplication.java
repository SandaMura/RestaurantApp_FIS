package App;


import MenuForm.services.MenuService;
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
        System.out.println("DEBUG: Am initializat baza de date USERS");
        MenuService.initDatabase();
        System.out.println("DEBUG: Am initializat baza de date FOOD");
        //ReviewService.initDatabase();
        //System.out.println("DEBUG: Am initializat baza de date REVIEW");
        //FXMLLoader fxmlLoader = new FXMLLoader(RestaurantApplication.class.getClassLoader().getResource("register.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(RestaurantApplication.class.getClassLoader().getResource("FormInterface.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(RestaurantApplication.class.getClassLoader().getResource("FormInterface.fxml"));
        System.out.println("DEBUG: Deschide fereastra de login!");

        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        System.out.println("DEBUG: Deschide fereastra de login!");
        stage.setTitle("Project_FIS_restaurant");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
