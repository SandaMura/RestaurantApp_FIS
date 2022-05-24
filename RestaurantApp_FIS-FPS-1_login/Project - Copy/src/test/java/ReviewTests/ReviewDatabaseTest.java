package ReviewTests;

import MenuForm.exceptions.foodAlreadyExistsException;
import MenuForm.services.MenuService;
import Review.controllers.DisplayReviewForAdminController;
import Review.controllers.Review;
import Review.services.*;
import Review.exception.*;

import Review.controllers.DisplayReviewController;
import javafx.event.ActionEvent;
import logIn.services.FileSystemService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class ReviewDatabaseTest {

    public static final String USER = "user2";
    public static final String TEXT = "Complimente bucatarului!";


    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.setAppFolder("database-reviews-example");
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
        assertThat(DisplayReviewController.getNewList()).isNotNull();
        assertThat(DisplayReviewController.getNewList().isEmpty());
    }

    @Test
    @DisplayName("Review is successfully persisted to Database")
    void testReviewIsAddedToDatabase() throws foodAlreadyExistsException {

      try{
          ReviewService.addReview(USER, TEXT );
      }catch(UsernameDoesNotExistsException e){
          System.out.println(e);
      }
        assertThat(MenuService.getAllFood()).isNotEmpty();
        assertThat(MenuService.getAllFood()).size().isEqualTo(1);
        Review review = ReviewService.getAllReview().firstOrDefault();
        assertThat(review).isNotNull();
        assertThat(review.getUsername()).isEqualTo(USER);
        assertThat(review.getText()).isEqualTo(TEXT);



    }

    @Test
    void testReviewIsDeletedToDatabase() {

        try{
            ReviewService.addReview(USER, TEXT );
        }catch(UsernameDoesNotExistsException e){
            System.out.println(e);
        }

        ActionEvent event = null;


            DisplayReviewForAdminController.deleteRv(event);

      
        Review review = ReviewService.getAllReview().firstOrDefault();
        assertThat(review).isNull();
       // assertThat(review.getUsername()).isEqualTo(USER);
       // assertThat(review.getText()).isEqualTo(TEXT);



    }



}

