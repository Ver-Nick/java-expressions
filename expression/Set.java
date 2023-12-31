package expression;

public class Set extends AbstractOperation {

    public Set(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public String getSymbol() {
        return "set";
    }

    @Override
    public int getPriority() {
        return 30;
    }

    @Override
    public double calculate(double x, double y) {
        throw new UnsupportedOperationException("Can't set bits on double");
    }
}
