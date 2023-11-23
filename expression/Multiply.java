package expression;

public class Multiply extends AbstractOperation {

    public Multiply(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public String getSymbol() {
        return "*";
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public double calculate(double x, double y) {
        return x * y;
    }
}
