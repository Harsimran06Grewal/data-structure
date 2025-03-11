// Stock Span Problem
// Problem: For each day in a stock price array, calculate the span (number of consecutive days the price was less than or equal to the current day's price).
// Hint: Use a stack to keep track of indices of prices in descending order.

import java.util.Stack;

public class StockSpan {

    // Function to calculate the stock span
    public static int[] calculateSpan(int[] prices) {
        int[] span = new int[prices.length]; // Array to store the span of each day
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of days
        stack.push(0); // Push the index of the first day
        span[0] = 1; // The span of the first day is always 1

        // Loop through the prices starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // Pop from the stack while the price of the current day is greater than or equal to the price of the top day in the stack
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }

            // If the stack is empty, the span is i+1 (all previous days were smaller)
            // Otherwise, the span is the difference between the current day and the day at the top of the stack
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            // Push the current day to the stack
            stack.push(i);
        }
        return span; // Return the array containing the span of each day
    }

    public static void main(String[] args) {
        // Example prices
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Calculate the span for each day
        int[] span = calculateSpan(prices);

        // Print the span of each day
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
