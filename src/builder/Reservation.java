package builder;

import aircraft.Aircraft;
import airlines.Layover;
import decorator.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    /**
     * The number of tickets associated with the reservation.
     */
    private int numberOfTickets;

    /**
     * The total cost of all tickets in the reservation.
     */
    private double totalCost;

    /**
     * The date and time of the reservation in a specific format.
     */
    String dateTime;

    /**
     * The IATA code of the source airport.
     */
    private String sourceAirportCode;

    /**
     * The IATA code of the destination airport.
     */
    private String destinationAirportCode;

    /**
     * The airline associated with the reservation.
     */
    private String airline;

    /**
     * The aircraft used for the reservation.
     */
    private Aircraft aircraft;

    /**
     * A list of tickets included in the reservation.
     */
    private List<Ticket> tickets = new ArrayList<>();

    /**
     * A list of layovers included in the reservation.
     */
    private List<Layover> layovers = new ArrayList<>();

    /**
     * Constructs a new reservation with the specified details.
     *
     * @param sourceAirportCode     the IATA code of the source airport
     * @param destinationAirportCode the IATA code of the destination airport
     * @param dateTime               the date and time of the reservation
     * @param airline                the airline associated with the reservation
     */
    public Reservation(String sourceAirportCode, String destinationAirportCode, String dateTime, String airline) {
        this.sourceAirportCode = sourceAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.dateTime = dateTime;
        this.airline = airline;
        this.tickets = new ArrayList<>();
        this.layovers = new ArrayList<>();
        this.numberOfTickets = 0;
        this.totalCost = 0.0;
    }

    /**
     * Adds a ticket to the reservation and updates the total cost and number of tickets.
     *
     * @param ticket the ticket to add
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        totalCost += ticket.calculateCost();
        numberOfTickets = tickets.size();
    }

    /**
     * Sets the aircraft for the reservation.
     *
     * @param aircraft the Aircraft to set
     */
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    /**
     * Adds a layover to the reservation.
     *
     * @param layover the layover to add
     */
    public void addLayover(Layover layover) {
        layovers.add(layover);
    }

    /**
     * Returns the total cost of the reservation.
     *
     * @return the total cost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Returns the source airport code.
     *
     * @return the source airport code
     */
    public String getSourceAirportCode() {
        return sourceAirportCode;
    }

    /**
     * Returns the destination airport code.
     *
     * @return the destination airport code
     */
    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    /**
     * Returns the airline associated with the reservation.
     *
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Returns the list of tickets included in the reservation.
     *
     * @return the list of tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Returns the list of layovers included in the reservation.
     *
     * @return the list of layovers
     */
    public List<Layover> getLayovers() {
        return layovers;
    }

    /**
     * Returns the date and time of the reservation.
     *
     * @return the date and time
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Returns the aircraft associated with the reservation.
     *
     * @return the aircraft
     */
    public Aircraft getAircraft() {
        return aircraft;
    }
}
