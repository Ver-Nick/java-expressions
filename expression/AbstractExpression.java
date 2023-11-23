package expression;

public abstract class AbstractExpression implements GlobalExpression {
    private final StringBuilder builder = new StringBuilder();
    private final StringBuilder miniBuilder = new StringBuilder();

    @Override
    public String toString() {
        if (builder.isEmpty()) {
            toString(builder);
        }
        return builder.toString();
    }

    public String toMiniString() {
        if (miniBuilder.isEmpty()) {
            toMiniString(miniBuilder);
        }
        return miniBuilder.toString();
    }
}
