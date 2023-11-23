package expression;

public class Const extends AbstractValue {
    private final Number constValue;

    public Const(int x) {
        super(x + "");
        constValue = x;
    }

    public Const(double x) {
        super(x + "");
        constValue = x;
    }

    @Override
    public int hashCode() {
        return constValue.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Const a) {
            return constValue.equals(a.constValue);
        }
        return false;
    }

    @Override
    public double evaluate(double x) {
        return constValue.doubleValue();
    }

    @Override
    public double evaluate(double x, double y, double z) {
        return constValue.doubleValue();
    }
}
