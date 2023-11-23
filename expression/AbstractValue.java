package expression;

public abstract class AbstractValue extends AbstractExpression {
    protected String value;

    public AbstractValue(String s) {
        this.value = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractValue a) {
            return value == a.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public void toString(StringBuilder builder) {
        builder.append(value);
    }

    @Override
    public void toMiniString(StringBuilder builder) {
        builder.append(value);
    }
}
