package project;

public class Item {
    private int id;
    private String name;
    private String description;
    private double startingBid;
    private double currentBid;
    private int highestBidderId;

    public Item(int id, String name, String description, double startingBid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startingBid = startingBid;
        this.currentBid = startingBid;
        this.highestBidderId = -1;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public int getHighestBidderId() {
        return highestBidderId;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartingBid(double startingBid) {
        this.startingBid = startingBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public void setHighestBidderId(int highestBidderId) {
        this.highestBidderId = highestBidderId;
    }
}

