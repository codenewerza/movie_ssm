package exception.MovieException;

public class RepeatRepeatException extends RuntimeException{
    public RepeatRepeatException(String message){
        super(message);
    }
    public RepeatRepeatException(String message,Throwable cause){
        super(message,cause);
    }
}
