package expression;

import java.util.Objects;
import expression.exceptions.*;

public abstract class AbstractOperation extends AbstractExpression implements Operation {
    private GlobalExpression first;
    private GlobalExpression second;

    public AbstractOperation(GlobalExpression first, GlobalExpression second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int evaluate(int x) {
        return this.calculate(first.evaluate(x), second.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return this.calculate(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    @Override
    public double evaluate(double x) {
        return this.calculate(first.evaluate(x), second.evaluate(x));
    }

    // public double evaluate(double x, double y, double z) {
    // return this.calculate(first.evaluate(x, y, z), second.evaluate(x, y, z));
    // }

    @Override
    public boolean equals(Object object) {
        if (object instanceof AbstractOperation exp) {
            return first.equals(exp.first)
                    && this.getClass().equals(object.getClass())
                    && second.equals(exp.second);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first.hashCode(), second.hashCode(), getSymbol());
    }

    private boolean leftBrackets(GlobalExpression expression) {
        if (getSymbol().equals("set") || getSymbol().equals("clear")) {
            return false;
        }
        if (getSymbol().equals("-") && expression instanceof Set) {
            return true;
        }
        if (expression instanceof AbstractOperation a) {
            return a.getPriority() > this.getPriority();
        }
        return false;
    }

    private boolean rightBrackets(GlobalExpression expression) {
        if (!(expression instanceof Operation a)) {
            return false;
        }
        int child = a.getPriority();
        int parent = this.getPriority();
        if (getSymbol().equals("-")) {
            return child >= parent;
        }
        if (getSymbol().equals("*")) {
            if (a.getSymbol().equals("/")) {
                return true;
            }
            return parent < child;
        }
        if (getSymbol().equals("/")) {
            return true;
        }
        if (getSymbol().equals("set") || getSymbol().equals("clear")) {
            return parent < child || a instanceof Set || a instanceof Clear;
        }
        return parent < child;
    }

    private void toMiniString(GlobalExpression expression, StringBuilder builder, boolean wrapBrackets) {
        if (wrapBrackets) {
            builder.append("(");
        }
        expression.toMiniString(builder);
        if (wrapBrackets) {
            builder.append(")");
        }
    }

    @Override
    public void toString(StringBuilder builder) {
        builder.append("(");
        first.toString(builder);
        builder.append(" ").append(getSymbol()).append(" ");
        second.toString(builder);
        builder.append(")");
    }

    @Override
    public void toMiniString(StringBuilder builder) {
        toMiniString(first, builder, leftBrackets(first));
        builder.append(" ").append(getSymbol()).append(" ");
        toMiniString(second, builder, rightBrackets(second));
    }

    public boolean isOperationOnConst() {
        return first instanceof AbstractValue && second instanceof AbstractValue;
    }
}
