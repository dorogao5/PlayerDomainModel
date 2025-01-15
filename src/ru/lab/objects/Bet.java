package ru.lab.objects;

import java.util.Objects;

public record Bet(BetType type, Money amountOfMoney) {

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

}