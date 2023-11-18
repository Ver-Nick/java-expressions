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
    public int calculate(int x) {
        return -x;
    }

    @Override
    public double calculate(double x) {
        return -x;
    }
    
}
