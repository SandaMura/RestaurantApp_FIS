package testsLogIn;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import logIn.services.FileSystemService;
import logIn.services.UserService;
import org.apache.commons.io.FileUtils;
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
class RegistrationTest {

    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.setAppFolder("database-registration-example");
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Registration Example");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    @Test
    void testRegistration(FxRobot robot) {
        robot.clickOn("#usernameField");
        robot.write(USERNAME);
        robot.clickOn("#passwordField");
        robot.write(PASSWORD);
        robot.clickOn("#role");
        robot.clickOn("Customer");
      //  type(KeyCode.DOWN);
        //type(KeyCode.ENTER);
        robot.clickOn("#RegButton");

        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Account created successfully!");
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
 ///incearca sa faci un cont cu acelasi nume

        robot.clickOn("#RegButton");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(
                String.format("An account with the username %s already exists!", USERNAME)
        );

        ///fa un al doilea cont cu nume diferit
        robot.clickOn("#usernameField");
        robot.write("Ana");
        robot.clickOn("#RegButton");

        assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Account created successfully!");
        assertThat(UserService.getAllUsers()).size().isEqualTo(2);
    }


}

