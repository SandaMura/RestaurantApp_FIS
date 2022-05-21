package TimerTests;

import Timer.Time;
import javafx.fxml.FXML;
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

import javafx.scene.*;
import javafx.scene.control.Button;

import java.awt.*;

import static org.assertj.core.api.InstanceOfAssertFactories.type;
import static org.testfx.assertions.api.Assertions.assertThat;


@ExtendWith(ApplicationExtension.class)
public class TimerForm {

    @FXML
    private Button backToCustomer;

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
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("timer.fxml"));
        primaryStage.setTitle("Registration Example");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Test
    void testCookTimer(FxRobot robot){

        robot.clickOn("#stopwatchCook");
        Time stopwatch=new Time();
        stopwatch.start();
       // robot.clickOn("Start");

        robot.clickOn("#backToCook");

        assertThat("Cook.fxml").isNotNull();


    }

   @Test
   void testCustomerTimer(FxRobot robot){
       robot.clickOn("#stopwatchCook");
       Time stopwatch=new Time();
       stopwatch.start();

        robot.clickOn("#stopwatchClient");
        robot.clickOn(("OK"));
        //robot.clickOn("Start");

       robot.clickOn("#backToCustomer");


       assertThat("Customer.fxml").isNotNull();

    }

}
