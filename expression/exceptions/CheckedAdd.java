package expression.exceptions;
import expression.*;

public class CheckedAdd extends Add {

    public CheckedAdd(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public int calculate(int x, int y) {
        CalculationChecker.checkAdd(x, y);
        return x + y;
    }
}
