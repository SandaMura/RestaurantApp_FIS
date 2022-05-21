package Review.controllers;

import MenuForm.Food.Food;
import MenuForm.services.MenuService;
import Review.Review;
import Review.services.ReviewService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.dizitart.no2.objects.Cursor;


public class DisplayReviewController {

    @FXML
    private TableColumn<Review,    String> Review;

    @FXML
    private TableColumn<Review, String> Name;

    @FXML
    private TableView<Review> table2;

    @FXML public void initialize(){
        Name.setCellValueFactory(new PropertyValueFactory<Review, String>("Username"));
        Review.setCellValueFactory(new PropertyValueFactory<Review, String>("Text"));

        ObservableList<Review> products = FXCollections.observableArrayList();
        Cursor<Review> reviewList = ReviewService.getAllReview();
        for(Review f : reviewList){
            products.add(f);
        }
        table2.setItems(products);
    }
}
