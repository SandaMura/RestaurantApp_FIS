package testsLogIn;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import logIn.controllers.LogInController;
import logIn.exceptions.UsernameAlreadyExistsException;
import logIn.exceptions.loginFailed;
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

import static org.assertj.core.api.InstanceOfAssertFactories.type;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;
import static testsLogIn.UserServiceTest.ADMIN;


@ExtendWith(ApplicationExtension.class)
public class LogInTesting {

    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";


    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.setAppFolder("database-registration-example");
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After Class");
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LogInInterface.fxml"));
        primaryStage.setTitle("LogIn Example");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Test
    void testLogInFailedWrongCUI(FxRobot robot) {
        robot.clickOn("#usernameField");
        robot.write(USERNAME);
        robot.clickOn("#passwordField");
        robot.write(PASSWORD);
        //  type(KeyCode.DOWN);
        //type(KeyCode.ENTER);
        robot.clickOn("#adminCheckRB");

        robot.clickOn("#CUIfield");
        robot.write("CUI222"); ///CUI gresit

        robot.clickOn("#loginButton");

        //robot.clickOn("#registerButton");

        robot.clickOn("OK");

        //assertThat(LogInController.AlertBox());


    }


    @Test
    void testLogInSuccess(FxRobot robot) {

        //robot.clickOn("#registerButton");

        robot.clickOn("#registerButton");

        robot.clickOn("#usernameField");
        robot.write(USERNAME+1);
        robot.clickOn("#passwordField");
        robot.write(PASSWORD);
        robot.clickOn("#role");
        robot.clickOn("Admin");

        robot.clickOn("#RegButton");

        robot.clickOn("#backToLogin");

        robot.clickOn("#usernameField");
        robot.write(USERNAME+1);
        robot.clickOn("#passwordField");
        robot.write(PASSWORD);
        //  type(KeyCode.DOWN);
        //type(KeyCode.ENTER);
        robot.clickOn("#adminCheckRB");

        robot.clickOn("#CUIfield");
        robot.write("CUI111"); ///CUI gresit

        robot.clickOn("#loginButton");

        //assertThat(LogInController.AlertBox());


    }

    @Test
    void testLogInExit(FxRobot robot){

        robot.clickOn("#ExitButton");
    }


}
