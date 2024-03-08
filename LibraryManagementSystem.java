import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Librarian {
    String name;
    String password;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

public class LibraryManagementSystem extends JFrame implements ActionListener {
    ArrayList<Librarian> librarians = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();

    JMenu adminMenu, librarianMenu;
    JMenuItem addLibrarian, viewLibrarians, deleteLibrarian, addBook, viewBooks, issueBook, viewIssuedBooks, returnBook, logout;
    JMenuBar menuBar;

    public LibraryManagementSystem() {
        setTitle("Library Management System");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        adminMenu = new JMenu("Admin");
        librarianMenu = new JMenu("Librarian");

        addLibrarian = new JMenuItem("Add Librarian");
        viewLibrarians = new JMenuItem("View Librarians");
        deleteLibrarian = new JMenuItem("Delete Librarian");
        addBook = new JMenuItem("Add Book");
        viewBooks = new JMenuItem("View Books");
        issueBook = new JMenuItem("Issue Book");
        viewIssuedBooks = new JMenuItem("View Issued Books");
        returnBook = new JMenuItem("Return Book");
        logout = new JMenuItem("Logout");

        adminMenu.add(addLibrarian);
        adminMenu.add(viewLibrarians);
        adminMenu.add(deleteLibrarian);
        adminMenu.add(logout);

        librarianMenu.add(addBook);
        librarianMenu.add(viewBooks);
        librarianMenu.add(issueBook);
        librarianMenu.add(viewIssuedBooks);
        librarianMenu.add(returnBook);
        librarianMenu.add(logout);

        menuBar = new JMenuBar();
        menuBar.add(adminMenu);
        menuBar.add(librarianMenu);

        setJMenuBar(menuBar);

        addLibrarian.addActionListener(this);
        viewLibrarians.addActionListener(this);
        deleteLibrarian.addActionListener(this);
        addBook.addActionListener(this);
        viewBooks.addActionListener(this);
        issueBook.addActionListener(this);
        viewIssuedBooks.addActionListener(this);
        returnBook.addActionListener(this);
        logout.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addLibrarian) {
            String name = JOptionPane.showInputDialog(this, "Enter Librarian Name:");
            String password = JOptionPane.showInputDialog(this, "Enter Librarian Password:");
            Librarian newLibrarian = new Librarian(name, password);
            librarians.add(newLibrarian);
            JOptionPane.showMessageDialog(this, "Librarian Added Successfully!");
        } else if (e.getSource() == viewLibrarians) {
            StringBuilder librarianList = new StringBuilder();
            for (Librarian librarian : librarians) {
                librarianList.append("Name: ").append(librarian.name).append(", Password: ").append(librarian.password).append("\n");
            }
            JOptionPane.showMessageDialog(this, "List of Librarians:\n" + librarianList.toString());
        } else if (e.getSource() == deleteLibrarian) {
            String name = JOptionPane.showInputDialog(this, "Enter Librarian Name to delete:");
            for (Librarian librarian : librarians) {
                if (librarian.name.equals(name)) {
                    librarians.remove(librarian);
                    JOptionPane.showMessageDialog(this, "Librarian Deleted Successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Librarian not found!");
        } else if (e.getSource() == addBook) {
            String title = JOptionPane.showInputDialog(this, "Enter Book Title:");
            String author = JOptionPane.showInputDialog(this, "Enter Book Author:");
            Book newBook = new Book(title, author);
            books.add(newBook);
            JOptionPane.showMessageDialog(this, "Book Added Successfully!");
        } else if (e.getSource() == viewBooks) {
            StringBuilder bookList = new StringBuilder();
            for (Book book : books) {
                bookList.append("Title: ").append(book.title).append(", Author: ").append(book.author);
                if (book.isIssued) {
                    bookList.append(" (Issued)");
                } else {
                    bookList.append(" (Available)");
                }
                bookList.append("\n");
            }
            JOptionPane.showMessageDialog(this, "List of Books:\n" + bookList.toString());
        } else if (e.getSource() == issueBook) {
            String title = JOptionPane.showInputDialog(this, "Enter Book Title to issue:");
            for (Book book : books) {
                if (book.title.equals(title)) {
                    if (book.isIssued) {
                        JOptionPane.showMessageDialog(this, "Book is already issued!");
                    } else {
                        book.isIssued = true;
                        JOptionPane.showMessageDialog(this, "Book Issued Successfully!");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Book not found!");
        } else if (e.getSource() == viewIssuedBooks) {
            StringBuilder issuedBookList = new StringBuilder();
            for (Book book : books) {
                if (book.isIssued) {
                    issuedBookList.append("Title: ").append(book.title).append(", Author: ").append(book.author).append("\n");
                }
            }
            JOptionPane.showMessageDialog(this, "List of Issued Books:\n" + issuedBookList.toString());
        } else if (e.getSource() == returnBook) {
            String title = JOptionPane.showInputDialog(this, "Enter Book Title to return:");
            for (Book book : books) {
                if (book.title.equals(title)) {
                    if (book.isIssued) {
                        book.isIssued = false;
                        JOptionPane.showMessageDialog(this, "Book Returned Successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Book is not issued yet!");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Book not found!");
        } else if (e.getSource() == logout) {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?");
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Logged out successfully!");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.setVisible(true);
    }
}
