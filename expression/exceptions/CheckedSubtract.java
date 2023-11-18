package expression.exceptions;
import expression.*;

public class CheckedSubtract extends Subtract {

    public CheckedSubtract(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public int calculate(int x, int y) {
        CalculationChecker.checkSubtract(x, y);
        return x - y;
    }
}
