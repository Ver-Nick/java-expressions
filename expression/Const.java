package expression;

public class Const extends AbstractValue {
    private final Number constValue;

    public Const(int x){
        super(x + "");
        constValue = x;
    }

    public Const(double x){
        super(x + "");
        constValue = x;
    }

    @Override
    public int evaluate(int x) {
        return constValue.intValue();
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return constValue.intValue();
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
}
