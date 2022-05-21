package Review;

import MenuForm.exceptions.foodAlreadyExistsException;
import MenuForm.services.MenuService;
import Review.services.ReviewService;
import javafx.fxml.FXML;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static logIn.services.DBUtils.AlertBox;

public class ReviewController {

    public void ListReviews(javafx.event.ActionEvent actionEvent) {
    }

    public void SaveReview(javafx.event.ActionEvent actionEvent) throws UsernameDoesNotExistsException {
        System.out.println("vreau sa las un review de genul " + opinion.getText());


           int x=0; try {
                ReviewService.checkUsername(check.getText());
                AlertBox("This username is correct");
                x=1;
            } catch (UsernameDoesNotExistsException fe) {
                System.out.println(fe.getMessage());
            }
            if(x==1){
                ReviewService.addReview(opinion.getText(), check.getText());
                AlertBox("Review Sent!Thank you for implication !");

            }
        }


    public void checkUser(javafx.event.ActionEvent actionEvent) {
        System.out.println("vreau sa verific daca exista username ul  " + check.getText());
        try {
            ReviewService.checkUsername(check.getText());
            AlertBox("This username is correct");
        } catch (UsernameDoesNotExistsException fe) {
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
    private TextField opinion;

    @FXML
    void ListReviews(ActionEvent event) {

    }

    @FXML
    private TextArea TextYourOpinion;
}







