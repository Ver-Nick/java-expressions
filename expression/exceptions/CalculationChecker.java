package expression.exceptions;

public class CalculationChecker {
    public static void checkAdd(double a, double b) {
        if (b > 0 && a > Double.MAX_VALUE - b) {
            throw new OverflowException("Overflow in addition: " + a + " + " + b);
        }
        if (b < 0 && a < Double.MIN_VALUE - b) {
            throw new OverflowException("Overflow in addition: " + a + " + " + b);
        }
    }

    public static void checkSubtract(double a, double b) {
        if (b < 0 && a > Double.MAX_VALUE + b) {
            throw new OverflowException("Overflow in subtraction: " + a + " - " + b);
        }
        if (b > 0 && a < Double.MIN_VALUE + b) {
            throw new OverflowException("Overflow in subtraction: " + a + " - " + b);
        }
    }

    public static void checkMultiply(double a, double b) {
        if (a == 0 || b == 0) {
            return;
        }
        if (a > 0 && b > 0 && a > Double.MAX_VALUE / b) {
            throw new OverflowException("Overflow in multiplication: " + a + " * " + b);
        }
        if (a > 0 && b < 0 && b < Double.MIN_VALUE / a) {
            throw new OverflowException("Overflow in multiplication: " + a + " * " + b);
        }
        if (a < 0 && b > 0 && a < Double.MIN_VALUE / b) {
            throw new OverflowException("Overflow in multiplication: " + a + " * " + b);
        }
        if (a < 0 && b < 0 && a < Double.MAX_VALUE / b) {
            throw new OverflowException("Overflow in multiplication: " + a + " * " + b);
        }
    }

    public static void checkDivide(double a, double b) {
        if (b == 0) {
            throw new DivisionByZeroException("Division by zero: " + a + " / " + b);
        }
        if (a == Double.MIN_VALUE && b == -1) {
            throw new OverflowException("Overflow in division: " + a + " / " + b);
        }
    }

    public static void checkNegate(double a) {
        if (a == Double.MIN_VALUE) {
            throw new OverflowException("Overflow in negation: -" + a);
        }
    }

    public static void checkPow10(double a) {
        if (a < 0 || a > 9) {
            throw new OverflowException("Overflow in pow10: 10^" + a);
        }
    }

    public static void checkLog10(double a) {
        if (a <= 0) {
            throw new NegativeArgumentException("Logarithm argument must be positive: log10(" + a + ")");
        }
    }
}
