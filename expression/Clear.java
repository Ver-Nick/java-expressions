package expression;

public class Clear extends AbstractOperation {

    public Clear(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public String getSymbol() {
        return "clear";
    }

    @Override
    public int getPriority() {
        return 30;
    }

    @Override
    public int calculate(int x, int y) {
        return x & ~(1 << y);
    }

    @Override
    public double calculate(double x, double y) {
        throw new UnsupportedOperationException("Can't clear bits on double");
    }
}
