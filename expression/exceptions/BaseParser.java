package expression.exceptions;

public class BaseParser {
    private static final char END = 0;

    private final CharSource source;
    private char ch;

    public BaseParser(CharSource source) {
        this.source = source;
        take();
    }

    protected boolean test(final char expected) {
        return ch == expected;
    }

    protected boolean test(final String expected) {
        for (int i = 0; i < expected.length(); i++) {
            if (ch != expected.charAt(i)) {
                return false;
            }
            take();
        }
        return true;
    }

    protected char take() {
        final char result = ch;
        ch = source.hasNext() ? source.next() : END;
        return result;
    }

    protected char raw() {
        return ch;
    }

    protected boolean take(final char expected) {
        if (test(expected)) {
            take();
            return true;
        }
        return false;
    }

    protected void expect(final char expected) {
        if (!take(expected)) {
            throw new UnexpectedSymbolException("Expected '" + expected + "', found '" + ch);
        }
    }

    protected void expectSpaceOrEnd() {
        if (!test(' ') && !test(END)) {
            throw new UnexpectedSymbolException("Expected space and number, found '" + ch);
        }
    }

    protected void expect(final String expected) {
        int pos = 0;
        for (final char c : expected.toCharArray()) {
            if(!take(c)) {
                throw new UnknownSequenceException("Expected '" + expected.substring(0, pos + 1) + "', found '" + expected.substring(0, pos) + ch);
            }
            pos++;
        }
    }

    protected boolean end() {
        return test(END);
    }

    protected boolean between(final char min, final char max) {
        return min <= ch && ch <= max;
    }

    protected boolean notWhitespace() {
        return !end() && !Character.isWhitespace(ch);
    }

    protected void skipWhitespace() {
        while (Character.isWhitespace(ch)) {
            take();
        }
    }

    protected int getPos() {
        return source.getPos();
    }
}