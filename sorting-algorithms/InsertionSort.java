public class InsertionSort {
    // Insertion Sort Algorithm
    public static void sort(int[] employeeIds) {
        for (int i = 1; i < employeeIds.length; i++) {
            int key = employeeIds[i]; // Select the element to be inserted
            int j = i - 1;

            // Shift elements that are greater than key to one position ahead
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }
            employeeIds[j + 1] = key; // Insert key at the correct position
        }
    }

    // Method to display the sorted array
    public static void display(int[] employeeIds) {
        System.out.print("Sorted Employee IDs: ");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] employeeIds = {102, 97, 120, 85, 109}; // Sample Employee IDs
        sort(employeeIds); // Sorting using Insertion Sort
        display(employeeIds); // Displaying sorted Employee IDs
    }
}
