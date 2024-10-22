package aircraft;

public abstract class Aircraft {
    private String name;
    private int numRows;
    private int seatsPerRow;

    public Aircraft(String name, int numRows, int seatsPerRow) {
        this.name = name;
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
    }

    public String getName() {
        return name;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }
}
