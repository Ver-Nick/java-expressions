package expression;

public class Variable extends AbstractValue {
    public Variable(String s) {
        super(s);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Variable a) {
            return value.equals(a.value);
        }
        return false;
    }

    @Override
    public double evaluate(double x) {
        return x;
    }

    @Override
    public double evaluate(double x, double y, double z) {
        if (value.equals("x")) {
            return x;
        }
        if (value.equals("y")) {
            return y;
        }
        if (value.equals("z")) {
            return z;
        }
        return 0;
    }
}
