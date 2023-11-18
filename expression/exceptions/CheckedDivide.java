package expression.exceptions;
import expression.*;

public class CheckedDivide extends Divide {

    public CheckedDivide(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }
    
    @Override
    public int calculate(int x, int y) {
        CalculationChecker.checkDivide(x, y);
        return x / y;
    }
}
