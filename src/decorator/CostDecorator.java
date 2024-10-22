package decorator;

public abstract class CostDecorator extends Ticket {
    protected Ticket ticket;

    public CostDecorator(Ticket ticket) {
        super(ticket.getFullName(), ticket.getDateOfBirth(), ticket.getSeatClass(), ticket.getSeatNumber(), ticket.getBoardingClass(), ticket.getCheckedBags());
        this.ticket = ticket;
    }

    @Override
    public abstract double calculateCost();
}

