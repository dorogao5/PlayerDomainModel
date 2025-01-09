package ru.lab.characters;

import ru.lab.objects.*;

import java.util.HashMap;


public class Croupier extends CasinoWorker {
    private WheelField resultWheelField;
    private HashMap<Persona, Bet> finalBetHashMap;
    public Croupier(String name, String nationality, String post) {
        super(name, nationality, post);
    }
    public void acceptBets(HashMap<Persona, Bet> betHashMap) {
        this.finalBetHashMap = new HashMap<>();
        for (HashMap.Entry<Persona, Bet> entry : betHashMap.entrySet()) {
            Persona persona = entry.getKey();
            Bet originalBet = entry.getValue();

            Bet copiedBet = new Bet(originalBet.getType(), new Money(originalBet.getAmountOfMoney().getAmount()));
            this.finalBetHashMap.put(persona, copiedBet);
        }
        betHashMap.clear();
    }
    public void spinWheel(Roulette roulette){
        this.resultWheelField = roulette.generateResult();
    }
    public void spinWheel(Roulette roulette, WheelField wheelField){
        this.resultWheelField = wheelField;
    }
    public void announceResult(){
        System.out.println(resultWheelField.toString());
    }
    public void payOut(Roulette roulette){
        HashMap<Persona, Integer> resultHashMap = roulette.calcResult(resultWheelField, finalBetHashMap);
        finalBetHashMap.clear();
        for (HashMap.Entry<Persona, Integer> entry : resultHashMap.entrySet()) {
            Persona player = entry.getKey();
            int winnings = entry.getValue();
            try {
                player.getMoney().changeAmount(winnings, this);
                System.out.println("Капитал игрока " + player.getName() + " изменился: "+ winnings + ". Нынешний капитал: " + player.getMoney());
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
