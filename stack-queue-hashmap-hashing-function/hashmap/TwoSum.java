// Two Sum Problem
// Problem: Given an array and a target sum, find two indices such that their values add up to the target.
// Hint: Use a hash map to store the index of each element as you iterate. Check if target - current_element exists in the map.

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        // Define an array of integers
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        int target = 7; // Target sum for the pair

        // Find indices of two numbers that add up to the target
        int[] result = twoSum(arr, target);

        // Print the indices of the found pair
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] arr, int target) {
        // HashMap to store the value and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the complement (target - arr[i]) exists in the map
            if (map.containsKey(target - arr[i])) {
                // Return the indices of the two numbers that add up to the target
                return new int[]{map.get(target - arr[i]), i};
            }
            // Store the current number with its index in the map
            map.put(arr[i], i);
        }

        // Return {-1, -1} if no valid pair is found
        return new int[]{-1, -1};
    }
}
