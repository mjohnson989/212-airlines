import aircraft.Aircraft;
import aircraft.CommercialAircraft;
import airlines.Layover;
import builder.Reservation;
import builder.ReservationBuilder;
import decorator.CheckedBagsDecorator;
import decorator.SeatClassDecorator;
import decorator.Ticket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationBuilder reservationBuilder = new ReservationBuilder();

        System.out.println("Welcome to the Airline Reservation System!");

        System.out.print("Enter source airport code: ");
        String source = scanner.nextLine();

        System.out.print("Enter destination airport code: ");
        String destination = scanner.nextLine();

        System.out.print("Enter flight date and time (e.g., 2024-12-25 14:00): ");
        String dateTime = scanner.nextLine();

        reservationBuilder.setDateTime(dateTime);


        System.out.print("Enter aircraft name: ");
        String aircraftName = scanner.nextLine();

        System.out.print("Enter number of rows: ");
        int numRows = scanner.nextInt();

        System.out.print("Enter seats per row: ");
        int seatsPerRow = scanner.nextInt();
        scanner.nextLine();

        Aircraft aircraft = new CommercialAircraft(aircraftName, numRows, seatsPerRow);
        reservationBuilder.setAircraft(aircraft);
        System.out.print("How many layovers are in this flight? ");
        int layoverCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < layoverCount; i++) {
            System.out.print("Enter layover " + (i + 1) + " airport code: ");
            String airportCode = scanner.nextLine();

            System.out.print("Enter layover duration in minutes: ");
            int duration = scanner.nextInt();
            scanner.nextLine();

            Layover layover = new Layover(airportCode, duration);
            reservationBuilder.addLayover(layover);
        }


        System.out.print("How many tickets are you booking? ");
        int ticketCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < ticketCount; i++) {
            System.out.println("Ticket " + (i + 1) + ":");
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter date of birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();

            System.out.print("Enter seat class (First, Comfort, Economy): ");
            String seatClass = scanner.nextLine();

            System.out.print("Enter seat number (e.g., 15A): ");
            String seatNumber = scanner.nextLine();

            System.out.print("Enter boarding class (e.g., A, B, C): ");
            String boardingClass = scanner.nextLine();

            System.out.print("Enter number of checked bags: ");
            int checkedBags = scanner.nextInt();
            scanner.nextLine();



            Ticket ticket = new Ticket(fullName, dob, seatClass, seatNumber, boardingClass, checkedBags);
            ticket = new SeatClassDecorator(ticket);
            ticket = new CheckedBagsDecorator(ticket);

            reservationBuilder.addTicket(ticket);
        }


        Reservation reservation = reservationBuilder.build();



        System.out.println("\nReservation Summary:");
        System.out.println("Flight: " + source + " -> " + destination);
        System.out.println("Date and Time: " + dateTime);
        System.out.println("Aircraft: " + aircraft.getName() + " (" + aircraft.getNumRows() + " rows, " + aircraft.getSeatsPerRow() + " seats per row)");
        System.out.println("Layovers:");
        for (Layover layover : reservation.getLayovers()) {
            System.out.println("  - " + layover.getAirportCode() + " (" + layover.getDuration() + " minutes)");
        }
        System.out.println("Tickets:");
        for (int i = 0; i < reservation.getTickets().size(); i++) {
            Ticket ticket = reservation.getTickets().get(i);
            System.out.println("  Ticket " + (i + 1) + ": " + ticket.getFullName());
            System.out.println("    Seat Class: " + ticket.getSeatClass());
            System.out.println("    Seat Number: " + ticket.getSeatNumber());
            System.out.println("    Boarding Class: " + ticket.getBoardingClass());
            System.out.println("    Checked Bags: " + ticket.getCheckedBags());
            System.out.println("    Cost: $" + ticket.calculateCost());
        }
        System.out.println("Total Cost: $" + reservation.getTotalCost());

        System.out.println("\nThank you for using the Airline Reservation System!");
        scanner.close();
    }
}
