package decorator;

public class Ticket {
    private String fullName;
    private String dateOfBirth;
    private String seatClass;
    private String seatNumber;
    private String boardingClass;
    private int checkedBags;

    public Ticket(String fullName, String dateOfBirth, String seatClass, String seatNumber, String boardingClass, int checkedBags) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.seatClass = seatClass;
        this.seatNumber = seatNumber;
        this.boardingClass = boardingClass;
        this.checkedBags = checkedBags;
    }

    public double calculateCost() {
        return 0.0; //To be added to with decorators
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getBoardingClass() {
        return boardingClass;
    }

    public int getCheckedBags() {
        return checkedBags;
    }
}
