public class CountingSort {
    // Counting Sort Algorithm
    public static void sort(int[] ages) {
        int max = 18; // Maximum age
        int min = 10; // Minimum age
        int range = max - min + 1;

        int[] count = new int[range]; // Array to store frequency
        int[] output = new int[ages.length]; // Output array

        // Step 1: Count occurrences of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Step 2: Compute cumulative sum to get positions
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in their correct positions
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Method to display sorted ages
    public static void display(int[] ages) {
        System.out.print("Sorted Student Ages: ");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] studentAges = {15, 17, 12, 14, 16, 11, 18, 10}; // Sample student ages
        sort(studentAges); // Sorting using Counting Sort
        display(studentAges); // Displaying sorted ages
    }
}
