// Implement a Queue Using Stacks
// Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
// Hint: Use one stack for enqueue and another stack for dequeue. Transfer elements between stacks as needed.

import java.util.Stack;

public class QueueUsingStack {
    // Two stacks to implement a queue
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation: Push element onto stack1
    public void enqueue(int data) {
        stack1.push(data);
    }

    // Dequeue operation: Pop element from stack2, if empty, transfer elements from stack1
    public int dequeue() {
        // If stack2 is empty, transfer elements from stack1 to stack2
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1; // Queue is empty
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop(); // Return the front element
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        
        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        // Dequeue and print elements
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
        
        queue.enqueue(4);
        
        System.out.println(queue.dequeue()); // Output: 3
        System.out.println(queue.dequeue()); // Output: 4
        
        // Attempt to dequeue from an empty queue
        System.out.println(queue.dequeue()); // Output: -1 (Queue is empty)
    }
}
