// Linear nd Binary Search 

import java.util.Arrays;

public class LinearAndBinary {
    // Function to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1]; // Boolean array to track presence of numbers

        // Mark the numbers that are present in the array
        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        // Find the first number that is missing
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return n + 1; // If all numbers 1 to n are present, return n+1
    }

    // Function to perform binary search on a sorted array
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid; // Target found, return index
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, -1, 1 }; // Example array

        // Finding the first missing positive integer
        int missingNumber = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missingNumber);

        // Sorting the array for binary search
        Arrays.sort(nums);
        int target = 3; // Example target number
        int index = binarySearch(nums, target);

        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
