package ru.lab.objects;

public class Seats {
    private final String distanceToCroupier;
    private boolean isOccupied;

    public Seats(String distanceToCroupier) {
        this.distanceToCroupier = distanceToCroupier;
        this.isOccupied = false;
    }

    public String getDistanceToCroupier() {
        return distanceToCroupier;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}