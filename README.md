# 📚 Library Manager

![Bookstore Logo](https://github.com/fmbicalho/LibraryManager/blob/main/src/main/resources/static/images/Banner.png)

## About The Project

![Screenshots](https://github.com/fmbicalho/LibraryManager/blob/main/src/main/resources/static/images/Home.png)
![Screenshots](https://github.com/fmbicalho/LibraryManager/blob/main/src/main/resources/static/images/Add-Edit.png)
![Screenshots](https://github.com/fmbicalho/LibraryManager/blob/main/src/main/resources/static/images/Detail.png)

## Features

- **📖 Book Inventory Management:** View, add, edit, and delete books.
- **🔄 Dynamic Updates:** Fetch and update data without full page reloads.
- **🌐 RESTful API Integration:** Interact with the backend through a REST API.

# 🏗️ Usage

## 🏛️ Main Page

When you access the application, you'll see a list of all books in the database.

- **👀 View Book Details:** Click on a book to see more details.
- **✏️ Edit a Book:** Click "Edit" to enter new book details and submit the form.
- **➕ Add a New Book:** Click "Add New Book" to enter new book details and submit the form.
- **🗑️ Delete a Book:** Click "Delete Book" to delete book from the application.

## 🌟 Book Detail Page

View more information from a specific book:

- **✏️ Edit Book:** Modify book details and save changes.
- **🗑️ Delete Book:** Remove a book from the inventory.
- **🔙 Navigate Back:** Return to the main.

## 🌐 Navigation

- **📚 Main Page:** Displays all books with option to add new books.
- **📖 Book Detail Page:** Allows viewing, editing, or deleting individual book records.
- **➕✏️ Book Add/Edit Page:** Allows editing or add a new book.


# 🛠️  Built With

## ☕ Back-End

- **Java:** Core language for backend development.
- **Spring Boot:** Manages the web layer and provides RESTful APIs.
- **Hibernate:** Handles database operations and maps Java objects to MySQL.
- **Thymeleaf:** Renders server-side HTML views.
- **Maven:** Manages dependencies and builds the project.
- **Tomcat:** Serves as the web server.

## 🎨 Front-End

- **JavaScript:** Fetches data, handles user interactions, and updates the UI.
- **HTML:** Defines the structure of web pages.
- **CSS:** Styles and layouts web pages.
- **Bootstrap:** Styles and layouts web pages.
- **FontAwesome:** Provides icons for enhanced UI.

## 🐋 Deploy

- **Docker:** Containerize the application for consistent deployments.

# 📦 Prerequisites

- **JDK 8 or higher:** Check installation with `java -version`.
- **Apache Maven:** Verify installation with `mvn -version`.
- **MySQL:** Ensure MySQL is installed and running.  
- Check with `mysql --version` and `sudo systemctl status mysql`.
- **Apache Tomcat:** Ensure Tomcat is installed. Check by going to [http://localhost:8080](http://localhost:8080).

# 📦 Installation

### For MacOS or Linux (UNIX Based):

1. **Install JDK 8 or 11:**
   ```sh
   sudo apt install openjdk-8-jdk  # For OpenJDK 8
   sudo apt install openjdk-11-jdk # For OpenJDK 11

2. **Install Maven:**
    ```sh
    sudo apt update
    sudo apt install maven

3. **Install MySQL and create Database:**
    ```sh
    sudo apt update
    sudo apt install mysql-server
    mysql -u root -p

    ```sql
    CREATE DATABASE BOOKS;
    USE BOOKS;
    
    CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    publishedDate DATE NOT NULL,
    price DECIMAL(10, 2),
    description VARCHAR(1000)

    INSERT INTO books (title, author, isbn, publishedDate, price, description) VALUES
   ('To Kill a Mockingbird', 'Harper Lee', '9780060935467', '1960-07-11', 10.99, 'A novel about the serious issues of rape and racial inequality.'),
   ('1984', 'George Orwell', '9780451524935', '1949-06-08', 9.99, 'A dystopian novel set in a totalitarian society under constant surveillance.'),
   ('Moby Dick', 'Herman Melville', '9781503280786', '1851-10-18', 11.99, 'The narrative of the obsessive quest of Ahab for revenge on Moby Dick.'),
   ('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', '1925-04-10', 14.99, 'A critique of the American Dream, set in the Roaring Twenties.'),
   ('Pride and Prejudice', 'Jane Austen', '9781503290563', '1813-01-28', 12.99, 'A romantic novel that also critiques the social structures of its time.'),
   ('The Catcher in the Rye', 'J.D. Salinger', '9780316769488', '1951-07-16', 10.49, 'A story about teenage rebellion and alienation.'),
   ('The Hobbit', 'J.R.R. Tolkien', '9780547928227', '1937-09-21', 13.49, 'A fantasy novel about the adventures of Bilbo Baggins.'),
   ('Fahrenheit 451', 'Ray Bradbury', '9781451673319', '1953-10-19', 11.49, 'A dystopian novel about a future where books are outlawed.'),
   ('Brave New World', 'Aldous Huxley', '9780060850524', '1932-08-30', 12.49, 'A dystopian novel that explores a technologically advanced, but morally questionable society.'),
   ('Jane Eyre', 'Charlotte Brontë', '9780142437209', '1847-10-16', 10.99, 'A novel about a young orphaned girl and her struggles for independence and love.');
   );

    SELECT * FROM books;


4. **Install Tomcat:**

      Go to the Tomcat download page
   ```sh tar xzf apache-tomcat-9.x.xx.tar.gz```

tar: The command to extract archive files.  
-x: Option for extraction.  
-v: Option for verbose output (optional).  
-f: Option to specify the archive filename.

Move the extracted directory to /opt or another preferred location:

``` sudo mv apache-tomcat-9.x.xx /opt/tomcat```

Navigate to the Tomcat configuration directory:

``` cd ~/tomcat/conf```

Edit the tomcat-users.xml file:

Open tomcat-users.xml using a text editor (e.g., vim): ``` sudo vim tomcat-users.xml```

Add the following lines at the end of the file:

    <role rolename="manager-gui"/>
    <role rolename="manager-script"/>
    <user username="tomcat" password="tomcat" roles="admin-gui,manager-gui,manager-script"/>

Create the settings.xml file (if it doesn't exist): ``` touch ~/.m2/settings.xml```

Edit the settings.xml file:   
Open settings.xml using a text editor (e.g., vim): ``` vim ~/.m2/settings.xml```

Add the following content:

     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
    <!--INSERT SERVER AUTHENTICATION INFORMATION HERE -->
    <server>
    <id>tomcat</id>
    <username>tomcat</username>
    <password>tomcat</password>
    </server>
    </servers>
    </settings>

Change the Username and Password to what you want.

# 🖥️ Getting Started

Clone the Repository:

git clone
```https://github.com/fmbicalho/LibraryManager.git```

Start the MySQL service: ```sudo systemctl start mysqld```  

Start Tomcat: ```sudo ./path/to/tomcat/startup.sh```  
Or, if you are already in the Tomcat directory: ```sudo ./startup.sh```

In your IDE terminal, inside the project directory, use: ```mvn tomcat7:deploy```  
to clean: ```mvn clean```  
to undeploy ```mvn tomcat7:undeploy```  
to redeploy ```mvn tomcat7:redeploy```

OR use IntelliJ (Or any other IDE):  

Run LibraryApplication in library/src/main/java/infiniitysown/library  
Open Browser  
GOTO localhost:8085/  
(make sure your db is running)

OR use Docker:  

```mvn clean package```  
```docker image build -t library-manager .  ```  
```docker container run -p 8085:8085 -d library-manager```  
GOTO localhost:8085/

# 🎉 Acknowledgements

- **Code For All Bootcamp:** Thanks for organizing this Technical Assignment.
- **Technologies Used:** Appreciation to the tools and frameworks like Spring Boot, Hibernate, Thymeleaf, and Bootstrap, which were crucial in building this project.

# 📈 Future Enhancements

- **Enhanced Search Functionality:** Implement a search options to filter books by some criteria.
- **User Authentication:** Add user login and registration features for personalized book management.
- **Improved UI/UX:** Refine the user interface and experience for better usability and aesthetic appeal.

# 📜 License

This project is open-source. Feel free to contribute, modify, and use it as per your needs.
