package exceptions;


public class CritException extends RuntimeException {
    
    public CritException() {
        super("crit onder 0 of boven 100");
    }
    
    public CritException(String message) {
        super(message);
    }
    
    public CritException(Throwable cause) {
        super(cause);
    }
    
    public CritException(String message, Throwable cause) {
        super(message, cause);
    }
}
