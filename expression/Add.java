package expression;

public class Add extends AbstractOperation {

    public Add(GlobalExpression first, GlobalExpression second) {
        super(first, second);
    }

    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public int getPriority() {
        return 20;
    }

    @Override
    public int calculate(int x, int y) {
        return x + y;
    }

    @Override
    public double calculate(double x, double y) {
        return x + y;
    }
}
