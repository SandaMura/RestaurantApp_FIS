package Review;

import Review.services.ReviewService;
import javafx.fxml.FXML;
import java.awt.*;
import java.awt.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static logIn.services.DBUtils.AlertBox;

public class ReviewController {

    public void ListReviews(javafx.event.ActionEvent actionEvent) {
    }

    public void SaveReview(javafx.event.ActionEvent actionEvent) {
    }
    public void checkUser(javafx.event.ActionEvent actionEvent) {
        System.out.println("vreau sa verific daca exista username ul  " + check.getText());
       try {
            ReviewService.checkUsername(check.getText());
            AlertBox("This username is correct");
        }catch(UsernameDoesNotExistsException fe){
            System.out.println(fe.getMessage());
        }
    }
        @FXML
        private TextField check;

        @FXML
        private Button list;
        @FXML
        private Button checkUs;
        @FXML
        private Button save;
        @FXML
        private TextArea writeOpinion;
        @FXML
        void ListReviews(ActionEvent event) {

        }

        @FXML
        void SaveReview(ActionEvent event) {

        }


        }




