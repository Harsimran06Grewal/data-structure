//  circular linked list
class Ticket {
    // Attributes of Ticket class
    int ticketId; 
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next; // Points to the next ticket (Circular Linked List)

    // Constructor to initialize ticket details
    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;
    private int totalTickets = 0; // Count of total booked tickets

    // Method to add a new ticket reservation at the end of the list
    public void bookTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) { // If the list is empty
            head = newTicket;
            tail = newTicket;
            tail.next = head; // Making it circular
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular nature
        }
        totalTickets++;
        System.out.println("Ticket booked successfully for " + customerName);
    }

    // Method to remove a ticket by Ticket ID
    public void cancelTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;

        do {
            if (current.ticketId == ticketId) {
                if (current == head) { // Removing first node
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) { // Removing last node
                    tail = previous;
                    tail.next = head;
                } else { // Removing a middle node
                    previous.next = current.next;
                }
                totalTickets--;
                System.out.println("Ticket with ID " + ticketId + " has been canceled.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    // Method to display all booked tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        System.out.println("List of Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                               ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                               ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Method to search for a ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket Found -> Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                                   ", Movie: " + current.movieName + ", Seat: " + current.seatNumber);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No ticket found for '" + keyword + "'.");
        }
    }

    // Method to calculate and display total number of booked tickets
    public void totalBookedTickets() {
        System.out.println("Total Booked Tickets: " + totalTickets);
    }
}

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        TicketReservationSystem reservationSystem = new TicketReservationSystem();

        // Booking tickets
        reservationSystem.bookTicket(101, "Alice", "Avatar 2", "A1", "2025-03-12 18:00");
        reservationSystem.bookTicket(102, "Bob", "Batman", "B2", "2025-03-12 19:30");
        reservationSystem.bookTicket(103, "Charlie", "Inception", "C3", "2025-03-13 20:00");

        // Display all tickets
        reservationSystem.displayTickets();

        // Searching for a ticket
        System.out.println("\nSearching for tickets booked by Alice:");
        reservationSystem.searchTicket("Alice");

        // Removing a ticket
        System.out.println("\nCancelling Ticket ID 102:");
        reservationSystem.cancelTicket(102);
        reservationSystem.displayTickets();

        // Display total number of booked tickets
        reservationSystem.totalBookedTickets();
    }
}
