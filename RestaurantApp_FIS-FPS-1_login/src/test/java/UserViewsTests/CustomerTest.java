package UserViewsTests;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import logIn.services.FileSystemService;
import logIn.services.UserService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import logIn.services.FileSystemService;
import logIn.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import Admin.AdminView.*;

import static org.assertj.core.api.InstanceOfAssertFactories.type;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class CustomerTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before Class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After Class");
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Customer_view.fxml"));
        primaryStage.setTitle("Customer Example");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Test
    void testButtons(FxRobot robot) {
        //robot.clickOn("#timerButton");
      //  robot.clickOn("#BackToCustomer");

        robot.clickOn("#goToLogOut");
        robot.clickOn("#backToCustomerMain");

       robot.clickOn("#timerButton");
       robot.clickOn("#backToCustomer");

        robot.clickOn("#MakeOrder");

        robot.clickOn("#goToLogOut");
        robot.clickOn("#CustomerLogOut");



    }

}

