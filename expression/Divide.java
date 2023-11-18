package expression;

public class Divide extends AbstractOperation {

    public Divide(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public int calculate(int x, int y) {
        return x / y;
    }

    @Override
    public double calculate(double x, double y) {
        return x / y;
    }
}
