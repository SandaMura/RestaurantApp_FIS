package FoodTests;

import MenuForm.Food.Food;
import MenuForm.exceptions.foodAlreadyExistsException;
import MenuForm.services.MenuService;
import logIn.exceptions.UsernameAlreadyExistsException;
import logIn.model.User;
import logIn.services.FileSystemService;
import logIn.services.UserService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import logIn.exceptions.UsernameAlreadyExistsException;
import logIn.model.User;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class MenuServiceTest {

    public static final String NAME = "food";
    public static final String INGREDIENTS = "ingredient1, ingredient2";
    public static final Integer TIME=10;
    public static final String PATH="/AbsolutePath";
    public static final Double PRICE=49.99;

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.setAppFolder("database-menu-example");
        FileUtils.cleanDirectory(MenuForm.services.FileSystemService.getApplicationHomeFolder().toFile());
        MenuService.initDatabase();
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @Test
    @DisplayName("Database is initialized, and there are no food")
    void testDatabaseIsInitializedAndNoUserIsPersisted() {
        assertThat(MenuService.getAllFood()).isNotNull();
        assertThat(MenuService.getAllFood()).isEmpty();
    }

    @Test
    @DisplayName("Food is successfully persisted to Database")
    void testFoodIsAddedToDatabase() throws foodAlreadyExistsException {
        MenuService.addFood(NAME, INGREDIENTS, TIME, PATH, PRICE );
        assertThat(MenuService.getAllFood()).isNotEmpty();
        assertThat(MenuService.getAllFood()).size().isEqualTo(1);
        Food food = MenuService.getAllFood().firstOrDefault();
        assertThat(food).isNotNull();
        assertThat(food.getName()).isEqualTo(NAME);
        assertThat(food.getIngredients()).isEqualTo(INGREDIENTS);
        assertThat(food.getTime()).isEqualTo(TIME);
        assertThat(food.getPicturePath()).isEqualTo(PATH);
        assertThat(food.getPrice()).isEqualTo(PRICE);


    }

    @Test
    @DisplayName("FOOD can not be added twice")
    void testFoodCanNotBeAddedTwice() {
        assertThrows(foodAlreadyExistsException.class, () -> {
            MenuService.addFood(NAME, INGREDIENTS, TIME, PATH, PRICE );
            MenuService.addFood(NAME, INGREDIENTS, TIME, PATH, PRICE );
        });
    }

}
