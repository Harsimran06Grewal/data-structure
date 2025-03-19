import java.util.Scanner;

public class FirstAndLastOccurence {
    // Method to find the first occurrence of the target element
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                first = mid; // Record the index
                right = mid - 1; // Search in the left half
            } else if (arr[mid] < target) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }
        return first;
    }

    // Method to find the last occurrence of the target element
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                last = mid; // Record the index
                left = mid + 1; // Search in the right half
            } else if (arr[mid] < target) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }
        return last;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input sorted array
        System.out.println("Enter the sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input target value
        System.out.print("Enter target value to search: ");
        int target = scanner.nextInt();

        // Find first and last occurrence of target
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        // Display result
        if (first == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First occurrence index: " + first);
            System.out.println("Last occurrence index: " + last);
        }

    }
}
