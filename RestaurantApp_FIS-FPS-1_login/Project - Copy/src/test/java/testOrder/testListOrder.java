package testOrder;

import MenuForm.Food.Food;
import logIn.exceptions.UsernameAlreadyExistsException;
import logIn.model.User;
import logIn.services.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import MenuForm.controllers.DisplayMenuController.*;

import static org.assertj.core.api.Assertions.assertThat;

public class testListOrder {

    public String neworder= "mamaliga";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before Class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After Class");
    }

    @Test
    @DisplayName("User is successfully persisted to Database")
    void testOrderIsAddedToList() throws UsernameAlreadyExistsException {

        MenuForm.controllers.DisplayMenuController.Order.add(neworder);

        assertThat((MenuForm.controllers.DisplayMenuController.getList3()).isNotNull());
    }

}
