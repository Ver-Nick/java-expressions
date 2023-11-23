package expression;

public interface UnaryOperation {
    String getSymbol();

    int getPriority();

    double calculate(double x);

    boolean isOperationOnConst();
}