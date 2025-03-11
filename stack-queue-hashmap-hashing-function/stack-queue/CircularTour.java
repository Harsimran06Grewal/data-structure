// Circular Tour Problem
// Problem: Given a set of petrol pumps with petrol and distance to the next pump, determine the starting point for completing a circular tour.
// Hint: Use a queue to simulate the tour, keeping track of surplus petrol at each pump.

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    // Function to find the starting petrol pump index using a two-pointer approach
    public static int tour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0, end = 1; // Start and end pointers
        int surplus = petrol[start] - distance[start]; // Track petrol surplus
        
        // Loop until a valid tour is found
        while (start != end || surplus < 0) {
            // Adjust start position if surplus is negative
            while (start != end && surplus < 0) {
                surplus -= petrol[start] - distance[start];
                start = (start + 1) % n;

                // If we complete a full cycle and start again, return -1 (not possible)
                if (start == 0) {
                    return -1;
                }
            }

            // Add petrol from the next station and move end pointer
            surplus += petrol[end] - distance[end];
            end = (end + 1) % n;
        }
        return start; // Return starting index of circular tour
    }

    // Function to find the starting petrol pump index using a queue-based approach
    public static int tourQueue(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        int start = 0, end = 0;
        int surplus = 0;

        // Loop until we complete checking all stations
        while (queue.size() < n) {
            // Adjust start position if surplus is negative
            while (surplus < 0 && !queue.isEmpty()) {
                surplus -= petrol[start] - distance[start];
                start = queue.poll();

                // If we reach the same point again, return -1 (not possible)
                if (start == end) {
                    return -1;
                }
            }

            // Add petrol from the next station and enqueue the index
            surplus += petrol[end] - distance[end];
            queue.offer(end);
            end = (end + 1) % n;
        }
        return start; // Return starting index of circular tour
    }

    public static void main(String[] args) {
        // Define petrol and distance arrays for different stations
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        // Call the two approaches and print results
        System.out.println(tour(petrol, distance)); 
        System.out.println(tourQueue(petrol, distance));
    }
}
