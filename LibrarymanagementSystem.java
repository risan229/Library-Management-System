// Abstract Class (Abstraction)
abstract class User {
    private String name; // Encapsulation: private fields with public getters/setters
    private int userID;

    public User(String name, int userID) {
        this.name = name;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    // Abstract method to be implemented by subclasses
    public abstract int getBorrowLimit();

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("User ID: " + userID);
    }
}

// Subclass: Student (Inheritance from User)
class Student extends User {
    private static final int BORROW_LIMIT = 3;

    public Student(String name, int userID) {
        super(name, userID);
    }

    @Override
    public int getBorrowLimit() { // Polymorphism: overriding method
        return BORROW_LIMIT;
    }

    @Override
    public void displayInfo() { // Polymorphism: overriding method
        super.displayInfo();
        System.out.println("Role: Student");
        System.out.println("Borrow Limit: " + BORROW_LIMIT);
    }
}

// Subclass: Staff (Inheritance from User)
class Staff extends User {
    private static final int BORROW_LIMIT = 5;

    public Staff(String name, int userID) {
        super(name, userID);
    }

    @Override
    public int getBorrowLimit() { // Polymorphism: overriding method
        return BORROW_LIMIT;
    }

    @Override
    public void displayInfo() { // Polymorphism: overriding method
        super.displayInfo();
        System.out.println("Role: Staff");
        System.out.println("Borrow Limit: " + BORROW_LIMIT);
    }
}

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("The book \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("The book \"" + title + "\" is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("The book \"" + title + "\" has been returned.");
        } else {
            System.out.println("The book \"" + title + "\" was not borrowed.");
        }
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Borrowed: " + (isBorrowed ? "Yes" : "No"));
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create some users
        User student = new Student("Alice", 1001);
        User staff = new Staff("Bob", 2001);

        // Display user information
        System.out.println("User Details:");
        student.displayInfo();
        System.out.println();
        staff.displayInfo();

        System.out.println("\n-------------------------------\n");

        // Create some books
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book2 = new Book("1984", "George Orwell");

        // Display book information
        System.out.println("Book Details:");
        book1.displayBookInfo();
        System.out.println();
        book2.displayBookInfo();

        System.out.println("\n-------------------------------\n");

        // Borrow and return books
        System.out.println("Borrowing Books:");
        book1.borrowBook(); // Borrow book1
        book2.borrowBook(); // Borrow book2
        book1.borrowBook(); // Attempt to borrow book1 again

        System.out.println("\nReturning Books:");
        book1.returnBook(); // Return book1
        book1.returnBook(); // Attempt to return book1 again
    }
}
