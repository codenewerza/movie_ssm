package exception.LoginException;

public class LoginPasswordException extends RuntimeException{
    public LoginPasswordException(String message){
        super(message);
    }
    public LoginPasswordException(String message,Throwable cause){
        super(message,cause);
    }
}
