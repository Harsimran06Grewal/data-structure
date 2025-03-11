// Implement a Custom Hash Map
// Problem: Design and implement a basic hash map class with operations for insertion, deletion, and retrieval.
// Hint: Use an array of linked lists to handle collisions using separate chaining.
import java.util.LinkedList;

class MyHashMap {
    // Node class to store key-value pairs
    private static class Node {
        int key;
        int value;

        // Constructor to initialize a node with key and value
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array of linked lists to store the buckets
    private LinkedList<Node>[] buckets;
    private int capacity; // Capacity of the hash map
    private int size; // Number of elements in the hash map

    // Constructor to initialize the hash map with default capacity
    MyHashMap() {
        capacity = 16;
        size = 0;
        buckets = new LinkedList[capacity];
    }

    // Hash function to determine the index for a given key
    private int hash(int key) {
        return key % capacity;
    }

    // Method to insert or update a key-value pair in the hash map
    public void put(int key, int value) {
        int index = hash(key);
        // Create a new bucket if it doesn't exist
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        // Check if the key already exists, update its value if found
        for (Node node : buckets[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        // If key is not found, add a new node
        buckets[index].add(new Node(key, value));
        size++;
    }

    // Method to retrieve the value associated with a key
    public int get(int key) {
        int index = hash(key);
        // If the bucket is empty, return -1 (key not found)
        if (buckets[index] == null) {
            return -1;
        }
        // Search for the key in the bucket
        for (Node node : buckets[index]) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1; // Return -1 if the key is not found
    }

    // Method to remove a key-value pair from the hash map
    public void remove(int key) {
        int index = hash(key);
        // If the bucket is empty, return immediately
        if (buckets[index] == null) {
            return;
        }
        // Search for the key in the bucket and remove it
        for (Node node : buckets[index]) {
            if (node.key == key) {
                buckets[index].remove(node);
                size--;
                return;
            }
        }
    }

    // Method to get the current size of the hash map
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1); // Insert key 1 with value 1
        map.put(2, 2); // Insert key 2 with value 2
        System.out.println(map.get(1)); // Get value for key 1 (Expected: 1)
        System.out.println(map.get(3)); // Get value for key 3 (Expected: -1, key not present)
        map.put(2, 1); // Update key 2 with new value 1
        System.out.println(map.get(2)); // Get updated value for key 2 (Expected: 1)
        map.remove(2); // Remove key 2
        System.out.println(map.get(2)); // Try to get value for key 2 after removal (Expected: -1)
    }
}
