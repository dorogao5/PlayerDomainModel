package ru.lab.characters;

import ru.lab.objects.Seats;
import ru.lab.objects.GameTable;

import java.util.ArrayList;

public class Valet extends CasinoWorker {

    public Valet(String name, String nationality, String post) {
        super(name, nationality, post);
    }

    public void arrangeSeats(Persona persona, ArrayList<Seats> seatsArrayList) {
        for (Seats seat : seatsArrayList) {
            if (!seat.isOccupied()) {
                seat.setOccupied(true);
                System.out.println(persona.getName() + " has been seated at a seat with distance: " + seat.getDistanceToCroupier());
                return;
            }
        }
        System.out.println("No available seats for " + persona.getName());
    }
}