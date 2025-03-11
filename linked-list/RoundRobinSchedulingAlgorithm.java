// Circular Linked List Process Scheduling
class Process {
    // Attributes of Process class
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next; // Pointer to the next process (circular linked list)

    // Constructor to initialize process details
    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // Initially, remaining time is equal to burst time
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum; 

    // Constructor to set time quantum
    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Method to add a process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) { // If the list is empty, initialize circular structure
            head = newProcess;
            tail = newProcess;
            tail.next = head; // Making it circular
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Circular linking
        }
    }

    // Method to remove a process by Process ID 
    public void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head;
        Process prev = null;

        // If only one process is in the list
        if (head == tail && head.processId == processId) {
            head = null;
            tail = null;
            System.out.println("Process " + processId + " completed and removed.");
            return;
        }

        // Search for the process to delete
        do {
            if (temp.processId == processId) {
                if (temp == head) {  // If head is to be deleted
                    head = head.next;
                    tail.next = head; // Maintain circular linking
                } else if (temp == tail) {  // If tail is to be deleted
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Process " + processId + " completed and removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Method to display processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        Process temp = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Method for round-robin scheduling
    public void executeProcesses() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        int time = 0; // Total time
        int totalWaitingTime = 0, totalTurnAroundTime = 0, numProcesses = 0;
        Process current = head;

        System.out.println("\nStarting Round Robin Execution...");
        while (head != null) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                time += executionTime;
                current.remainingTime -= executionTime;

                System.out.println("Executing Process " + current.processId + " for " + executionTime + " units.");

                if (current.remainingTime == 0) { // Process completed
                    int turnaroundTime = time;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalWaitingTime += waitingTime;
                    totalTurnAroundTime += turnaroundTime;
                    numProcesses++;

                    int processIdToRemove = current.processId;
                    current = current.next; // Move to the next process before removal
                    removeProcess(processIdToRemove);
                } else {
                    current = current.next; // Move to next process
                }
            }

            displayProcesses(); // Show queue after each execution round

            if (head == null) break; // Avoid infinite loop if list is empty
        }

        // Calculate and display average waiting time and turnaround time
        System.out.println("\nExecution completed.");
        if (numProcesses > 0) {
            System.out.println("Average Waiting Time: " + (double) totalWaitingTime / numProcesses);
            System.out.println("Average Turnaround Time: " + (double) totalTurnAroundTime / numProcesses);
        }
    }
}

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3); // Time Quantum = 3 units

        // Adding processes
        scheduler.addProcess(1, 7, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 2);

        // Display the process queue
        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        // Execute round-robin scheduling
        scheduler.executeProcesses();
    }
}
