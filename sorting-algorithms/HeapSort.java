public class HeapSort {
    // Heap Sort Algorithm
    public static void sort(int[] salaries) {
        int n = salaries.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify function to maintain heap property
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Assume root is the largest
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than current largest
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root, swap and recursively heapify
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            heapify(salaries, n, largest);
        }
    }

    // Method to display sorted salaries
    public static void display(int[] salaries) {
        System.out.print("Sorted Salaries: ");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] salaryDemands = {50000, 70000, 60000, 80000, 45000}; // Sample salary demands
        sort(salaryDemands); // Sorting using Heap Sort
        display(salaryDemands); // Displaying sorted salaries
    }
}
