package expression.parser;

import expression.*;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        GlobalExpression expression = parser.parse("(y * (z * (-1 + y)))");
        StringBuilder builder = new StringBuilder();
        expression.toMiniString(builder);
        System.out.println(builder.toString());
    }
}
