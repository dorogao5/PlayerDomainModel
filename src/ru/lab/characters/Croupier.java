package ru.lab.characters;

import ru.lab.objects.*;

import java.util.HashMap;
import java.util.*;

public class Croupier extends CasinoWorker {
    private WheelField resultWheelField;
    private HashMap<Persona, Bet> finalBetHashMap;
    private boolean betsAcceptedSuccessfully;

    public Croupier(String nationality, String name, String post) {
        super(name, nationality, post);
    }
    public void acceptBets(HashMap<Persona, Bet> betHashMap) {
        this.finalBetHashMap = new HashMap<>();
        betsAcceptedSuccessfully = true;
        for (HashMap.Entry<Persona, Bet> entry : betHashMap.entrySet()) {
            Persona persona = entry.getKey();
            Bet originalBet = entry.getValue();
            int betAmount = originalBet.getAmountOfMoney().getAmount();
            int playerBalance = persona.getMoney().getAmount();

            try {
                if (betAmount > playerBalance) {
                    betsAcceptedSuccessfully = false;
                    throw new IllegalArgumentException("Ошибка: Игрок " + persona.getName() + " не имеет достаточно средств для ставки. Доступно: " + playerBalance + ", требуется: " + betAmount);
                }
                Bet copiedBet = new Bet(originalBet.getType(), new Money(betAmount));
                this.finalBetHashMap.put(persona, copiedBet);
                System.out.println("Ставка игрока " + persona.getName() + " принята: " + copiedBet);
            } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка при принятии ставки игрока " + persona.getName() + ": " + e.getMessage());
            }
        }
        betHashMap.clear();
    }

    public void spinWheel(Roulette roulette) {
        if (betsAcceptedSuccessfully) {
        this.resultWheelField = roulette.generateResult();
        System.out.println("\nКрупье крутит рулетку...");
        roulette.spinAnimation();
        System.out.println("\nШарик остановился!");
        System.out.println("Результат: Сектор " + resultWheelField.getNumber());}
        else {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.resultWheelField = roulette.generateResult();
            System.out.println("\nКрупье крутит рулетку...");
            roulette.spinAnimation();
            System.out.println("\nШарик остановился!");
            System.out.println("Результат: Сектор " + resultWheelField.getNumber());
        }
    }

    public void spinWheel(Roulette roulette, WheelField wheelField) {
        if (betsAcceptedSuccessfully) {
            this.resultWheelField = wheelField;
            System.out.println("\nКрупье крутит рулетку...");
            roulette.spinAnimation();
            System.out.println("\nШарик остановился!");
            System.out.println("Результат: Сектор " + resultWheelField.getNumber());}
        else {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.resultWheelField = wheelField;
            System.out.println("\nКрупье крутит рулетку...");
            roulette.spinAnimation();
            System.out.println("\nШарик остановился!");
            System.out.println("Результат: Сектор " + resultWheelField.getNumber());
        }
    }

    public void announceResult() {
        System.out.println(resultWheelField.toString());
    }

    public void payOut(Roulette roulette) {
        HashMap<Persona, Integer> resultHashMap = roulette.calcResult(resultWheelField, finalBetHashMap);
        finalBetHashMap.clear();
        for (HashMap.Entry<Persona, Integer> entry : resultHashMap.entrySet()) {
            Persona player = entry.getKey();
            int winnings = entry.getValue();
            try {
                player.getMoney().changeAmount(winnings, this);
                System.out.println("Капитал игрока " + player.getName() + " изменился: " + (winnings > 0 ? "+" + winnings : winnings) + ". Нынешний капитал: " + player.getMoney());
            } catch (IllegalAccessException e) {
                System.err.println("Ошибка при изменении суммы для игрока " + player + ": " + e.getMessage());
            }
        }
    }

    public WheelField getResultWheelField() {
        return resultWheelField;
    }

    public void setResultWheelField(WheelField resultWheelField) {
        this.resultWheelField = resultWheelField;
    }

    public HashMap<Persona, Bet> getFinalBetHashMap() {
        return finalBetHashMap;
    }

    public void setFinalBetHashMap(HashMap<Persona, Bet> finalBetHashMap) {
        this.finalBetHashMap = finalBetHashMap;
    }
}
