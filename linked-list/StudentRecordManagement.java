class Student {
    int rollNumber;  
    String name;  
    int age;  
    char grade;  
    Student next;  // Pointer to the next student node

    // Constructor to initialize student details
    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;  // Next pointer is initially null
    }
}

class StudentLinkedList {
    private Student head;  // Head of the linked list

    // Method to add a student at the beginning of the list
    public void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;  // New student's next points to current head
        head = newStudent;  // Update head to new student
    }

    // Method to add a student at the end of the list
    public void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {  // If the list is empty, set new student as head
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {  // Traverse to the last node
            temp = temp.next;
        }
        temp.next = newStudent;  // Set last node's next to new student
    }

    // Method to add a student at a specific position
    public void addStudentAtPosition(int rollNumber, String name, int age, char grade, int position) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        
        // If inserting at the beginning, use the existing method
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }

        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) { // Traverse to the desired position
            temp = temp.next;
        }

        // If position is out of bounds
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newStudent.next = temp.next;  // Insert new student at the position
        temp.next = newStudent;
    }

    // Method to delete a student by roll number
    public void deleteStudent(int rollNumber) {
        if (head == null) return; // If the list is empty, return

        // If head node is to be deleted
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {  // Traverse to find the student
            temp = temp.next;
        }

        if (temp.next != null) {  // If found, remove the node
            temp.next = temp.next.next;
        }
    }

    // Method to search for a student by roll number
    public Student searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp; // If found, return the student
            }
            temp = temp.next;
        }
        return null; // Student not found
    }

    // Method to update the grade of a student
    public void updateGrade(int rollNumber, char newGrade) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.grade = newGrade;  // Update the grade
        }
    }

    // Method to display all students in the list
    public void displayStudents() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name +
                               ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;  // Move to the next student
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        // Adding students
        studentList.addStudentAtBeginning(1, "Alice", 20, 'A');
        studentList.addStudentAtEnd(2, "Bob", 22, 'B');
        studentList.addStudentAtPosition(3, "Charlie", 21, 'C', 2);

        // Display all students
        System.out.println("Student Records:");
        studentList.displayStudents();

        // Updating a student's grade
        System.out.println("\nUpdating Grade for Roll Number 2:");
        studentList.updateGrade(2, 'A');
        studentList.displayStudents();

        // Deleting a student
        System.out.println("\nDeleting Student with Roll Number 3:");
        studentList.deleteStudent(3);
        studentList.displayStudents();
    }
}
