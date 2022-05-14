package MenuForm.exceptions;


public class foodAlreadyExistsException extends Exception {

    private String name;

    public foodAlreadyExistsException(String name) {
        super(String.format("A dish with the name %s already exists!", name));
        this.name = name;
    }

    public String getUsername() {
        return name;
    }
}