package airlines;

public class Layover {
    private String airportCode;
    private int duration; // in minutes

    public Layover(String airportCode, int duration) {
        this.airportCode = airportCode;
        this.duration = duration;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public int getDuration() {
        return duration;
    }
}

