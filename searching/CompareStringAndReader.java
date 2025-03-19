import java.io.*;
import java.util.StringTokenizer;

public class CompareStringAndReader {
    public static void main(String[] args) {
        // Comparing StringBuilder and StringBuffer
        compareStringConcatenation();

        // Comparing FileReader and InputStreamReader
        String filePath = "large_text_file.txt"; // Replace with an actual large file path
        countWordsUsingFileReader(filePath);
        countWordsUsingInputStreamReader(filePath);
    }

    // Method to compare StringBuilder and StringBuffer performance
    public static void compareStringConcatenation() {
        String word = "hello";
        int iterations = 1_000_000; // 1 million times

        // StringBuilder test
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(word);
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        System.out.println("StringBuilder Time: " + (stringBuilderTime / 1_000_000) + " ms");

        // StringBuffer test
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(word);
        }
        long stringBufferTime = System.nanoTime() - startTime;
        System.out.println("StringBuffer Time: " + (stringBufferTime / 1_000_000) + " ms");
    }

    // Method to read a file and count words using FileReader
    public static void countWordsUsingFileReader(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int wordCount = 0;

            long startTime = System.nanoTime();
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
            long endTime = System.nanoTime();

            bufferedReader.close();
            System.out.println("FileReader Word Count: " + wordCount);
            System.out.println("FileReader Time: " + ((endTime - startTime) / 1_000_000) + " ms");
        } catch (IOException e) {
            System.out.println("Error reading file using FileReader: " + e.getMessage());
        }
    }

    // Method to read a file and count words using InputStreamReader
    public static void countWordsUsingInputStreamReader(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            int wordCount = 0;

            long startTime = System.nanoTime();
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
            long endTime = System.nanoTime();

            bufferedReader.close();
            System.out.println("InputStreamReader Word Count: " + wordCount);
            System.out.println("InputStreamReader Time: " + ((endTime - startTime) / 1_000_000) + " ms");
        } catch (IOException e) {
            System.out.println("Error reading file using InputStreamReader: " + e.getMessage());
        }
    }
}
