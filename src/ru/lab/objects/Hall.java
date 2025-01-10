package ru.lab.objects;

import java.util.ArrayList;

public class Hall extends Place {
    private final ArrayList<Place> connectedPlaces;

    public Hall(String name, String description) {
        super(name, description);
        this.connectedPlaces = new ArrayList<>();
    }

    public void connectPlace(Place place) {
        connectedPlaces.add(place);
    }

    public ArrayList<Place> getConnectedPlaces() {
        return connectedPlaces;
    }

    @Override
    public void visit() {
        System.out.println("You are in the hall: " + name);
        System.out.println("Connected places:");
        for (Place place : connectedPlaces) {
            System.out.println("- " + place.getName());
        }
    }
}