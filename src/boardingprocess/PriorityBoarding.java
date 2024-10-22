package boardingprocess;

import decorator.Ticket;

public class PriorityBoarding implements BoardingProcess {
    @Override
    public void board(Ticket ticket) {
        System.out.println("Priority boarding for: " + ticket.getFullName());
    }
}