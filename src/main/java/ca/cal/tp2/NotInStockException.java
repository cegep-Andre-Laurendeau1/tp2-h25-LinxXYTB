package ca.cal.tp2;

public class NotInStockException extends Exception {
    public NotInStockException(String message) {
        super(message + " is not in stock");
    }
}
