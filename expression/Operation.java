package expression;

public interface Operation {
    String getSymbol();
    int getPriority();
    int calculate(int x, int y);
    double calculate(double x, double y);
    boolean isOperationOnConst();
}