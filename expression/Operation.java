package expression;

public interface Operation {
    String getSymbol();

    int getPriority();

    double calculate(double x, double y);

    boolean isOperationOnConst();
}