package ru.lab.objects;

public class Voksal extends Place {

    public Voksal(String name, String description) {
        super(name, description);
    }

    @Override
    public void visit() {
        System.out.println("Exploring the vokzal: " + name);
    }
}
