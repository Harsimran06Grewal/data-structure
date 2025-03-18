public class SelectionSort {
    // Selection Sort Algorithm
    public static void sort(int[] scores) {
        int n = scores.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the minimum element is at index i

            // Find the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j; // Update the index of the minimum element
                }
            }

            // Swap the found minimum element with the first element of unsorted part
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Method to display sorted scores
    public static void display(int[] scores) {
        System.out.print("Sorted Exam Scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] examScores = {78, 45, 89, 56, 23, 67}; // Sample exam scores
        sort(examScores); // Sorting using Selection Sort
        display(examScores); // Displaying sorted scores
    }
}
