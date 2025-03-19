import java.io.*;

public class CountOccurance {
    public static int countWordOccurrences(String filename, String targetWord) {
        int count = 0;
        try {
            // Create FileReader and wrap it with BufferedReader
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Remove punctuation and compare with the target word
                    if (word.replaceAll("[^a-zA-Z]", "").equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            // Close resources
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String filename = "sample.txt"; // Change this to your file path
        String targetWord = "hello"; // Change this to the word you want to count

        int occurrences = countWordOccurrences(filename, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
    }
}
