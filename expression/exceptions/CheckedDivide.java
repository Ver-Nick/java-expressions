package expression.exceptions;

import expression.*;

public class CheckedDivide extends Divide {

    public CheckedDivide(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public double calculate(double x, double y) {
        CalculationChecker.checkDivide(x, y);
        return x / y;
    }
}
