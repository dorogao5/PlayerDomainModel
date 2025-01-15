package ru.lab.objects;

public class Doors {
    private boolean isLocked;

    public Doors(boolean isLocked) {
        this.isLocked = isLocked;
    }

    @Override
    public String toString() {
        return "Doors{" +
                "isLocked=" + isLocked +
                '}';
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
