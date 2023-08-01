package project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/navi";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    private Connection connection;

    public DatabaseHandler() {
        try {
            // Update the database URL, username, and password accordingly
            String url = "jdbc:mysql://localhost:3306/navi";
            String username = "root";
            String password = "12345";

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String username, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User authenticateUser(String username, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                return new User(id, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Add methods for adding/listing items and handling bids
    // ...

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double startingBid = resultSet.getDouble("starting_bid");
                double currentBid = resultSet.getDouble("current_bid");
                int highestBidderId = resultSet.getInt("highest_bidder_id");
                items.add(new Item(id, name, description, startingBid));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    // Rest of the code remains the same...
}
