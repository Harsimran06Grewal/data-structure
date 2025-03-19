import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
        // Initialize a StringBuilder to store the result
        StringBuilder sb = new StringBuilder();
        // HashSet to keep track of seen characters
        HashSet<Character> seen = new HashSet<>();

        // Iterate through each character in the string
        for (char ch : input.toCharArray()) {
            // If character is not already present in HashSet, add it
            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }
        // Convert StringBuilder to string and return
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        // Taking user input
        String input = scanner.nextLine();

        // Storing the value
        String result = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + result);

    }
}
