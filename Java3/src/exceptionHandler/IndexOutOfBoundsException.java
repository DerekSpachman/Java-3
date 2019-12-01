/*
 * This class is invoked whan an IndexOutOfBoundsException occurs.
 * 
 * @author Derek Spachman (2019)
 */
package exceptionHandler;

public class IndexOutOfBoundsException extends RuntimeException {
    private String message;
    public IndexOutOfBoundsException(String message) { 
        super(message); 
        this.message = message;
    }
    
    public IndexOutOfBoundsException() { }
}