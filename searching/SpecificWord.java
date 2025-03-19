import java.util.Scanner;

public class SpecificWord {
    // Method to find the first sentence containing the word
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence; // Return the first matching sentence
            }
        }
        return "Not Found"; // Return if the word is not found in any sentence
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of sentences
        System.out.print("Enter the number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Input sentences
        String[] sentences = new String[n];
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        // Input search word
        System.out.print("Enter the word to search for: ");
        String word = scanner.nextLine();

        // Search for the word in the sentences
        String result = findSentenceWithWord(sentences, word);

        // Display the result
        System.out.println("Result: " + result);

    }
}
