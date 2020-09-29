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

        for (Flight flightNumbers : flights) {
            for (int seg = 0; seg+1 < flightNumbers.getSegments().size(); seg++) {
                hours += Math.abs(flightNumbers.getSegments().get(seg).getArrivalDate().getHour()-flightNumbers.getSegments().get(seg+1).getDepartureDate().getHour());

            }
            if ( Math.abs(hours) <= 2){
                System.out.println(flightNumbers.getSegments().toString());
            }
            hours = 0;
        }
    }
}
