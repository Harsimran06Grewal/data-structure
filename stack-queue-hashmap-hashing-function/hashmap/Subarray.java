// Find All Subarrays with Zero Sum
// Problem: Given an array, find all subarrays whose elements sum up to zero.
// Hint: Use a hash map to store the cumulative sum and its frequency. If a sum repeats, a zero-sum subarray exists.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subarray {
    public static void main(String[] args) {
        // Define an array of integers
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        // Print all subarrays with a sum of zero
        System.out.println(findSubarrays(arr));
    }

    public static List<List<Integer>> findSubarrays(int[] arr) {
        // List to store all subarrays with sum zero
        List<List<Integer>> result = new ArrayList<>();
        // HashMap to store the prefix sum and indices where it occurs
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(-1); // Initial entry to handle cases where subarray starts from index 0
        map.put(0, list);
        
        int sum = 0; // Variable to keep track of cumulative sum

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update the cumulative sum

            // If the sum has been seen before, it means a subarray with sum zero exists
            if (map.containsKey(sum)) {
                List<Integer> temp = map.get(sum);
                for (int value : temp) {
                    List<Integer> sub = new ArrayList<>();
                    // Extract the subarray
                    for (int j = value + 1; j <= i; j++) {
                        sub.add(arr[j]);
                    }
                    result.add(sub); // Add the subarray to the result list
                }
                temp.add(i); // Update the list of indices for the sum
                map.put(sum, temp);
            } else {
                // If sum is not found, create a new list with the current index
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(sum, temp);
            }
        }
        return result; // Return the list of all subarrays with sum zero
    }
}
