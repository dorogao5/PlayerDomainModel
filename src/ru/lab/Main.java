package ru.lab;

import ru.lab.characters.*;
import ru.lab.objects.*;

public class Main {
    public static void main(String[] args) {
        Swiss swiss = new Swiss("Gena", "Ukrainian", "Swiss");
        System.out.println(swiss);
        Doors doors = new Doors(true);
        System.out.println(doors);
        swiss.openDoors(doors);
        System.out.println(doors);
        GrandMother grandMother = new GrandMother("Russian", "Антонида Васильевна", new Money(10000));
        System.out.println(grandMother);
        FrenchLady frenchLady = new FrenchLady("French", "Lena", new Money(3000));
        System.out.println(frenchLady);
        YoungMan youngMan = new YoungMan("Unkown", "Unknown", new Money(5000));
        System.out.println(youngMan);
        grandMother.placeBet(BetType.PAIR, new Money(1500));
        frenchLady.placeBet(BetType.IMPAIR, new Money(130));
        youngMan.placeBet(BetType.MANQUE, new Money(1700));
        System.out.println("Player.betArrayList before: " + Player.betArrayList);
        Croupier croupier = new Croupier("Vlad", "Jewish", "glavniy");
        croupier.acceptBets(Player.betArrayList);
        System.out.println("Player.betArrayList after: " + Player.betArrayList);
        System.out.println("Croupier.finalBetArrayList before: " + croupier.getFinalBetHashMap());
        Roulette roulette = new Roulette();
        croupier.spinWheel(roulette);
        croupier.announceResult();
        croupier.payOut(roulette);
        System.out.println("Croupier.finalBetArrayList after: " + croupier.getFinalBetHashMap());
        grandMother.placeBet(BetType.ZERO, new Money(5000));
        frenchLady.placeBet(BetType.NOIR, new Money(2300));
        youngMan.placeBet(BetType.PASSE, new Money(370));
        croupier.acceptBets(Player.betArrayList);
        croupier.spinWheel(roulette, WheelField.ZERO);
        croupier.announceResult();
        croupier.payOut(roulette);
    }
}
