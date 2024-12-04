package airlines;

public class Layover {

    /**
     * The IATA code of the airport where the layover occurs.
     */
    private String airportCode;

    /**
     * The duration of the layover in minutes.
     */
    private int duration;

    /**
     * Constructs a layover with the specified airport code and duration.
     *
     * @param airportCode the IATA code of the layover airport
     * @param duration    the duration of the layover in minutes
     */
    public Layover(String airportCode, int duration) {
        this.airportCode = airportCode;
        this.duration = duration;
    }

    /**
     * Returns the IATA code of the layover airport.
     *
     * @return the airport code
     */
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * Returns the duration of the layover in minutes.
     *
     * @return the layover duration
     */
    public int getDuration() {
        return duration;
    }
}
