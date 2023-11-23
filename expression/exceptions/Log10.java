package expression.exceptions;

import expression.*;

public class Log10 extends AbstractUnaryOperation {
    public Log10(GlobalExpression expression) {
        super(expression);
    }

    @Override
    public String getSymbol() {
        return "log10";
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public double calculate(double x) {
        return Math.log10(x);
    }
}