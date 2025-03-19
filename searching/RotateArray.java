// Binary Search

import java.util.Scanner;

public class RotateArray {
    // Method to find the rotation point (index of the smallest element)
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost, search in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Otherwise, search in the left half
                right = mid;
            }
        }
        return left; // 'left' holds the index of the smallest element
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input elements
        System.out.println("Enter the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find rotation point
        int rotationIndex = findRotationPoint(arr);

        // Display the result
        System.out.println("Rotation Point Index: " + rotationIndex);
        System.out.println("Smallest Element: " + arr[rotationIndex]);

    }
}
