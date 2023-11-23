package expression;

import java.util.Scanner;

import expression.exceptions.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        GlobalExpression expression = parser.parse("count5");
        System.out.println(expression.evaluate(1, 2, 3));

        /*
         * simplify (y * (z * (-1 + y)))
         * y * z * (-1 + y)
         * calculate x*x+y*y+z*z
         * x=1
         * y=2
         * z=3
         * 14
         *
         */
        // while (true) {
        // try {
        // System.out.print("Write expression: ");
        // Scanner scanner = new Scanner(System.in);
        // String expression = scanner.next();
        // System.out.println();

        // System.out.println("Write variables");
        // System.out.print("X: ");
        // int X = scanner.nextInt();
        // System.out.println();
        // System.out.print("Y: ");
        // int Y = scanner.nextInt();
        // System.out.println();
        // System.out.print("Z: ");
        // int Z = scanner.nextInt();
        // System.out.println();
        // GlobalExpression result = parser.parse(expression);
        // System.out.println("Result: " + result.evaluate(X, Y, Z));
        // } catch (Exception e) {
        // System.out.println("Failed to get input: " + e.getMessage());
        // }
        // }
    }
}