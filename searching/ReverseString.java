import java.util.Scanner;

public class ReverseString {
    public static String reverseString(String input) {
        // Create a StringBuilder object and append the input string
        StringBuilder sb = new StringBuilder(input);
        // Reverse the string using the reverse() method
        sb.reverse();
        // Convert the StringBuilder back to a string and return it
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        // Taking user input
        String input = scanner.nextLine();

        // Reversing the String
        String reversed = reverseString(input);
        System.out.println("Reversed string: " + reversed);
    }
}
