package exceptions;


public class LevelException extends RuntimeException{
    
    public LevelException() {
        super("level onder 0");
    }
    
    public LevelException(String message) {
        super(message);
    }
    
    public LevelException(Throwable cause) {
        super(cause);
    }
    
    public LevelException(String message, Throwable cause) {
        super(message, cause);
    }
}
