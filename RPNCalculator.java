package gee_lab6;
/*
 * GEE
 * This is free and unencumbered software released into the public domain.
 */
import java.util.Scanner;

/**
 * This class represents an RPN (Reverse Polish Notation) calculator.
 * It allows users to enter RPN expressions and evaluates them.
 *
 */
public class RPNCalculator {

    /**
     * The main method is the entry point of the program.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // Creates a new Scanner object to read user input from the console
        Scanner inputScanner = new Scanner(System.in);

        // Prints a welcome message to the console
        System.out.println("RPN Calculator\n");

        // Explains how to exit the program
        System.out.println("(Enter a blank line to quit)");

        // Flag to control the program loop
        boolean isRunning = true;

        // Loop continues until the user enters a blank line
        while (isRunning) {
            // Prompts the user for an expression
            System.out.print("calc> ");

            // Reads the user's input, trims any leading/trailing whitespace,
            // and stores it
            String input = inputScanner.nextLine().trim();

            // Checks if the user entered a blank line to quit
            if (input.isEmpty()) {

                isRunning = false;  // Set flag to false, to exit the loop
            } else {
                // Creates an RPN object to handle the expression
                RPN rpn = new RPN(input);

                // Evaluates the expression and stores the result
                double result = rpn.evaluate();

                // Prints the evaluation result
                System.out.println(result);
            }
        }

        // Prints a goodbye message
        System.out.println("\nBye!");

        // Closes the Scanner object
        inputScanner.close();
    }
}

