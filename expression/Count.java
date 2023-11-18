package expression;

public class Count extends AbstractUnaryOperation {

    public Count(GlobalExpression expression) {
        super(expression);
    }

    @Override
    public String getSymbol() {
        return "count";
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public int calculate(int x) {
        return Integer.bitCount(x);
    }

    @Override
    public double calculate(double x) {
        return Integer.bitCount((int) x);
    }
}
