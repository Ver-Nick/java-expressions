package expression;

import java.util.Scanner;

import expression.exceptions.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        System.out.println("JC 1.0.1");
        System.out.println("usage: calculate/simplify *expression*");

        ExpressionParser parser = new ExpressionParser();

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
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String command = scanner.next();
                String expression;
                if (command.equals("calculate")) {
                    expression = scanner.nextLine();

                    System.out.print("x=");
                    double X = Double.parseDouble(scanner.nextLine());
                    // System.out.println();
                    System.out.print("y=");
                    double Y = Double.parseDouble(scanner.nextLine());
                    // System.out.println();
                    System.out.print("z=");
                    double Z = Double.parseDouble(scanner.nextLine());
                    // System.out.println();
                    GlobalExpression result = parser.parse(expression);
                    System.out.println(result.evaluate(X, Y, Z));
                } else if (command.equals("simplify")) {
                    expression = scanner.nextLine();

                    GlobalExpression result = parser.parse(expression);
                    StringBuilder sb = new StringBuilder();
                    result.toMiniString(sb);
                    System.out.println(sb.toString());
                } else {
                    System.out.println(command + " is not a command, try again.");
                    scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Failed to get input: " + e.getMessage());
            }
        }
    }
}