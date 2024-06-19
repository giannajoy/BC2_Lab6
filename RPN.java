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
public class RPN {

    /**
     * A private instance of the StackCalculator class.
     * Used for storing and manipulating operands and results during evaluation.
     *
     */
    private StackCalculator stackCalculator;

    //The RPN expression string to be evaluated.
    private String expression;

    /**
     * Constructor for the RPN class.
     *
     * @param expression The RPN expression to be evaluated.
     *
     */
    public RPN(String expression) {
        //Initializes the stackCalculator with a new instance.
        this.stackCalculator = new StackCalculator();

        //Assigns the provided expression string to the internal
        // expression variable.
        this.expression = expression;
    }

    /**
     * This method evaluates the RPN expression stored in the 'expression' variable.
     *
     * @return The final result of evaluating the RPN expression.
     * @throws IllegalArgumentException if the expression is malformed.
     *
     */
    public double evaluate() {
        //Creates a Scanner object from the 'expression' string to
        // read tokens one by one.
        Scanner scanner = new Scanner(expression);

        //Iterates through the tokens in the expression using a while loop.
        while (scanner.hasNext()) {

            //Checks if the next token is a double using hasNextDouble()
            if (scanner.hasNextDouble()) {

                //If it's a double, push it onto the stackCalculator.
                stackCalculator.push(scanner.nextDouble());

            } else {

                //If it's not a double, assume it's an operator and call
                //performOperation with the token.
                performOperation(scanner.next());
            }
        }

        //Closes the Scanner object
        scanner.close();

        //Checks if the final stack size is 1 (expecting only the result).
        if (stackCalculator.isEmpty()) {

            //Throws an exception if there are no operands, indicating a
            //malformed expression.
            throw new IllegalArgumentException("not enough operands!");
        }

        //Pops the final result (the only remaining element) from the stack.
        double result = stackCalculator.pop();

        if (!stackCalculator.isEmpty()) {
            throw new IllegalArgumentException("not enough operators!");
        }

        //Returns the final calculated result.
        return result;
    }

    /**
     * This method performs the operation specified by the provided operator
     * string.
     *
     * @param operator The operator string (e.g., "+", "-", "*", "/").
     * @throws IllegalArgumentException if the operator is unknown or there
     *                                  are insufficient operands.
     */
    private void performOperation(String operator) {

        //Checks if the stack size is less than 2 (needing at least two
        // operands).
        if (stackCalculator.size() < 2) {

            //Throws an exception if there are not enough operands
            // for the operation.
            throw new IllegalArgumentException("too many operators!");
        }

        //Pops two operands from the stack in the correct order
        //(operand2 then operand1).
        double operand2 = stackCalculator.pop();
        double operand1 = stackCalculator.pop();

        //Initializes a variable to store the result of the operation.
        double result = 0;

        //Uses a switch statement to perform the appropriate arithmetic
        // operation based on the operator.
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }

        stackCalculator.push(result);
    }
}
