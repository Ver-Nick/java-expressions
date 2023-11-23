package expression;

public interface GlobalExpression {
    void toString(StringBuilder s);

    void toMiniString(StringBuilder s);

    int evaluate(int x);

    int evaluate(int x, int y, int z);

    double evaluate(double x);
}