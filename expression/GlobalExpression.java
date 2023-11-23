package expression;

public interface GlobalExpression {
    void toString(StringBuilder s);

    void toMiniString(StringBuilder s);

    double evaluate(double x, double y, double z);

    double evaluate(double x);
}