import java.util.Scanner;

public class ConcatenateString {

    public static String concatenateStrings(String[] words) {
        // Create a StringBuffer object to store the concatenated result
        StringBuffer sb = new StringBuffer();

        // Append each string in the array to StringBuffer
        for (String word : words) {
            sb.append(word);
        }

        // Convert StringBuffer to a string and return
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the number of strings
        System.out.print("Enter number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left after nextInt()

        // Create an array to store input strings
        String[] words = new String[n];

        // Read each string input from the user
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        // Call the method to concatenate strings and print the result
        String result = concatenateStrings(words);
        System.out.println("Concatenated string: " + result);
    }
}
