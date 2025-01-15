package ru.lab.characters;

import ru.lab.objects.Bet;
import ru.lab.objects.BetType;
import ru.lab.objects.Money;

import java.util.HashMap;

public interface Player {
    HashMap<Persona, Bet> betArrayList = new HashMap<>();
    default void placeBet(BetType type, Money amountOfMoney) {
        Persona self = (Persona) this;
        betArrayList.put(self, new Bet(type, amountOfMoney));
    }

}
