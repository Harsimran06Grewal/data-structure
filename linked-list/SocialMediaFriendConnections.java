import java.util.ArrayList;

class User {
    // Attributes of user class
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds; // List of Friend IDs
    User next; // Pointer to next user in the linked list

    // Constructor to initialize user details
    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMediaNetwork {
    private User head = null; // Head of the user list

    // Method to add a new user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Method to find a user by User ID
    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to add a friend connection between two users
    public void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Method to remove a friend connection between two users
    public void removeFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Method to find and display mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual Friends of " + user1.name + " and " + user2.name + ":");
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                User mutualFriend = findUser(friendId);
                if (mutualFriend != null) {
                    System.out.println(mutualFriend.name);
                }
            }
        }
    }

    // Method to display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friendIds) {
            User friend = findUser(friendId);
            if (friend != null) {
                System.out.println(friend.name);
            }
        }
    }

    // Method to search for a user by Name or User ID
    public void searchUser(String nameOrId) {
        User temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(nameOrId) || Integer.toString(temp.userId).equals(nameOrId)) {
                System.out.println("User Found -> ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }

    // Method to count and display the number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    // Method to display all users
    public void displayAllUsers() {
        if (head == null) {
            System.out.println("No users in the network.");
            return;
        }

        User temp = head;
        System.out.println("All Users in the Network:");
        while (temp != null) {
            System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialMediaNetwork network = new SocialMediaNetwork();

        // Adding users
        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 28);
        network.addUser(3, "Charlie", 22);
        network.addUser(4, "David", 30);

        // Display all users
        network.displayAllUsers();

        // Adding friend connections
        network.addFriend(1, 2);
        network.addFriend(1, 3);
        network.addFriend(2, 3);
        network.addFriend(3, 4);

        // Display friends of a specific user
        network.displayFriends(1);

        // Find mutual friends
        network.findMutualFriends(1, 2);

        // Search for a user
        network.searchUser("Alice");

        // Count friends for each user
        network.countFriends();

        // Remove a friend connection
        network.removeFriend(1, 3);
        network.displayFriends(1);
    }
}
