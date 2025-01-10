package ru.lab.objects;

public class GameTable {
    protected String tableName;
    protected int maxPlayers;

    public GameTable(String tableName, int maxPlayers) {
        this.tableName = tableName;
        this.maxPlayers = maxPlayers;
    }

    public String getTableName() {
        return tableName;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void describe() {
        System.out.println("Game Table: " + tableName + " with max players: " + maxPlayers);
    }
}
