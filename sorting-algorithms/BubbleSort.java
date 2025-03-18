public class BubbleSort {
    // Bubble Sort Algorithm
    public static void sort(int[] marks) {
        int n = marks.length;
        
        // Traverse through all elements in the array
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the current element is greater than the next element
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
    }

    // Method to display the sorted array
    public static void display(int[] marks) {
        System.out.print("Sorted Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    // Main method to execute sorting
    public static void main(String[] args) {
        int[] marks = {45, 78, 23, 56, 89, 12}; // Sample marks
        sort(marks);  // Sorting using Bubble Sort
        display(marks); // Displaying sorted marks
    }
}
