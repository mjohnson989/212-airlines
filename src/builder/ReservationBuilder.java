package builder;

import aircraft.Aircraft;
import airlines.Layover;
import decorator.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ReservationBuilder {
    private String sourceAirportCode;
    private String destinationAirportCode;
    private String dateTime;
    private String airline;
    private Aircraft aircraft;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Layover> layovers = new ArrayList<>();

    public ReservationBuilder setSourceAirportCode(String sourceAirportCode) {
        if (sourceAirportCode == null || sourceAirportCode.isEmpty()) {
            throw new IllegalArgumentException("Source airport code cannot be null or empty.");
        }
        this.sourceAirportCode = sourceAirportCode;
        return this;
    }

    public ReservationBuilder setDestinationAirportCode(String destinationAirportCode) {
        if (destinationAirportCode == null || destinationAirportCode.isEmpty()) {
            throw new IllegalArgumentException("Destination airport code cannot be null or empty.");
        }
        this.destinationAirportCode = destinationAirportCode;
        return this;
    }

    public ReservationBuilder setDateTime(String dateTime) {
        if (dateTime == null || dateTime.isEmpty()) {
            throw new IllegalArgumentException("Date and time cannot be null or empty.");
        }
        this.dateTime = dateTime;
        return this;
    }

    public ReservationBuilder setAirline(String airline) {
        if (airline == null || airline.isEmpty()) {
            throw new IllegalArgumentException("Airline cannot be null or empty.");
        }
        this.airline = airline;
        return this;
    }

    public ReservationBuilder setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
        return this;
    }

    public ReservationBuilder addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        return this;
    }

    public ReservationBuilder addLayover(Layover layover) {
        this.layovers.add(layover);
        return this;
    }

    public Reservation build() {

        Reservation reservation = new Reservation(sourceAirportCode, destinationAirportCode, dateTime, airline);

        reservation.setAircraft(aircraft);
        for (Ticket ticket : tickets) {
            reservation.addTicket(ticket);
        }
        for (Layover layover : layovers) {
            reservation.addLayover(layover);
        }

        return reservation;
    }
}
