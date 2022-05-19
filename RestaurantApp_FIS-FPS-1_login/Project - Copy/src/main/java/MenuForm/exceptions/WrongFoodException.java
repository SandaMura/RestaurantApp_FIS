package MenuForm.exceptions;

import static logIn.services.DBUtils.AlertBox;

public class WrongFoodException extends Exception{
    private String name;

    public WrongFoodException(String name) {
        super(String.format("The name %s does not exist!", name));
        AlertBox("This food does not exist!");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}