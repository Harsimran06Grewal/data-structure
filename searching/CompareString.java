public class CompareString {
    public static void main(String[] args) {
        int iterations = 1_000_000; // Number of times to append the string
        String text = "hello"; // Sample string to append

        // Measure time taken by StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime(); // Start time before appending
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text); // Append "hello" to StringBuffer
        }
        long endTimeBuffer = System.nanoTime(); // End time after appending
        long bufferTime = endTimeBuffer - startTimeBuffer; // Calculate execution time

        // Measure time taken by StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime(); // Start time before appending
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text); // Append "hello" to StringBuilder
        }
        long endTimeBuilder = System.nanoTime(); // End time after appending
        long builderTime = endTimeBuilder - startTimeBuilder; // Calculate execution time

        // Print results for both cases
        System.out.println("Time taken by StringBuffer: " + bufferTime / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + builderTime / 1_000_000 + " ms");

        // Compare performance and print the faster approach
        if (bufferTime > builderTime) {
            System.out.println("StringBuilder is faster!");
        } else {
            System.out.println("StringBuffer is faster!");
        }
    }
}
