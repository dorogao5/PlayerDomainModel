package ru.lab.characters;

import ru.lab.objects.Seats;

import java.util.ArrayList;

public class Valet extends CasinoWorker {

    public Valet(String name, String nationality, String post) {
        super(name, nationality, post);
    }

    public void arrangeSeats(Persona persona, ArrayList<Seats> seatsArrayList) {
        for (Seats seat : seatsArrayList) {
            if (!seat.isOccupied()) {
                seat.setOccupied(true);
                System.out.println(persona.getName() + " был(а) посажен(а) " + seat.getDistanceToCroupier());
                return;
            }
        }
        System.out.println("Нет свободных мест для " + persona.getName());
    }
}