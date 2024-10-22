package decorator;

public class CheckedBagsDecorator extends CostDecorator {
    private static final double BAG_COST = 30.0;

    public CheckedBagsDecorator(Ticket ticket) {
        super(ticket);
    }

    @Override
    public double calculateCost() {
        return ticket.calculateCost() + ticket.getCheckedBags() * BAG_COST;
    }
}
