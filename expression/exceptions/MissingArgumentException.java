package expression.exceptions;

public class MissingArgumentException extends ExpressionException {
    public MissingArgumentException(String message) {
        super(message);
    }
}