package decorator;

public class SeatClassDecorator extends CostDecorator {

    /**
     * Constructs a SeatClassDecorator with the specified ticket to decorate.
     *
     * @param ticket the base ticket to be decorated
     */
    public SeatClassDecorator(Ticket ticket) {
        super(ticket);
    }

    /**
     * Calculates the total cost of the ticket, including additional charges
     * based on the seat class
     *
     * The additional charges are stated in each case
     *
     * @return the total calculated cost of the ticket
     */
    @Override
    public double calculateCost() {
        double cost = ticket.calculateCost();
        switch (ticket.getSeatClass().toLowerCase()) {
            case "first":
                cost += 200.0;
                break;
            case "comfort":
                cost += 100.0;
                break;
            case "economy":
                cost += 50.0;
                break;
        }
        return cost;
    }
}
