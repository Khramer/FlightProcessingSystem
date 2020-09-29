package com.gridnine.testing;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>(FlightBuilder.createFlights());
        FlightFilter.removeFlightBeforNow(flights);
        FlightFilter.removeFlightBackToThePast(flights);
        FlightFilter.removeFlightOnEarthMore2Hours(flights);
    }
}
