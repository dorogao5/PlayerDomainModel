package ru.lab.objects;

public class RouletteTable extends GameTable {

    Roulette roulette;

    public RouletteTable(String tableName, int maxPlayers, Roulette roulette) {
        super(tableName, maxPlayers);
        this.roulette = roulette;
    }

    public Roulette getRoulette() {
        return roulette;
    }

    public void setRoulette(Roulette roulette) {
        this.roulette = roulette;
    }

    @Override
    public void describe() {
        System.out.println("Roulette Table: " + tableName);
    }
}