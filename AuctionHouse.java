package project;

import java.util.ArrayList;
import java.util.List;

public class AuctionHouse {
    private List<User> users;
    private List<Item> items;
    private User loggedInUser;

    public AuctionHouse() {
        users = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void registerUser(String username, String password) {
        int id = users.size() + 1;
        User newUser = new User(id, username, password);
        users.add(newUser);
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                return user;
            }
        }
        return null;
    }

    public void listItem(String name, String description, double startingBid) {
        int id = items.size() + 1;
        Item newItem = new Item(id, name, description, startingBid);
        items.add(newItem);
    }

    public void showAllItems() {
        for (Item item : items) {
            System.out.println(item.getId() + ". " + item.getName() + " - " + item.getDescription() +
                    " | Starting Bid: $" + item.getStartingBid() + " | Current Bid: $" + item.getCurrentBid() +
                    " | Highest Bidder ID: " + item.getHighestBidderId());
        }
    }

    public void bidItem(int itemId, double newBid, int newBidderId) {
        Item item = findItemById(itemId);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        if (newBid > item.getCurrentBid()) {
            item.setCurrentBid(newBid);
            item.setHighestBidderId(newBidderId);
            System.out.println("Bid successful! New bid: $" + newBid + " | Highest Bidder ID: " + newBidderId);
        } else {
            System.out.println("Your bid must be higher than the current bid.");
        }
    }

    private Item findItemById(int itemId) {
        for (Item item : items) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        return null;
    }

    // Getters and setters for loggedInUser
    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
