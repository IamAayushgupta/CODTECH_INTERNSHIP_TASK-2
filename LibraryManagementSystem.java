package librarymanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagementSystem extends JFrame {
    private Library library;

    public LibraryManagementSystem() {
        library = new Library();

        // Set up the frame
        setTitle("Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showLoginPanel();
    }

    private void showLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                User user = library.authenticateUser(username, password);
                if (user != null) {
                    remove(loginPanel);
                    if (user instanceof Librarian) {
                        showLibrarianPanel();
                    } else if (user instanceof Patron) {
                        showPatronPanel();
                    }
                    else {
                        showPatronPanel();
                     //   JOptionPane.showMessageDialog(null, "Invalid credentials");
                    }
                }
            }
        });

        setVisible(true);
    }

    private void showLibrarianPanel() {
        JPanel librarianPanel = new JPanel();
        librarianPanel.setLayout(new BorderLayout());

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        librarianPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField categoryField = new JTextField();
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Book", "Magazine", "DVD"});
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeComboBox);
        inputPanel.add(new JLabel("Username (for new user):"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password (for new user):"));
        inputPanel.add(passwordField);

        JButton addButton = new JButton("Add Item");
        JButton addUserButton = new JButton("Add User");
        JButton searchButton = new JButton("Search");

        inputPanel.add(addButton);
        inputPanel.add(addUserButton);
        inputPanel.add(searchButton);

        librarianPanel.add(inputPanel, BorderLayout.SOUTH);

        add(librarianPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                String category = categoryField.getText();
                String type = (String) typeComboBox.getSelectedItem();

                LibraryItem item;
                if (type.equals("Book")) {
                    item = new Book(title, author, category);
                } else if (type.equals("Magazine")) {
                    item = new Magazine(title, author, category);
                } else {
                    item = new DVD(title, author, category);
                }

                library.addItem(item);
                updateOutput(outputArea);
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                User user = new Patron(username, password);
                library.addUser(user);
                updateOutput(outputArea);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                StringBuilder result = new StringBuilder("Search Results:\n");
                for (LibraryItem item : library.searchByTitle(title)) {
                    result.append(item).append("\n");
                }
                outputArea.setText(result.toString());
            }
        });

        setVisible(true);
    }

    private void showPatronPanel() {
        JPanel patronPanel = new JPanel();
        patronPanel.setLayout(new BorderLayout());

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        patronPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 1));

        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField categoryField = new JTextField();

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);

        JButton searchButton = new JButton("Search");

        inputPanel.add(searchButton);

        patronPanel.add(inputPanel, BorderLayout.SOUTH);

        add(patronPanel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                StringBuilder result = new StringBuilder("Search Results:\n");
                for (LibraryItem item : library.searchByTitle(title)) {
                    result.append(item).append("\n");
                }
                outputArea.setText(result.toString());
            }
        });

        setVisible(true);
    }

    private void updateOutput(JTextArea outputArea) {
        StringBuilder output = new StringBuilder("Library Inventory:\n");
        for (LibraryItem item : library.getItems()) {
            output.append(item).append("\n");
        }
        outputArea.setText(output.toString());
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}
