public class MergeSort {
    // Merge Sort Algorithm
    public static void sort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // Find the middle index

            // Recursively sort both halves
            sort(prices, left, mid);
            sort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Method to merge two sorted subarrays
    private static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1; 
        int n2 = right - mid;    

        int[] leftArr = new int[n1];  
        int[] rightArr = new int[n2]; 

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) leftArr[i] = prices[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = prices[mid + 1 + j];

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            prices[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }

        // Copy remaining elements
        while (i < n1) prices[k++] = leftArr[i++];
        while (j < n2) prices[k++] = rightArr[j++];
    }

    // Method to display sorted array
    public static void display(int[] prices) {
        System.out.print("Sorted Book Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] bookPrices = {250, 100, 450, 300, 150}; // Sample book prices
        sort(bookPrices, 0, bookPrices.length - 1); // Sorting using Merge Sort
        display(bookPrices); // Displaying sorted prices
    }
}
