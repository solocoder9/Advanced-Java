# JDBC Project - Hotel Reservation System

This project is a Java-based Hotel Reservation System designed to handle hotel reservations using JDBC (Java Database Connectivity) to interact with a MySQL database.

## Project Repository

You can access the full project repository here:  
[Hotel Reservation System on GitHub](https://github.com/solocoder9/Hotel-Reservation-System)

## About the Project

The Hotel Reservation System allows users to:

- **Reserve a room** by providing guest details.
- **View existing reservations**, including guest name, room number, contact details, and reservation date.
- **Update reservation details**, such as guest name, room number, and contact number.
- **Delete reservations** based on the reservation ID.
- Retrieve room numbers based on **reservation IDs** and **guest names**.

### Features

- **Reservation Operations**: Allows CRUD operations on room reservations.
- **User Interface**: An interactive console interface for easy navigation.
- **Database Integration**: Uses JDBC to connect to a MySQL database (`hotel_db`).

### Technologies Used

- **Java**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **Eclipse IDE**

## Setup Instructions

To get the Hotel Reservation System running on your local machine, follow these steps:

1. **Prerequisites**:
    - JDK (Java Development Kit) installed.
    - MySQL installed with a database named `hotel_db`.
    - Eclipse IDE (or any Java IDE) installed.

2. **Clone the Repository**:

    ```bash
    git clone https://github.com/solocoder9/Hotel-Reservation-System.git
    ```

3. **Import the Project into Eclipse**:
    - Open Eclipse IDE.
    - Select **File > Import > Existing Projects into Workspace**.
    - Browse to the cloned repository directory and select the project.

4. **Configure MySQL Database**:
    - Ensure MySQL server is running.
    - Create a database named `hotel_db`:
    
      ```sql
      CREATE DATABASE hotel_db;
      ```

5. **Modify Database Connection Details**:
    - Open `HotelReservationSystem.java`.
    - Update the connection URL, username, and password constants:

      ```java
      private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
      private static final String username = "root";
      private static final String password = "your-mysql-password";
      ```

6. **Run the Application**:
    - Right-click on `HotelReservationSystem.java` and select **Run As > Java Application**.
    - Follow the on-screen prompts to interact with the Hotel Reservation System.

## Usage

Upon running the application, a menu will appear, allowing you to select an operation (CRUD) to perform. You will be prompted to enter guest details, room numbers, etc., as needed.

## Contributing

Contributions to the Hotel Reservation System are welcome! To contribute:
1. Fork the repository.
2. Create a new feature branch:
    ```bash
    git checkout -b feature/YourFeature
    ```
3. Commit your changes:
    ```bash
    git commit -am 'Add some feature'
    ```
4. Push to your branch:
    ```bash
    git push origin feature/YourFeature
    ```
5. Create a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
