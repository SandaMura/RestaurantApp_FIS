package MenuForm.exceptions;


import static logIn.services.DBUtils.AlertBox;

public class foodAlreadyExistsException extends Exception {

    private String name;

    public foodAlreadyExistsException(String name) {
        super(String.format("A dish with this name already exists!"));
        AlertBox("A dish with this name already exists!");
        this.name = name;
    }

    public String getUsername() {
        return name;
    }
}