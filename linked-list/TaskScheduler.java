// circular linked list
class Task {
    // Attributes of Task class
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next; // Pointer to the next task in the circular linked list

    // Constructor to initialize a task
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskScheduler {
    private Task head = null; // Points to the first task
    private Task tail = null; // Points to the last task
    private Task currentTask = null; // the current task in the schedule

    // Method to add a task at the end of the circular linked list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) { // If the list is empty, initialize with the first task
            head = newTask;
            tail = newTask;
            newTask.next = head; // Circular linking
        } else {
            tail.next = newTask; // Link the current last node to the new node
            tail = newTask; // Update tail to the new node
            tail.next = head; // Maintain circular link
        }
    }

    // Method to add a task at the beginning of the circular linked list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) { // If the list is empty, initialize with the first task
            head = newTask;
            tail = newTask;
            newTask.next = head; // Circular linking
        } else {
            newTask.next = head; // New node points to the current head
            head = newTask; // Update head to the new node
            tail.next = head; // Maintain circular link
        }
    }

    // Method to remove a task by its Task ID
    public void removeTask(int taskId) {
        if (head == null) return; // List is empty

        if (head.taskId == taskId) { // If the task to be deleted is the head
            if (head == tail) { // If there's only one task
                head = null;
                tail = null;
            } else {
                head = head.next; // Move head to the next task
                tail.next = head; // Maintain circular link
            }
            return;
        }

        Task temp = head;
        do {
            if (temp.next.taskId == taskId) { 
                temp.next = temp.next.next; // Remove the task by skipping it
                if (tail.taskId == taskId) { // If the deleted task was the tail, update tail
                    tail = temp;
                }
                return;
            }
            temp = temp.next;
        } while (temp != head); 
    }

    // Method to view the current task and move to the next one
    public void viewCurrentTask() {
        if (currentTask == null) {
            currentTask = head; // Start from head if not set
        }
        if (currentTask != null) {
            System.out.println("Current Task -> ID: " + currentTask.taskId + ", Name: " + currentTask.taskName);
            currentTask = currentTask.next; // Move to the next task in a circular manner
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Method to display all tasks in the circular linked list
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head); // Continue until we loop back to the head
    }

    // Method to search for tasks by priority
    public void searchTaskByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task Found -> ID: " + temp.taskId + ", Name: " + temp.taskName);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        CircularTaskScheduler scheduler = new CircularTaskScheduler();

        // Adding tasks
        scheduler.addTaskAtEnd(1, "Task A", 1, "2025-03-15");
        scheduler.addTaskAtEnd(2, "Task B", 2, "2025-03-16");
        scheduler.addTaskAtBeginning(3, "Task C", 1, "2025-03-14");

        // Display all tasks
        System.out.println("All Tasks:");
        scheduler.displayTasks();

        // View current task and move to next
        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();

        // Search for tasks with priority 1
        System.out.println("\nSearching Tasks with Priority 1:");
        scheduler.searchTaskByPriority(1);

        // Remove task with ID 2 and display tasks again
        System.out.println("\nRemoving Task with ID 2:");
        scheduler.removeTask(2);
        scheduler.displayTasks();
    }
}
