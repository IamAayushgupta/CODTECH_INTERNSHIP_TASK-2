
Name: Aayush gupta

Company: CODTECH IT Solutions

ID: CT12DS1423

Domain: Java programming

Duration: june to july 2024

Mentor: Muzzamil ahmed

  -: Project Description :-
  
The Library Management System (LMS) is a comprehensive software application designed to facilitate the management of library resources including books, magazines, and DVDs. This system allows librarians
and patrons to efficiently manage, access, and utilize library resources through a user-friendly interface. The LMS is implemented using Java programming language and incorporates a graphical user
interface (GUI) developed with Java Swing, ensuring an interactive and intuitive user experience.

  -: Key Features :-
  
1.User Authentication:

 - Multiple user roles: Librarian and Patron.
 - Secure login system to authenticate users based on their credentials.

2.Resource Management:

 - Ability to add, edit, and delete library items (books, magazines, DVDs).
 - Track inventory levels and manage the availability status of items.

3.User Management:

 - Manage user information including adding new users with specific roles.
 - Authentication system to ensure secure access for librarians and patrons.
 
4.Checkout and Return:

 - Functionality to check out and return items, updating their status in the inventory.
 - Track due dates and manage overdue fines (to be implemented).

5.Search and Reporting:

 - Search functionality to find items by title, author, or category.
 - Generate reports such as inventory status and search results.

6.Data Persistence:

 - Save and load library data to and from files for persistent storage (to be implemented).

 -: Technologies Used :-

 - Programming Language: Java
 - Graphical User Interface (GUI): Java Swing
 - Data Storage: File handling (for data persistence; to be implemented)

 -: Class Structure :-

 - LibraryItem: Abstract base class representing a generic library item.

Book: Subclass representing a book.
Magazine: Subclass representing a magazine.
DVD: Subclass representing a DVD.
User: Abstract base class representing a generic user.

 - Librarian: Subclass representing a librarian.
Patron: Subclass representing a patron.
Library: Manages the collection of library items and users. Handles operations such as adding items, user authentication, and searching.

 - LibraryManagementSystem: Main class that initializes the application and provides the GUI for user interaction.

  -: Implementation Details :-
  
 - LibraryItem Class: Defines common attributes and methods for all library items.
 - User Class: Defines common attributes and methods for all users, including authentication.
 - Library Class: Contains methods to manage library items and users, including adding items, searching, and authenticating users.
 - LibraryManagementSystem Class: Provides the main application window with different panels for librarians and patrons to perform their respective tasks.


