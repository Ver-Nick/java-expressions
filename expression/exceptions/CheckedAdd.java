package expression.exceptions;

import expression.*;

public class CheckedAdd extends Add {

    public CheckedAdd(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public double calculate(double x, double y) {
        CalculationChecker.checkAdd(x, y);
        return x + y;
    }
}
