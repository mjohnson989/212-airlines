/**
 * An abstract class that acts as a decorator for a Ticket, allowing additional
 * cost calculations to be applied to the base ticket.
 */
package decorator;

public abstract class CostDecorator extends Ticket {

    /**
     * The ticket being decorated.
     */
    protected Ticket ticket;

    /**
     * Constructs a CostDecorator with the specified ticket to decorate.
     *
     * @param ticket the base ticket to be decorated
     */
    public CostDecorator(Ticket ticket) {
        super(
                ticket.getFullName(),
                ticket.getDateOfBirth(),
                ticket.getSeatClass(),
                ticket.getSeatNumber(),
                ticket.getBoardingClass(),
                ticket.getCheckedBags()
        );
        this.ticket = ticket;
    }

    /**
     * Calculates the total cost of the ticket, including any additional costs
     * applied by the decorator.
     *
     * @return the total calculated cost
     */
    @Override
    public abstract double calculateCost();
}
