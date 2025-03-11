// Longest Consecutive Sequence
// Problem: Given an unsorted array, find the length of the longest consecutive elements sequence.
// Hint: Use a hash map to store elements and check for consecutive elements efficiently.

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public static void main(String[] args) {
        // Define an array of integers
        int[] arr = {100, 4, 200, 1, 3, 2};
        // Print the length of the longest consecutive sequence
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] arr) {
        // HashMap to store the length of consecutive sequences
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0; // Variable to track the maximum sequence length

        // Iterate through the array
        for (int num : arr) {
            // If the number is not already in the map
            if (!map.containsKey(num)) {
                // Get the length of consecutive sequences on the left and right
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int sum = left + right + 1; // Total length of the new sequence

                // Store the sequence length for the current number
                map.put(num, sum);
                // Update the maximum sequence length found so far
                result = Math.max(result, sum);

                // Update the boundary values of the sequence
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        return result; // Return the length of the longest consecutive sequence
    }
}
