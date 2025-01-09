package ru.lab.characters;

import ru.lab.objects.Doors;

public class Swiss extends CasinoWorker{

    public Swiss(String name, String nationality, String post) {
        super(name, nationality, post);
    }

    public void openDoors(Doors doors){
        doors.setLocked(false);
    }

    public void closeDoors(Doors doors){
        doors.setLocked(true);
    }
}
