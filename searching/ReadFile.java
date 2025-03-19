import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        // Specify the file path (change this as needed)
        String filePath = "sample.txt";

        // Try-with-resources to automatically close resources
        try (FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            // Read the file line by line and print each line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            // Handle errors that occur during file reading
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
