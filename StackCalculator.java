package gee_lab6;
/*
 * GEE
 * This is free and unencumbered software released into the public domain.
 */
import java.util.EmptyStackException;
import java.util.Stack;
/**
 * This class implements a stack-based calculator using a Stack of doubles.
 * It provides methods to push, pop, peek, check emptiness, and get the size
 * of the stack.
 */
public class StackCalculator {

     //A private Stack object to store the double values for calculations.
    private Stack<Double> stack;

    /**
     * Constructor for the StackCalculator class.
     * Initializes a new Stack object to store double values.
     *
     */
    public StackCalculator() {
        this.stack = new Stack<>();
    }

    /**
     * Pushes a double value onto the top of the stack.
     *
     * @param value The double value to be pushed onto the stack.
     *
     */
    public void push(double value) {
        stack.push(value);  // Adds the value to the top of the stack.
    }

    /**
     * Removes and returns the double value at the top of the stack.
     *
     * @return The double value at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     *
     */
    public double pop() {

        // Checks for an empty stack.
        if (isEmpty()) {

            // Throws an exception if the stack is empty.
            throw new EmptyStackException();
        }

        // Removes and returns the top value from the stack.
        return stack.pop();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     *
     */
    public boolean isEmpty() {

        // Returns the stack's emptiness status.
        return stack.isEmpty();
    }

    /**
     * Returns the double value at the top of the stack without removing it.
     *
     * @return The double value at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public double peek() {

        // Checks for an empty stack.
        if (isEmpty()) {

            // Throws an exception if the stack is empty.
            throw new EmptyStackException();
        }

        // Returns the top value without removing it from the stack.
        return stack.peek();
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return The size of the stack (number of elements).
     */
    public int size() {
        return stack.size();  // Returns the number of elements in the stack.
    }
}
