package Review.controllers;

import App.RestaurantApplication;
import Review.Review;
import Review.exception.UsernameDoesNotExistsException;
import Review.services.ReviewService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.awt.*;
import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.dizitart.no2.objects.Cursor;

import static logIn.services.DBUtils.AlertBox;

public class ReviewController {



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
    private TableColumn<Review,String > ListOfReview;

    @FXML
    private TableColumn<Review, String> PersonName;

    @FXML
    private TableView<Review> table2;


    @FXML
    public void ListReviews(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) list.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("DisplayReview.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private TextArea TextYourOpinion;
    @FXML
    private Button backCustomer;

    public void backtoCustomer(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) backCustomer.getScene().getWindow();
        try {
            root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("DisplayReview.fxml"));
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}







