package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class FlightFilter {
    static void removeFlightBeforNow(List<Flight> flights){
        outer:
        for (int flightNumbers = 0; flightNumbers < flights.size(); flightNumbers++) {
            for (int seg = 0; seg < flights.get(flightNumbers).getSegments().size(); seg++) {
                if (flights.get(flightNumbers).getSegments().get(seg).getDepartureDate().isBefore(LocalDateTime.now())) {
                    flights.remove(flightNumbers);
                    continue outer;
                }
            }
        }
        flightsString(flights);
    }

    static void removeFlightBackToThePast(List<Flight> flights){
        outer:
        for (int flightNumbers = 0; flightNumbers < flights.size(); flightNumbers++) {
            for (int seg = 0; seg < flights.get(flightNumbers).getSegments().size(); seg++) {
                if (flights.get(flightNumbers).getSegments().get(seg).getDepartureDate().isAfter(flights.get(flightNumbers).getSegments().get(seg).getArrivalDate())) {
                    flights.remove(flightNumbers);
                    continue outer;
                }
            }
        }
        flightsString(flights);
    }

    static void removeFlightOnEarthMore2Hours(List<Flight> flights){
        outer:
        for (int flightNumbers = 0; flightNumbers < flights.size(); flightNumbers++) {
            for (int seg = 0; seg + 1 < flights.get(flightNumbers).getSegments().size(); seg++) {
                if (flights.get(flightNumbers).getSegments().get(seg).getArrivalDate().getHour()-flights.get(flightNumbers).getSegments().get(seg+1).getDepartureDate().getHour() > 2) {
                    flights.remove(flightNumbers);
                    continue outer;
                }
            }
        }
        flightsString(flights);
    }

    static void flightsString(List<Flight> flights){
        for (int flightNumbers = 0; flightNumbers < flights.size(); flightNumbers++) {
            System.out.println(flights.get(flightNumbers).toString());
        }
        System.out.println("\n");
    }
}
