import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// User class to handle user authentication
class User {
    private String username;
    private String password;
    private boolean isAuthenticated;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAuthenticated = false;
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        if (this.password.equals(password)) {
            this.isAuthenticated = true;
            return true;
        }
        return false;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}

// Book class to handle book information and operations
class Book {
    private String title;
    private String author;
    private String category;
    private boolean isBorrowed;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book borrowed: " + title);
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
}

// Library class to manage books and users
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.authenticate(password)) {
                System.out.println("User authenticated successfully.");
                return user;
            }
        }
        System.out.println("Authentication failed.");
        return null;
    }

    public void borrowBook(User user, String title) {
        if (user == null || !user.isAuthenticated()) {
            System.out.println("User not authenticated.");
            return;
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(User user, String title) {
        if (user == null || !user.isAuthenticated()) {
            System.out.println("User not authenticated.");
            return;
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void listBooksByCategory(String category) {
        System.out.println("Books in category: " + category);
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

// Main class to run the E-Library System
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adding some books and users
        library.addBook(new Book("Java Programming", "John Doe", "Programming"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));
        library.addBook(new Book("Design Patterns", "Erich Gamma", "Software Engineering"));
        
        library.addUser(new User("user1", "password1"));
        library.addUser(new User("user2", "password2"));

        System.out.println("Welcome to the E-Library System!");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = library.authenticateUser(username, password);

        if (user != null && user.isAuthenticated()) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n1. Borrow Book\n2. Return Book\n3. List Books by Category\n4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter the title of the book to borrow: ");
                        String borrowTitle = scanner.nextLine();
                        library.borrowBook(user, borrowTitle);
                        break;
                    case 2:
                        System.out.print("Enter the title of the book to return: ");
                        String returnTitle = scanner.nextLine();
                        library.returnBook(user, returnTitle);
                        break;
                    case 3:
                        System.out.print("Enter the category of books to list: ");
                        String category = scanner.nextLine();
                        library.listBooksByCategory(category);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }

        System.out.println("Thank you for using the E-Library System!");
        scanner.close();
    }
}