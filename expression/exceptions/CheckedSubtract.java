package expression.exceptions;

import expression.*;

public class CheckedSubtract extends Subtract {

    public CheckedSubtract(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public double calculate(double x, double y) {
        CalculationChecker.checkSubtract(x, y);
        return x - y;
    }
}
