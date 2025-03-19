
// Binary Search
import java.util.Scanner;

public class FindPeakElement {
    // Method to find a peak element using Binary Search
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the next, peak lies in the left half
            if (arr[mid] > arr[mid + 1]) {
                right = mid; // Move left, keeping mid as a potential peak
            } else {
                left = mid + 1; // Move right, as peak must be in the right half
            }
        }
        return left; // 'left' will hold the index of a peak element
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find peak element
        int peakIndex = findPeakElement(arr);

        // Display the result
        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element: " + arr[peakIndex]);

    }
}
