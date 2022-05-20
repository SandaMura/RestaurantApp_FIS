package testsLogIn;



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

import static org.assertj.core.api.InstanceOfAssertFactories.type;
import static org.testfx.assertions.api.Assertions.assertThat;


@ExtendWith(ApplicationExtension.class)
public class LogInTesting {

    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";


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
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LogInInterface.fxml"));
        primaryStage.setTitle("LogIn Example");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    @Test
    void testLogInFailedWrongUsername(FxRobot robot) {
        robot.clickOn("#usernameField");
        robot.write(USERNAME);
        robot.clickOn("#passwordField");
        robot.write(PASSWORD);
        robot.clickOn("#role");
        //  type(KeyCode.DOWN);
        //type(KeyCode.ENTER);
        robot.clickOn("#adminCheckRB");

        robot.clickOn("#CUIField");
        robot.write("CUI111");

        robot.clickOn("#loginButton");

        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Account does not exist");



    }
}
