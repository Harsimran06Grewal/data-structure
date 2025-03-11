// singly linked list
class Item {
    // Attributes of item class
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next; // Pointer to the next item in the list

    // Constructor to initialize an item
    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head; 

    // Method to add an item at the beginning of the list
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head; // New item points to current head
        head = newItem; // Update head to the new item
    }

    // Method to add an item at the end of the list
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) { // If the list is empty, set head to new item
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) { 
            temp = temp.next;
        }
        temp.next = newItem; // Add the new item at the end
    }

    // Method to add an item at a specific position
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 1) { // If adding at the beginning
            newItem.next = head;
            head = newItem;
            return;
        }
        Item temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) { 
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Method to remove an item by Item ID
    public void removeItem(int itemId) {
        if (head == null) return;

        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) { // If found, remove it by skipping the node
            temp.next = temp.next.next;
        }
    }

    // Method to update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) { // Find the item and update quantity
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Method to search for an item by Item ID
    public Item searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to search for an item by Item Name
    public Item searchByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                return temp; // Return the item if found
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Method to display all items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        System.out.println("Inventory Items:");
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
        }
    }

    // Helper method to merge two sorted lists
    private Item mergeSortedLists(Item left, Item right, boolean sortByName, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        Item result;
        if ((sortByName && (ascending ? left.itemName.compareTo(right.itemName) < 0 : left.itemName.compareTo(right.itemName) > 0)) ||
            (!sortByName && (ascending ? left.price < right.price : left.price > right.price))) {
            result = left;
            result.next = mergeSortedLists(left.next, right, sortByName, ascending);
        } else {
            result = right;
            result.next = mergeSortedLists(left, right.next, sortByName, ascending);
        }
        return result;
    }

    // Merge Sort function to sort inventory by Name or Price
    private Item mergeSort(Item head, boolean sortByName, boolean ascending) {
        if (head == null || head.next == null) return head;

        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) { // Find middle of the list
            slow = slow.next;
            fast = fast.next.next;
        }
        Item mid = slow.next;
        slow.next = null;

        Item left = mergeSort(head, sortByName, ascending);
        Item right = mergeSort(mid, sortByName, ascending);

        return mergeSortedLists(left, right, sortByName, ascending);
    }

    // Method to sort inventory by Name or Price
    public void sortInventory(boolean sortByName, boolean ascending) {
        head = mergeSort(head, sortByName, ascending);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding items to the inventory
        inventory.addItemAtEnd("Laptop", 101, 10, 750.50);
        inventory.addItemAtEnd("Mouse", 102, 50, 25.99);
        inventory.addItemAtBeginning("Keyboard", 103, 30, 45.75);
        inventory.addItemAtPosition("Monitor", 104, 15, 150.00, 2);

        // Display all items
        System.out.println("Inventory List:");
        inventory.displayInventory();

        // Searching for an item
        System.out.println("\nSearching for Item ID 102:");
        Item foundItem = inventory.searchById(102);
        if (foundItem != null) {
            System.out.println("Found -> Name: " + foundItem.itemName + ", Quantity: " + foundItem.quantity);
        }

        // Updating quantity
        System.out.println("\nUpdating Quantity of Item ID 101:");
        inventory.updateQuantity(101, 12);
        inventory.displayInventory();

        // Calculate total inventory value
        System.out.println("\nCalculating Total Inventory Value:");
        inventory.calculateTotalValue();

        // Sorting inventory by price in ascending order
        System.out.println("\nSorting Inventory by Price (Ascending):");
        inventory.sortInventory(false, true);
        inventory.displayInventory();

        // Removing an item
        System.out.println("\nRemoving Item with ID 102:");
        inventory.removeItem(102);
        inventory.displayInventory();
    }
}
