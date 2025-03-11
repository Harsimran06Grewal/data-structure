// Check for a Pair with Given Sum in an Array
// Problem: Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
// Hint: Store visited numbers in a hash map and check if target - current_number exists in the map.
import java.util.HashMap;
import java.util.Map;

public class CheckForPair {
    public static void main(String[] args) {
        // Define an array of integers
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        // Define the target sum
        int target = 7;
        // Print whether a pair with the given sum exists
        System.out.println(hasPair(arr, target));
    }

    public static boolean hasPair(int[] arr, int target) {
        // Create a HashMap to store elements and their indices
        Map<Integer, Integer> map = new HashMap<>();
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the complement (target - current element) exists in the map
            if (map.containsKey(target - arr[i])) {
                return true; // If found, return true
            }
            // Store the current element in the map
            map.put(arr[i], i);
        }
        // Return false if no such pair is found
        return false;
    }
}


