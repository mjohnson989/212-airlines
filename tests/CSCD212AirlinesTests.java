import aircraft.Aircraft;
import aircraft.CommercialAircraft;
import airlines.Layover;
import boardingprocess.BoardingProcess;
import boardingprocess.PriorityBoarding;
import boardingprocess.StandardBoarding;
import builder.Reservation;
import builder.ReservationBuilder;
import decorator.CheckedBagsDecorator;
import decorator.SeatClassDecorator;
import decorator.Ticket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CSCD212AirlinesTests {
    @Test
    void testCreateReservationWithRequiredFields() {
        ReservationBuilder builder = new ReservationBuilder();
        Reservation reservation = builder.setSourceAirportCode("JFK")
                .setDestinationAirportCode("LAX")
                .setDateTime("2024-12-25 14:00")
                .setAirline("Delta Airlines")
                .build();

        assertEquals("JFK", reservation.getSourceAirportCode());
        assertEquals("LAX", reservation.getDestinationAirportCode());
        assertEquals("2024-12-25 14:00", reservation.getDateTime());
        assertEquals("Delta Airlines", reservation.getAirline());
    }

    @Test
    void testReservationWithAircraft() {
        Aircraft aircraft = new CommercialAircraft("Boeing 747", 50, 6);
        ReservationBuilder builder = new ReservationBuilder();
        Reservation reservation = builder.setSourceAirportCode("JFK")
                .setDestinationAirportCode("LAX")
                .setDateTime("2024-12-25 14:00")
                .setAirline("Delta Airlines")
                .setAircraft(aircraft)
                .build();

        assertNotNull(reservation.getAircraft());
        assertEquals("Boeing 747", reservation.getAircraft().getName());
    }

    @Test
    void testAddLayovers() {
        ReservationBuilder builder = new ReservationBuilder();
        builder.setSourceAirportCode("JFK")
                .setDestinationAirportCode("LAX")
                .setDateTime("2024-12-25 14:00")
                .setAirline("Delta Airlines");

        builder.addLayover(new Layover("ORD", 120))
                .addLayover(new Layover("DEN", 90));

        Reservation reservation = builder.build();
        List<Layover> layovers = reservation.getLayovers();

        assertEquals(2, layovers.size());
        assertEquals("ORD", layovers.get(0).getAirportCode());
        assertEquals(120, layovers.get(0).getDuration());
        assertEquals("DEN", layovers.get(1).getAirportCode());
        assertEquals(90, layovers.get(1).getDuration());
    }

    @Test
    void testAddTickets() {
        ReservationBuilder builder = new ReservationBuilder();
        builder.setSourceAirportCode("JFK")
                .setDestinationAirportCode("LAX")
                .setDateTime("2024-12-25 14:00")
                .setAirline("Delta Airlines");

        builder.addTicket(new Ticket("Alice Smith", "1985-06-15", "Economy", "12B", "C", 1))
                .addTicket(new Ticket("Bob Jones", "1990-07-20", "First", "1A", "A", 2));

        Reservation reservation = builder.build();
        List<Ticket> tickets = reservation.getTickets();

        assertEquals(2, tickets.size());
        assertEquals("Alice Smith", tickets.get(0).getFullName());
        assertEquals("First", tickets.get(1).getSeatClass());
    }

    @Test
    void testCalculateTicketCostWithDecorators() {
        Ticket ticket = new Ticket("Alice Smith", "1985-06-15", "Economy", "12B", "C", 2);
        ticket = new SeatClassDecorator(ticket);
        ticket = new CheckedBagsDecorator(ticket);

        assertEquals(110.0, ticket.calculateCost()); // Economy (50) + 2 bags (30 each)
    }

    @Test
    void testAircraftAttributes() {
        Aircraft aircraft = new CommercialAircraft("Airbus A320", 30, 6);
        assertEquals("Airbus A320", aircraft.getName());
        assertEquals(30, aircraft.getNumRows());
        assertEquals(6, aircraft.getSeatsPerRow());
    }

    @Test
    void testLayoverAttributes() {
        Layover layover = new Layover("ORD", 120);
        assertEquals("ORD", layover.getAirportCode());
        assertEquals(120, layover.getDuration());
    }

    @Test
    void testTicketAttributes() {
        Ticket ticket = new Ticket("John Doe", "1980-01-01", "First", "1A", "A", 1);
        assertEquals("John Doe", ticket.getFullName());
        assertEquals("1980-01-01", ticket.getDateOfBirth());
        assertEquals("First", ticket.getSeatClass());
        assertEquals("1A", ticket.getSeatNumber());
        assertEquals("A", ticket.getBoardingClass());
        assertEquals(1, ticket.getCheckedBags());
    }

    @Test
    void testPriorityBoarding() {
        BoardingProcess boarding = new PriorityBoarding();
        Ticket ticket = new Ticket("Jane Smith", "1992-03-10", "First", "2A", "A", 0);

        boarding.board(ticket);
    }

    @Test
    void testStandardBoarding() {
        BoardingProcess boarding = new StandardBoarding();
        Ticket ticket = new Ticket("Jack Brown", "1987-11-05", "Economy", "20C", "C", 1);

        boarding.board(ticket);
    }
}
