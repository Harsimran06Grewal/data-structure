// Sort a Stack Using Recursion
// Problem: Given a stack, sort its elements in ascending order using recursion.
// Hint: Pop elements recursively, sort the remaining stack, and insert the popped element back at the correct position.

import java.util.Stack;

public class StackSorting {

    // Function to sort the stack
    public static void sort(Stack<Integer> stack) {
        // Base case: If the stack is not empty, pop an element and recursively sort the rest of the stack
        if (!stack.isEmpty()) {
            int temp = stack.pop(); // Pop the top element
            sort(stack); // Recursively sort the remaining stack
            insert(stack, temp); // Insert the popped element back into the sorted stack
        }
    }

    // Function to insert an element in the sorted stack
    private static void insert(Stack<Integer> stack, int temp) {
        // If the stack is empty or the top element is smaller than the current element, push the element
        if (stack.isEmpty() || stack.peek() < temp) {
            stack.push(temp);
        } else {
            // Pop the top element, recursively insert the current element, then push the popped element back
            int top = stack.pop();
            insert(stack, temp);
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        // Create and initialize the stack with values
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);

        // Sort the stack
        sort(stack);

        // Print the sorted stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // Pop and print each element in the sorted stack
        }
    }
}
