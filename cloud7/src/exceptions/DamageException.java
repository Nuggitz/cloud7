package exceptions;


public class DamageException extends RuntimeException {
    public DamageException() {
        super("damage onder 0");
    }
    
    public DamageException(String message) {
        super(message);
    }
    
    public DamageException(Throwable cause) {
        super(cause);
    }
    
    public DamageException(String message, Throwable cause) {
        super(message, cause);
    }
}
