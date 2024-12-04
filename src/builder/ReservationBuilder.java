package builder;

import aircraft.Aircraft;
import airlines.Layover;
import decorator.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ReservationBuilder {

    /**
     * The IATA code of the source airport.
     */
    private String sourceAirportCode;

    /**
     * The IATA code of the destination airport.
     */
    private String destinationAirportCode;

    /**
     * The date and time of the reservation in a specified format.
     */
    private String dateTime;

    /**
     * The airline associated with the reservation.
     */
    private String airline;

    /**
     * The aircraft for the reservation.
     */
    private Aircraft aircraft;

    /**
     * A list of tickets associated with the reservation.
     */
    private List<Ticket> tickets = new ArrayList<>();

    /**
     * A list of layovers associated with the reservation.
     */
    private List<Layover> layovers = new ArrayList<>();

    /**
     * Sets the source airport code for the reservation.
     *
     * @param sourceAirportCode the IATA code of the source airport
     * @return the builder instance
     */
    public ReservationBuilder setSourceAirportCode(String sourceAirportCode) {
        if (sourceAirportCode == null || sourceAirportCode.isEmpty()) {
            throw new IllegalArgumentException("Source airport code cannot be null or empty.");
        }
        this.sourceAirportCode = sourceAirportCode;
        return this;
    }

    /**
     * Sets the destination airport code for the reservation.
     *
     * @param destinationAirportCode the IATA code of the destination airport
     * @return the builder instance
     */
    public ReservationBuilder setDestinationAirportCode(String destinationAirportCode) {
        if (destinationAirportCode == null || destinationAirportCode.isEmpty()) {
            throw new IllegalArgumentException("Destination airport code cannot be null or empty.");
        }
        this.destinationAirportCode = destinationAirportCode;
        return this;
    }

    /**
     * Sets the date and time for the reservation.
     *
     * @param dateTime the date and time of the reservation
     * @return the builder instance
     */
    public ReservationBuilder setDateTime(String dateTime) {
        if (dateTime == null || dateTime.isEmpty()) {
            throw new IllegalArgumentException("Date and time cannot be null or empty.");
        }
        this.dateTime = dateTime;
        return this;
    }

    /**
     * Sets the airline for the reservation.
     *
     * @param airline the airline associated with the reservation
     * @return the builder instance
     */
    public ReservationBuilder setAirline(String airline) {
        if (airline == null || airline.isEmpty()) {
            throw new IllegalArgumentException("Airline cannot be null or empty.");
        }
        this.airline = airline;
        return this;
    }

    /**
     * Sets the aircraft for the reservation.
     *
     * @param aircraft the aircraft associated with the reservation
     * @return the builder instance
     */
    public ReservationBuilder setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
        return this;
    }

    /**
     * Adds a ticket to the reservation.
     *
     * @param ticket the ticket to be added
     * @return the builder instance
     */
    public ReservationBuilder addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        return this;
    }

    /**
     * Adds a layover to the reservation.
     *
     * @param layover the layover to be added
     * @return the builder instance
     */
    public ReservationBuilder addLayover(Layover layover) {
        this.layovers.add(layover);
        return this;
    }

    /**
     * Builds and returns a Reservation object using the provided details.
     *
     * @return the constructed Reservation object
     * @throws IllegalStateException if any required details are missing
     */
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
