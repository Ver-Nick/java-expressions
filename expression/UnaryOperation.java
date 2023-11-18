package expression;

public interface UnaryOperation {
    String getSymbol();
    int getPriority();
    int calculate(int x);
    double calculate(double x);
    boolean isOperationOnConst();
}