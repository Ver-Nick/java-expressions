package expression.exceptions;
import expression.*;

public class Pow10 extends AbstractUnaryOperation {
    public Pow10(GlobalExpression expression) {
        super(expression);
    }

    @Override
    public String getSymbol() {
        return "pow10";
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public int calculate(int x) {
        CalculationChecker.checkPow10(x);
        return (int) Math.pow(10, x);
    }

    @Override
    public double calculate(double x) {
        return Math.pow(10, x);
    }
}