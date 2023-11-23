package expression.exceptions;

import expression.*;

public class ExpressionParser implements ParserInterface {
    public GlobalExpression parse(String expression) {
        return new Parser(new StringCharSource(expression)).parse(expression);
    }
}

class Parser extends BaseParser {

    public Parser(CharSource source) {
        super(source);
    }

    public GlobalExpression parse(String expression) {
        GlobalExpression res = parseSetClear();
        if (take(')')) {
            throw new NoBracketException("Unexpected ')' at position " + getPos());
        }
        if (!end()) {
            throw new UnexpectedSymbolException("Unexpected symbol '" + take() + "' at position " + getPos());
        }
        return res;
    }

    private GlobalExpression parseSetClear() {
        skipWhitespace();
        GlobalExpression first = parseAddSub();
        skipWhitespace();
        while (test('c') || test('s')) {
            if (test('c')) {
                String token = getSequence();
                if (!token.equals("clear")) {
                    throw new UnknownSequenceException(token + " at position " + getPos());
                }
                first = convertOperation(first, "clear", parseAddSub());
            } else if (test('s')) {
                String token = getSequence();
                if (!token.equals("set")) {
                    throw new UnknownSequenceException(token + " at position " + getPos());
                }
                first = convertOperation(first, "set", parseAddSub());
            }
            skipWhitespace();
        }
        return first;
    }

    private GlobalExpression parseAddSub() {
        skipWhitespace();
        GlobalExpression first = parseMuLDiv();
        skipWhitespace();
        while (test('+') || test('-')) {
            first = convertOperation(first, "" + take(), parseMuLDiv());
            skipWhitespace();
        }
        return first;
    }

    private GlobalExpression parseMuLDiv() {
        skipWhitespace();
        GlobalExpression first = parseValue();
        skipWhitespace();
        while (test('*') || test('/')) {
            first = convertOperation(first, "" + take(), parseValue());
            skipWhitespace();
        }
        return first;
    }

    private GlobalExpression parseValue() {
        skipWhitespace();
        if (take('(')) {
            if (take(')')) {
                throw new EmptyExpressionException("Empty expression at position " + getPos());
            }
            GlobalExpression res = parseSetClear();
            if (res == null) {
                throw new EmptyExpressionException("Empty expression at position " + getPos());
            }
            if (!take(')')) {
                throw new NoBracketException("Expected ')' at position " + getPos());
            }
            return res;
        }
        if (between('a', 'z') || between('A', 'Z')) {
            String sequence = getSequence();
            if (sequence.equals("count")) {
                return new Count(parseValue());
            }
            if (sequence.equals("log10")) {
                return new Log10(parseValue());
            }
            if (sequence.equals("pow10")) {
                return new Pow10(parseValue());
            }
            if (!sequence.equals("x") && !sequence.equals("y") && !sequence.equals("z")) {
                throw new UnknownSequenceException("Unknown sequence: " + sequence + " at position " + getPos());
            }
            return new Variable(sequence);
        } else if (take('-')) {
            if (between('0', '9')) {
                return new Const(getNumber(true));
            } else {
                return new CheckedNegate(parseValue());
            }
        } else if (between('0', '9')) {
            return new Const(getNumber(false));
        }
        throw new UnexpectedSymbolException("Unexpected symbol '" + take() + "' at position " + getPos());
    }

    private String getSequence() {
        skipWhitespace();
        StringBuilder sb = new StringBuilder();
        while (between('a', 'z') || between('A', 'Z') || between('0', '9')) {
            sb.append(take());
        }
        return sb.toString();
    }

    private int getNumber(boolean negative) {
        skipWhitespace();
        StringBuilder sb = new StringBuilder();
        if (negative) {
            sb.append('-');
        }
        while (between('0', '9')) {
            sb.append(take());
        }
        if (between('a', 'z') || between('A', 'Z')) {
            throw new UnknownSequenceException("Unknown sequence: " + getSequence() + " at position " + getPos());
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            throw new OverflowException("Overflow for number " + sb.toString() + " at position " + getPos());
        }
    }

    private GlobalExpression convertOperation(GlobalExpression first, String operation, GlobalExpression second) {
        return switch (operation) {
            case "+" -> new CheckedAdd(first, second);
            case "-" -> new CheckedSubtract(first, second);
            case "*" -> new CheckedMultiply(first, second);
            case "/" -> new CheckedDivide(first, second);
            case "set" -> new Set(first, second);
            case "clear" -> new Clear(first, second);
            default ->
                throw new UnexpectedSymbolException("Unexpected symbol: " + operation + " at position " + getPos());
        };
    }
}