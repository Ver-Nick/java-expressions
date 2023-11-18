package expression;

import java.util.Scanner;

import expression.exceptions.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        while (true) {
            try {
                System.out.print("Write expression: ");
                Scanner scanner = new Scanner(System.in);
                String expression = scanner.next();
                System.out.println();

                System.out.println("Write variables");
                System.out.print("X: ");
                int X = scanner.nextInt();
                System.out.println();
                System.out.print("Y: ");
                int Y = scanner.nextInt();
                System.out.println();
                System.out.print("Z: ");
                int Z = scanner.nextInt();
                System.out.println();
                TripleExpression result = parser.parse(expression);
                System.out.println("Result: " + result.evaluate(X, Y, Z));
            } catch (Exception e) {
                System.out.println("Failed to get input: " + e.getMessage());
            }
        }
    }
}