import java.io.*;

public class ConvertByteStream {
    public static void main(String[] args) {
        String filename = "example.txt"; // File to be read

        try {
            // Step 1: Create a FileInputStream to read raw binary data from the file
            FileInputStream fileInputStream = new FileInputStream(filename);

            // Step 2: Wrap FileInputStream with InputStreamReader to convert bytes into
            // characters
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            // Step 3: Use BufferedReader for efficient reading of character stream
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Step 4: Read and print file content line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) { // Read until end of file
                System.out.println(line); // Print each line of the file
            }

            // Step 5: Close resources to free system resources and prevent memory leaks
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        }
        // Handle case where file is not found
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
        // Handle general I/O exceptions (e.g., read errors)
        catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
