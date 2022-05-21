package MenuForm.exceptions;

import static logIn.services.DBUtils.AlertBox;

public class WrongFoodException extends Exception{
    private String name;

    public WrongFoodException(String name) {
        super(String.format("The name  does not exist!"));
        AlertBox("This food does not exist!");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}