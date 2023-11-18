package expression.exceptions;

import expression.*;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        TripleExpression expression = parser.parse("count5");
        System.out.println(expression.evaluate(1,2, 3));
    }
}
