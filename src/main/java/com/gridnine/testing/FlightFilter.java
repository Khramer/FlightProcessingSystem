package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilter {
    static void removeFlightBeforNow(List<Flight> flights){
        flights
                .stream()
                .forEach( flight -> System.out.println(flight.getSegments()
                        .stream()
                        .filter(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()))
                        .collect(Collectors.toList()))
                );
        System.out.println("\n");
    }

    static void removeFlightBackToThePast(List<Flight> flights){
        flights
                .stream()
                .forEach( flight -> System.out.println(flight.getSegments()
                        .stream()
                        .filter(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate()))
                        .collect(Collectors.toList()))
                );
        System.out.println("\n");
    }

    static void removeFlightOnEarthMore2Hours(List<Flight> flights){
        int hours = 0;

        for (int flightNumbers = 0; flightNumbers < flights.size(); flightNumbers++) {
            for (int seg = 0; seg + 1 < flights.get(flightNumbers).getSegments().size(); seg++) {
                hours += Math.abs(flights.get(flightNumbers).getSegments().get(seg).getArrivalDate().getHour()-flights.get(flightNumbers).getSegments().get(seg+1).getDepartureDate().getHour());
            }
            if ( Math.abs(hours) > 2){
                flights.remove(flightNumbers);
                flightNumbers--;
            }
            hours = 0;
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
