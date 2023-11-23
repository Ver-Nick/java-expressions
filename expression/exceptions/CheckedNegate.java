package expression.exceptions;

import expression.*;

public class CheckedNegate extends Negative {

    public CheckedNegate(GlobalExpression first) {
        super(first);
    }

    @Override
    public double calculate(double x) {
        CalculationChecker.checkNegate(x);
        return -x;
    }
}
