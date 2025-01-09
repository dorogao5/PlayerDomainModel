package ru.lab.objects;

import ru.lab.characters.Croupier;
import ru.lab.characters.Persona;

public class Money {
    private int amount;

    public Money(int initialAmount) {
        this.amount = initialAmount;
    }

    public int getAmount() {
        return amount;
    }

    public void changeAmount(int value, Persona user) throws IllegalAccessException {
        if (user instanceof Croupier){
            this.amount += value;
        }
        else{
            throw new IllegalAccessException("Только Croupier может изменять количество денег.");
        }
    }


    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}

