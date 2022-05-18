package MenuForm.exceptions;

public class WrongFoodException extends Exception{
    private String name;

    public WrongFoodException(String name) {
        super(String.format("The name %s does not exist!", name));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}