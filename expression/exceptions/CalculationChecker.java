package expression.exceptions;

public class CalculationChecker {
    public static void checkAdd(int a, int b) {
        if (b > 0 && a > Integer.MAX_VALUE - b) {
            throw new OverflowException("Overflow in addition: " + a + " + " + b);
        }
        if (b < 0 && a < Integer.MIN_VALUE - b) {
            throw new OverflowException("Overflow in addition: " + a + " + " + b);
        }
    }
    
    public static void checkSubtract(int a, int b) {
        if (b < 0 && a > Integer.MAX_VALUE + b) {
            throw new OverflowException("Overflow in subtraction: " + a + " - " + b);
        }
        if (b > 0 && a < Integer.MIN_VALUE + b) {
            throw new OverflowException("Overflow in subtraction: " + a + " - " + b);
        }
    }

    public static void checkMultiply(int a, int b) {
        if (a == 0 || b == 0) {
            return;
        }
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE / b) {
            throw new OverflowException("Overflow in multiplication: " + a + " * " + b);
        }
        if (a > 0 && b < 0 && b < Integer.MIN_VALUE / a) {
            throw new OverflowException("Overflow in multiplication: " + a + " * " + b);
        }
        if (a < 0 && b > 0 && a < Integer.MIN_VALUE / b) {
            throw new OverflowException("Overflow in multiplication: " + a + " * " + b);
        }
        if (a < 0 && b < 0 && a < Integer.MAX_VALUE / b) {
            throw new OverflowException("Overflow in multiplication: " + a + " * " + b);
        }
    }

    public static void checkDivide(int a, int b) {
        if (b == 0) {
            throw new DivisionByZeroException("Division by zero: " + a + " / " + b);
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new OverflowException("Overflow in division: " + a + " / " + b);
        }
    }

    public static void checkNegate(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException("Overflow in negation: -" + a);
        }
    }

    public static void checkPow10(int a) {
        if (a < 0 || a > 9) {
            throw new OverflowException("Overflow in pow10: 10^" + a);
        }
    }

    public static void checkLog10(int a) {
        if (a <= 0) {
            throw new NegativeArgumentException("Logarithm argument must be positive: log10(" + a + ")");
        }
    }
}
