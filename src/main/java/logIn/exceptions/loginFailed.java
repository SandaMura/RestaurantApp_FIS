package logIn.exceptions;

public class loginFailed extends Exception{


    public loginFailed() {
        super(String.format("Username or Password are incorrect!"));

    }

    public static void setText(String message) {
    }
}
