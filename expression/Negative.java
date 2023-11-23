package expression;

public class Negative extends AbstractUnaryOperation {

    public Negative(GlobalExpression expression) {
        super(expression);
    }

    @Override
    public String getSymbol() {
        return "-";
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public double calculate(double x) {
        return -x;
    }

}
