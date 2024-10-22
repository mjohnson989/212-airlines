package boardingprocess;

import decorator.Ticket;

public class StandardBoarding implements BoardingProcess {
    @Override
    public void board(Ticket ticket) {
        System.out.println("Standard boarding for: " + ticket.getFullName());
    }
}
