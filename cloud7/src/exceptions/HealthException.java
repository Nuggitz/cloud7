package exceptions;


public class HealthException extends RuntimeException{
    public HealthException() {
        super("health gelijk aan of onder 0");
    }
    
    public HealthException(String message) {
        super(message);
    }
    
    public HealthException(Throwable cause) {
        super(cause);
    }
    
    public HealthException(String message, Throwable cause) {
        super(message, cause);
    }
}
