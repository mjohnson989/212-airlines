package decorator;

public class Ticket {

    /**
     * The full name of the passenger.
     */
    private String fullName;

    /**
     * The date of birth of the passenger.
     */
    private String dateOfBirth;

    /**
     * The seat class for the ticket (e.g., Economy, Comfort, First).
     */
    private String seatClass;

    /**
     * The seat number assigned to the passenger.
     */
    private String seatNumber;

    /**
     * The boarding class for the ticket (e.g., Priority, Standard).
     */
    private String boardingClass;

    /**
     * The number of checked bags allowed for the passenger.
     */
    private int checkedBags;

    /**
     * Constructs a Ticket with the specified details.
     *
     * @param fullName      the full name of the passenger
     * @param dateOfBirth   the date of birth of the passenger
     * @param seatClass     the seat class of the ticket
     * @param seatNumber    the seat number assigned to the passenger
     * @param boardingClass the boarding class of the ticket
     * @param checkedBags   the number of checked bags allowed
     */
    public Ticket(String fullName, String dateOfBirth, String seatClass, String seatNumber, String boardingClass, int checkedBags) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.seatClass = seatClass;
        this.seatNumber = seatNumber;
        this.boardingClass = boardingClass;
        this.checkedBags = checkedBags;
    }

    /**
     * Calculates the base cost of the ticket.
     * The default implementation returns 0.0 and is intended to be overridden by decorators.
     *
     * @return the base cost of the ticket
     */
    public double calculateCost() {
        return 0.0; // To be extended with decorators
    }

    /**
     * Returns the full name of the passenger.
     *
     * @return the full name of the passenger
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Returns the date of birth of the passenger.
     *
     * @return the date of birth of the passenger
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Returns the seat class of the ticket.
     *
     * @return the seat class of the ticket
     */
    public String getSeatClass() {
        return seatClass;
    }

    /**
     * Returns the seat number assigned to the passenger.
     *
     * @return the seat number
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * Returns the boarding class of the ticket.
     *
     * @return the boarding class of the ticket
     */
    public String getBoardingClass() {
        return boardingClass;
    }

    /**
     * Returns the number of checked bags allowed for the passenger.
     *
     * @return the number of checked bags
     */
    public int getCheckedBags() {
        return checkedBags;
    }
}
