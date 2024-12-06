
### Example `Calculator.java`
```java
package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("Welcome to the Simple Calculator!");

        while (continueCalculating) {
            System.out.println("\nPlease enter the first number:");
            double num1 = getDoubleInput(input);

            System.out.println("Please enter an operator (+, -, *, /):");
            char operator = getOperator(input);

            System.out.println("Please enter the second number:");
            double num2 = getDoubleInput(input);

            double result = 0;
            boolean validOperation = true;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("Invalid operator.");
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }

            System.out.println("\nWould you like to perform another calculation? (y/n)");
            if (!input.nextLine().trim().equalsIgnoreCase("y")) {
                continueCalculating = false;
            }
        }

        System.out.println("Thank you for using the Simple Calculator. Goodbye!");
        input.close();
    }

    /**
     * Attempts to parse a double from user input.
     * Prompts again if input is invalid.
     */
    private static double getDoubleInput(Scanner input) {
        while (true) {
            String userInput = input.nextLine().trim();
            try {
                return Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again:");
            }
        }
    }

    /**
     * Ensures a valid operator character is entered.
     */
    private static char getOperator(Scanner input) {
        while (true) {
            String userInput = input.nextLine().trim();
            if (userInput.length() == 1 && "+-*/".indexOf(userInput.charAt(0)) != -1) {
                return userInput.charAt(0);
            }
            System.out.println("Invalid operator. Please enter one of (+, -, *, /):");
        }
    }
}
