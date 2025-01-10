package ru.lab.objects;

public abstract class Place {
    protected String name;
    protected String description;

    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract void visit();
}