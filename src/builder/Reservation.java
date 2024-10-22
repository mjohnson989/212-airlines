package builder;

import aircraft.Aircraft;
import airlines.Layover;
import decorator.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int numberOfTickets;
    private double totalCost;
    String dateTime;
    private String sourceAirportCode;
    private String destinationAirportCode;
    private String airline;
    private Aircraft aircraft;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Layover> layovers = new ArrayList<>();

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

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        totalCost += ticket.calculateCost();
        numberOfTickets = tickets.size();
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public void addLayover(Layover layover) {
        layovers.add(layover);
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getSourceAirportCode() {
        return sourceAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public String getAirline() {
        return airline;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Layover> getLayovers() {
        return layovers;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }
}
