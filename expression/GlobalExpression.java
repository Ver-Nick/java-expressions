package expression;

public interface GlobalExpression extends Expression, DoubleExpression, TripleExpression {
    void toString(StringBuilder s);
    void toMiniString(StringBuilder s);
}