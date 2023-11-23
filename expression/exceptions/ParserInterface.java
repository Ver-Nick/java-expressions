package expression.exceptions;

import expression.GlobalExpression;

public interface ParserInterface {
    GlobalExpression parse(String expression);
}