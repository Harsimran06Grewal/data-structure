public class QuickSort {
    // Quick Sort Algorithm
    public static void sort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high); // Find pivot position
            sort(prices, low, pivotIndex - 1);  // Sort left partition
            sort(prices, pivotIndex + 1, high); // Sort right partition
        }
    }

    // Partition function to place pivot at the correct position
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap elements
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        // Swap pivot to correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }

    // Method to display sorted prices
    public static void display(int[] prices) {
        System.out.print("Sorted Product Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] productPrices = {500, 120, 700, 300, 200}; // Sample product prices
        sort(productPrices, 0, productPrices.length - 1); // Sorting using Quick Sort
        display(productPrices); // Displaying sorted prices
    }
}
