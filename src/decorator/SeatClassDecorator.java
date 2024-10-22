package decorator;

public class SeatClassDecorator extends CostDecorator {
    public SeatClassDecorator(Ticket ticket) {
        super(ticket);
    }

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
