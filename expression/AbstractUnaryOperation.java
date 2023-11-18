package expression;

import java.util.Objects;
import expression.exceptions.*;

public abstract class AbstractUnaryOperation extends AbstractExpression implements UnaryOperation {
    private GlobalExpression expression;

    public AbstractUnaryOperation(GlobalExpression expression) {
        this.expression = expression;
    }

    @Override
    public int evaluate(int x) {
        return this.calculate(expression.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return this.calculate(expression.evaluate(x, y, z));
    }

    @Override
    public double evaluate(double x) {
        return this.calculate(expression.evaluate(x));
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof AbstractUnaryOperation exp) {
            return expression.equals(exp.expression)
                    && this.getClass().equals(object.getClass());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression.hashCode(), this.getClass());
    }

    @Override
    public void toString(StringBuilder builder) {
        builder.append(getSymbol());
        builder.append("(");
        expression.toString(builder);
        builder.append(")");
    }

    public boolean isOperationOnConst() {
        return expression instanceof AbstractValue;
    }

    @Override
    public void toMiniString(StringBuilder builder) {
        builder.append(getSymbol());
        if (expression instanceof AbstractValue || expression instanceof Negative || 
        expression instanceof Count || expression instanceof CheckedNegate || 
        expression instanceof Log10 || expression instanceof Pow10) {
            builder.append(" ");
        }
        if (expression instanceof AbstractOperation) {
            builder.append("(");
        }
        expression.toMiniString(builder);
        if (expression instanceof AbstractOperation) {
            builder.append(")");
        }
    }
}
