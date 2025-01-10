package ru.lab.objects;

import java.util.ArrayList;

public class GamblingHall extends Hall {
    private ArrayList<GameTable> tables;

    public GamblingHall(String name, String description) {
        super(name, description);
        this.tables = new ArrayList<>();
    }

    public void addTable(GameTable table) {
        tables.add(table);
    }

    public ArrayList<GameTable> getTables() {
        return tables;
    }

    @Override
    public void visit() {
        super.visit();
        System.out.println("This gambling hall has the following tables:");
        for (GameTable table : tables) {
            table.describe();
        }
    }
}