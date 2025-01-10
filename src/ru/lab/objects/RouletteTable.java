package ru.lab.objects;

public class RouletteTable extends GameTable {
    private final int wheelNumber;

    public RouletteTable(String tableName, int maxPlayers, int wheelNumber) {
        super(tableName, maxPlayers);
        this.wheelNumber = wheelNumber;
    }

    public int getWheelNumber() {
        return wheelNumber;
    }

    @Override
    public void describe() {
        System.out.println("Roulette Table: " + tableName + " with wheel number: " + wheelNumber);
    }
}