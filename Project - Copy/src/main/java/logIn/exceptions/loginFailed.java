package logIn.exceptions;

public class loginFailed extends Exception{


    public loginFailed(String username) {
        super(String.format("Username or Password are incorrect!");

    }
}
