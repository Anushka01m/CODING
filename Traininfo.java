package traininformation;

public class Train {
    private String trainID;
    private String trainName;
    private String date;
    private String startingPoint;
    private String endingPoint;

    // Constructor
    public Train(String trainID, String trainName, String date, String startingPoint, String endingPoint) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.date = date;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    // Getters
    public String getTrainID() {
        return trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getDate() {
        return date;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    // Method to display train information
    public void displayTrainInfo() {
        System.out.println("Train ID: " + trainID);
        System.out.println("Train Name: " + trainName);
        System.out.println("Date: " + date);
        System.out.println("Starting Point: " + startingPoint);
        System.out.println("Ending Point: " + endingPoint);
    }
}
