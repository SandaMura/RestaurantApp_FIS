package FoodTests;


import MenuForm.services.MenuService;
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



@ExtendWith(ApplicationExtension.class)
public class FillingFormTest {

    public static final String NAME = "food";
    public static final String INGREDIENTS = "ingredient1, ingredient2";
    public static final Integer TIME=10;
    public static final String PATH="/AbsolutePath";
    public static final Double PRICE=49.99;

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.setAppFolder("database-menu-example");
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(MenuForm.services.FileSystemService.getApplicationHomeFolder().toFile());
        MenuService.initDatabase();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After Class");
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FormInterface.fxml"));
        primaryStage.setTitle("Add new food Example");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }

    @Test
    void testInsertSuccess(FxRobot robot) {
        robot.clickOn("#food_name");
        robot.write(NAME);
        robot.clickOn("#food_ingredients");
        robot.write(INGREDIENTS);
        robot.clickOn("#prep_time");
        robot.write(String.valueOf(TIME));

        robot.clickOn("#price");
        robot.write(String.valueOf(PRICE));

       // robot.clickOn("#Button_attach");
        robot.clickOn("#txt_filename");
        robot.write(PATH);



       robot.clickOn("#Button_submit");

    }

    @Test
    void testInsertFail(FxRobot robot) {
        robot.clickOn("#food_name");
        robot.write(NAME);
        robot.clickOn("#food_ingredients");
        robot.write(INGREDIENTS);
        robot.clickOn("#prep_time");
        robot.write(String.valueOf(TIME));

        robot.clickOn("#price");
        robot.write(String.valueOf(PRICE));

        // robot.clickOn("#Button_attach");
        robot.clickOn("#txt_filename");
        robot.write(PATH);



        robot.clickOn("#Button_submit");

        robot.clickOn(("OK"));

        robot.clickOn("#Button_submit");

    }

    @Test
    void testTimeUpdate(FxRobot robot) {
        robot.clickOn("#food_name");
        robot.write(NAME);
        robot.clickOn("#food_ingredients");
        robot.write(INGREDIENTS);
        robot.clickOn("#prep_time");
        robot.write(String.valueOf(TIME));

        robot.clickOn("#price");
        robot.write(String.valueOf(PRICE));

        // robot.clickOn("#Button_attach");
        robot.clickOn("#txt_filename");
        robot.write(PATH);



        robot.clickOn("#Button_submit");

        robot.clickOn(("OK"));

        ///update timpul de prep

        robot.clickOn("#prep_time");
        robot.write(String.valueOf(20));
        robot.clickOn("#UpdatefoodTime");

    }
    @Test
    void testDelete(FxRobot robot) {
        robot.clickOn("#food_name");
        robot.write(NAME);
        robot.clickOn("#food_ingredients");
        robot.write(INGREDIENTS);
        robot.clickOn("#prep_time");
        robot.write(String.valueOf(TIME));

        robot.clickOn("#price");
        robot.write(String.valueOf(PRICE));

        // robot.clickOn("#Button_attach");
        robot.clickOn("#txt_filename");
        robot.write(PATH);



        robot.clickOn("#Button_submit");

        robot.clickOn(("OK"));

        ///update timpul de prep

        robot.clickOn("#Button_delete");

    }

    @Test
    void testShow(FxRobot robot) {
        robot.clickOn("#food_name");
        robot.write(NAME);
        robot.clickOn("#food_ingredients");
        robot.write(INGREDIENTS);
        robot.clickOn("#prep_time");
        robot.write(String.valueOf(TIME));

        robot.clickOn("#price");
        robot.write(String.valueOf(PRICE));

        // robot.clickOn("#Button_attach");
        robot.clickOn("#txt_filename");
        robot.write(PATH);



        robot.clickOn("#Button_submit");

        robot.clickOn(("OK"));

        ///update timpul de prep

        robot.clickOn("#ShowButton");

    }

}
