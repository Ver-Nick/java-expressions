package expression.parser;

import expression.GlobalExpression;

public interface ParserInterface {
    GlobalExpression parse(String expression);
}