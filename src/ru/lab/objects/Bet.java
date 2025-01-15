package ru.lab.objects;

import ru.lab.characters.Persona;

import java.util.Objects;

public class Bet {

    private final BetType type;
    private final Money amountOfMoney;

    public Bet(BetType type, Money amountOfMoney) {
        this.type = type;
        this.amountOfMoney = amountOfMoney;
    }


    public BetType getType() {
        return type;
    }

    public Money getAmountOfMoney() {
        return amountOfMoney;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "type=" + type +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bet bet)) return false;
        return type == bet.type && Objects.equals(amountOfMoney, bet.amountOfMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amountOfMoney);
    }
}