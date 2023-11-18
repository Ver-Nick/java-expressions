package expression.parser;

import expression.*;

public class ExpressionParser implements TripleParser {
    @Override
    public TripleExpression parse(String expression) {
        return new Parser(new StringCharSource(expression)).parse(expression);
    }
}
class Parser extends BaseParser {
    public Parser(CharSource source) {
        super(source);
    }

    public TripleExpression parse(String expression) {
        return parseSetClear();
    }

    private GlobalExpression parseSetClear() {
        GlobalExpression first = parseAddSub();
        while (true) {
            skipWhitespace();
            if (take('c')) {
                expect("lear");
                first = convertOperation(first, "clear", parseAddSub());
            } else if (take('s')) {
                expect("et");
                first = convertOperation(first, "set", parseAddSub());
            } else {
                return first;
            }
        }
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
            GlobalExpression res = parseSetClear();
            expect(')');
            return res;
        }
        if (between('a', 'z') || between('A', 'Z')) {
            String sequence = getIdentifier();
            if (sequence.equals("count")) {
                return new Count(parseValue());
            }
            if (!sequence.equals("x") && !sequence.equals("y") && !sequence.equals("z")) {
                throw error("Unknown variable");
            }
            return new Variable(sequence);
        } else if (take('-')) {
            if (between('0', '9')) {
                return new Const(getNumber(true));
            } else {
                return new Negative(parseValue());
            }
        } else if (between('0', '9')) {
            return new Const(getNumber(false));
        }
        throw error("Unknown operation");
    }

    private String getIdentifier() {
        skipWhitespace();
        StringBuilder sb = new StringBuilder();
        while(between('a', 'z') || between('A', 'Z') || between('0', '9')){
            sb.append(take());
        }
        return sb.toString();
    }

    private int getNumber(boolean negative) {
        skipWhitespace();
        StringBuilder sb = new StringBuilder();
        if(negative){
            sb.append('-');
        }
        while(between('0', '9')){
            sb.append(take());
        }
        return Integer.parseInt(sb.toString());
    }

    private GlobalExpression convertOperation(GlobalExpression first, String operation, GlobalExpression second){
        return switch(operation){
            case "+" -> new Add(first, second);
            case "-" -> new Subtract(first, second);
            case "*" -> new Multiply(first, second);
            case "/" -> new Divide(first, second);
            case "set" -> new Set(first, second);
            case "clear" -> new Clear(first, second);
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }

    public static void main(final String... args) {
        System.out.println(new ExpressionParser().parse("x sety"));
    }
}
