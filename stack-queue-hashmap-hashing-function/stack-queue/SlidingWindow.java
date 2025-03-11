// Sliding Window Maximum
// Problem: Given an array and a window size k, find the maximum element in each sliding window of size k.
// Hint: Use a deque (double-ended queue) to maintain indices of useful elements in each window.

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {

    // Function to find the maximum of each sliding window of size k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // If nums is null or k is non-positive, return an empty array
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store the result
        Deque<Integer> deque = new ArrayDeque<>(); // Deque to store indices of the elements
        int ri = 0; // Result index to store the current max value

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove indices of elements smaller than the current element
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current index to the deque
            deque.offer(i);

            // If we have processed at least k elements, record the max of the window
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()]; // The first element in the deque is the largest
            }
        }

        return result; // Return the result array with the maximums of the sliding windows
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7}; // Input array
        int k = 3; // Size of the sliding window
        int[] result = maxSlidingWindow(nums, k); // Call the function to get the result

        // Print the result
        for (int r : result) {
            System.out.print(r + " "); // Print each max of the sliding window
        }
    }
}
