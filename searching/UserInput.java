import java.io.*;

public class UserInput {
    public static void main(String[] args) {
        String filename = "user_input.txt"; // File where user input will be saved

        try {
            // Step 1: Create InputStreamReader to read user input from the console
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);

            // Step 2: Wrap InputStreamReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Step 3: Create FileWriter to write user input to a file
            FileWriter fileWriter = new FileWriter(filename);

            System.out.println("Enter text to write to file (type 'exit' to stop):");

            String userInput;
            while (true) {
                // Step 4: Read user input line by line
                userInput = bufferedReader.readLine();

                // Step 5: Check if user wants to exit
                if (userInput.equalsIgnoreCase("exit")) {
                    break; // Stop reading input if "exit" is entered
                }

                // Step 6: Write the input to the file and add a newline
                fileWriter.write(userInput + "\n");
            }

            // Step 7: Close resources
            bufferedReader.close();
            fileWriter.close();
            System.out.println("User input has been saved to " + filename);
        }
        // Handle IOException (e.g., file writing errors)
        catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
