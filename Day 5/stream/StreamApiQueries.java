package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiQueries {

    public static void main(String[] args) {

        List<Owner> owners = CarRepository.getOwners();
        List<Car> cars = CarRepository.getCars();

        // Question 1 : Return the list of names of the owners currently having no cars
        List<String> ownersWithNoCars = owners.stream()
                .filter(o -> o.getCars() == null || o.getCars().isEmpty())
                .map(o -> o.getName())
                .collect(Collectors.toList());

        System.out.println("1) Owners having no cars: " + ownersWithNoCars);


        // Question 2: Create a map of name of person and number of cars
        Map<String, Long> nameToCarCount = owners.stream()
                .collect(Collectors.toMap(
                        o -> o.getName(),
                        o -> (o.getCars() == null) ? 0L : (long) o.getCars().size(),
                        (a, b) -> a,
                        () -> new HashMap<>()
                ));

        System.out.println("2) Name -> number of cars: " + nameToCarCount);


        // Question 3: List cars not owned by anyone
        Set<Car> ownedCars = owners.stream()
                .map(o -> o.getCars())
                .filter(list -> list != null)
                .flatMap(list -> list.stream())
                .collect(Collectors.toSet());

        List<Car> carsNotOwnedByAnyone = cars.stream()
                .filter(c -> !ownedCars.contains(c))
                .collect(Collectors.toList());

        System.out.println("3) Cars not owned by anyone: ");
        carsNotOwnedByAnyone.forEach(car -> System.out.println(car));
    }
}