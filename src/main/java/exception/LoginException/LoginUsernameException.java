package exception.LoginException;

public class LoginUsernameException extends RuntimeException{
    public LoginUsernameException(String message){
        super(message);
    }
    public LoginUsernameException(String message,Throwable cause){
        super(message,cause);
    }
}
