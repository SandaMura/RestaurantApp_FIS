package MenuForm.controllers;

import MenuForm.Food.Food;
import MenuForm.services.MenuService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.dizitart.no2.objects.Cursor;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import static logIn.services.DBUtils.AlertBox;


public class DisplayMenuController {

    @FXML
    private TableColumn<Food, String> Ingredients;

    @FXML
    private TableColumn<Food, String> Name;

    @FXML
    private TableColumn<Food, String> Picture;

    @FXML
    private TableColumn<Food, Double> Price;

    @FXML
    private TableView<Food> Table;

    @FXML
    private TableColumn<Food, Integer> Time;


    @FXML public void initialize(){
        Name.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
        Picture.setCellValueFactory(new PropertyValueFactory<Food, String>("PicturePath"));
        Ingredients.setCellValueFactory(new PropertyValueFactory<Food, String>("ingredients"));
        Time.setCellValueFactory(new PropertyValueFactory<Food, Integer>("time"));
        Price.setCellValueFactory(new PropertyValueFactory<Food, Double>("price"));


        ObservableList<Food> products = FXCollections.observableArrayList();
        Cursor<Food> foodList = MenuService.getAllFood();
        for(Food f : foodList){
            products.add(f);
        }
        Table.setItems(products);
    }
   public static ObservableList<String> Order=FXCollections.observableArrayList();

    public void AddOrder(ActionEvent actionEvent) {
        Food food=Table.getSelectionModel().getSelectedItem();
         if(food!=null) {
             Order.add(food.getName());
         AlertBox("Dish \"" +food.getName() + "\" added to order");
         }
         else
             AlertBox("Please select a dish");
    }
    public static ObservableList<String> getList(){
        return Order;
    }


}