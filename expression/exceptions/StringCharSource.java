package expression.exceptions;

public class StringCharSource implements CharSource {
    private final String source;
    private int pos = 0;

    public StringCharSource(String source) {
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        return pos < source.length();
    }

    @Override
    public char raw() {
        return source.charAt(pos);
    }

    @Override
    public char next() {
        return source.charAt(pos++);
    }

    @Override
    public IllegalArgumentException error(String message) {
        return new IllegalArgumentException(message + " at position " + pos);
    }

    @Override
    public int getPos() {
        return pos;
    }
}
