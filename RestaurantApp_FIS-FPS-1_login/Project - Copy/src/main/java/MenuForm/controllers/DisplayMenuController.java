package MenuForm.controllers;

import MenuForm.Food.Food;
import MenuForm.services.MenuService;
import javafx.fxml.FXML;
import org.dizitart.no2.objects.Cursor;

public class DisplayMenuController {
    @FXML public void initialize(){
        Cursor<Food> foodList = MenuService.getAllFood();
        for(Food f : foodList){
            System.out.println(f.getName());
        }
    }
}
