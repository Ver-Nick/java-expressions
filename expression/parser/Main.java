package expression.parser;

import expression.*;

public class Main {
    public static void main(String[] args){
        ExpressionParser parser = new ExpressionParser();
        TripleExpression expression = parser.parse("(y * (z * (-1 + y)))");
        System.out.println(expression.toMiniString());
    }
}
