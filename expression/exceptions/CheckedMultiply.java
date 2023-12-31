package expression.exceptions;

import expression.*;

public class CheckedMultiply extends Multiply {

    public CheckedMultiply(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public double calculate(double x, double y) {
        CalculationChecker.checkMultiply(x, y);
        return x * y;
    }
}
