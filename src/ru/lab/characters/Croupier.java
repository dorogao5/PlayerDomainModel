package ru.lab.characters;

import ru.lab.exceptions.ImpossibleToStartGameException;
import ru.lab.objects.*;

import java.util.HashMap;

public class Croupier extends CasinoWorker {
    private WheelField resultWheelField;
    private HashMap<Persona, Bet> finalBetHashMap;
    private boolean betsAcceptedSuccessfully;
    private boolean gameStarted = true;

    public Croupier(String nationality, String name, String post) {
        super(name, nationality, post);
    }

    public void acceptBets(HashMap<Persona, Bet> betHashMap) {
        this.finalBetHashMap = new HashMap<>();
        betsAcceptedSuccessfully = true;
        for (HashMap.Entry<Persona, Bet> entry : betHashMap.entrySet()) {
            Persona persona = entry.getKey();
            Bet originalBet = entry.getValue();
            int betAmount = originalBet.amountOfMoney().getAmount();
            int playerBalance = persona.getMoney().getAmount();

            try {
                if (betAmount > playerBalance || betAmount < 0) {
                    betsAcceptedSuccessfully = false;
                    throw new IllegalArgumentException("Ошибка: Игрок " + persona.getName() + " не имеет достаточно средств для ставки. Доступно: " + playerBalance + ", требуется: " + betAmount);
                }
                Bet copiedBet = new Bet(originalBet.type(), new Money(betAmount));
                this.finalBetHashMap.put(persona, copiedBet);
                System.out.println("Ставка игрока " + persona.getName() + " принята: " + copiedBet);
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка при принятии ставки игрока " + persona.getName() + ": " + e.getMessage());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                betsAcceptedSuccessfully = true;
            }
        }
        betHashMap.clear();
    }

    public void spinWheel(Roulette roulette) {
        while (!betsAcceptedSuccessfully) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            if (finalBetHashMap.isEmpty()) {
                gameStarted = false;
                throw new ImpossibleToStartGameException();

            }else{
                gameStarted = true;
                this.resultWheelField = roulette.generateResult();
                System.out.println("\nКрупье крутит рулетку...");
                roulette.spinAnimation();
                System.out.println("\nШарик остановился!");
                System.out.println("Результат: Сектор " + resultWheelField.getNumber());
            }

        } catch (ImpossibleToStartGameException e) {
            System.out.println(e.getMessage());
        }

    }

    public void spinWheel(Roulette roulette, WheelField wheelField) {
        while (!betsAcceptedSuccessfully) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            if (finalBetHashMap.isEmpty()) {
                gameStarted = false;
                throw new ImpossibleToStartGameException();

            }else{
                gameStarted = true;
                this.resultWheelField = wheelField;
                System.out.println("\nКрупье крутит рулетку...");
                roulette.spinAnimation();
                System.out.println("\nШарик остановился!");
                System.out.println("Результат: Сектор " + resultWheelField.getNumber());
            }

        } catch (ImpossibleToStartGameException e) {
            System.out.println(e.getMessage());
        }
    }

    public void announceResult() {
        if (!gameStarted) {
            System.out.println("Игра не была начата. Результаты отсутствуют.");
            return;
        }
        System.out.println(resultWheelField.toString());
    }

    public void payOut(Roulette roulette) {
        if (!gameStarted) {
            System.out.println("Игра не была начата. Выплаты отменены.");
            return;
        }

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
