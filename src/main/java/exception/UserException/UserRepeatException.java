package exception.UserException;

public class UserRepeatException extends RuntimeException{
    public UserRepeatException(String message){
        super(message);
    }
    public UserRepeatException(String message,Throwable cause){
        super(message,cause);
    }
}
