package aircraft;

public abstract class Aircraft {

    /**
     * The name of the aircraft.
     */
    private String name;

    /**
     * The number of rows in the aircraft.
     */
    private int numRows;

    /**
     * The number of seats per row in the aircraft.
     */
    private int seatsPerRow;

    /**
     * Constructs an Aircraft with the specified name, number of rows,
     * and seats per row.
     *
     * @param name         the name of the aircraft
     * @param numRows      the number of rows in the aircraft
     * @param seatsPerRow  the number of seats per row in the aircraft
     */
    public Aircraft(String name, int numRows, int seatsPerRow) {
        this.name = name;
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
    }

    /**
     * Returns the name of the aircraft.
     *
     * @return the name of the aircraft
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of rows in the aircraft.
     *
     * @return the number of rows
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * Returns the number of seats per row in the aircraft.
     *
     * @return the number of seats per row
     */
    public int getSeatsPerRow() {
        return seatsPerRow;
    }
}
