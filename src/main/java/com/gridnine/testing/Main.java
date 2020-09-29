package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {
        FlightFilter.removeFlightBeforNow(FlightBuilder.createFlights());
        FlightFilter.removeFlightBackToThePast(FlightBuilder.createFlights());
        FlightFilter.removeFlightOnEarthMore2Hours(FlightBuilder.createFlights());
    }
}
