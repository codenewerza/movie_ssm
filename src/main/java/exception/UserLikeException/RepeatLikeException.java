package exception.UserLikeException;

//重复收藏异常
public class RepeatLikeException extends RuntimeException{
    public RepeatLikeException(String message){
        super(message);
    }
    public RepeatLikeException(String message,Throwable cause){
        super(message,cause);
    }
}
