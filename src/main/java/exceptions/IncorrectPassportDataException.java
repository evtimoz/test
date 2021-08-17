package exceptions;

public class IncorrectPassportDataException extends NumberFormatException {
    public IncorrectPassportDataException(String errorMessage) {
        super(errorMessage);
    }
}