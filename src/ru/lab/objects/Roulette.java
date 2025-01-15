package ru.lab.objects;

import ru.lab.characters.Persona;

import java.util.*;

public class Roulette {
    private final Random random = new Random();
    private final List<WheelField> fields = new ArrayList<>();

    public Roulette() {
        fields.addAll(Arrays.asList(WheelField.values()));
    }

    public WheelField generateResult() {
        int randomIndex = random.nextInt(fields.size());
        return fields.get(randomIndex);
    }

    public void spinAnimation() {
        try {
            int spinRounds = random.nextInt(10) + 20; // Количество вращений
            for (int i = 0; i < spinRounds; i++) {
                WheelField currentField = fields.get(random.nextInt(fields.size()));
                System.out.print("\rРулетка: Сектор " + currentField.getNumber() + " ");
                Thread.sleep(125 + i * 10L); // Плавное замедление
            }
            System.out.print("\r                        \r");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Ошибка анимации рулетки: " + e.getMessage());
        }
    }

    public HashMap<Persona, Integer> calcResult(WheelField resultWheelField, HashMap<Persona, Bet> finalBetHashMap) {
        HashMap<Persona, Integer> resultHashMap = new HashMap<>();

        for (Map.Entry<Persona, Bet> entry : finalBetHashMap.entrySet()) {
            Persona player = entry.getKey();
            Bet bet = entry.getValue();
            BetType betType = bet.getType();
            int betAmount = bet.getAmountOfMoney().getAmount();

            int winnings = 0; // Выигрыш или проигрыш игрока

            switch (betType) {
                case ZERO:
                    if (resultWheelField == WheelField.ZERO) {
                        winnings = betAmount * 35; // Коэффициент для ставки на 0
                    } else {
                        winnings = -betAmount;
                    }
                    break;

                case ROUGE: // Ставка на красное
                    if ("RED".equals(resultWheelField.getColor())) {
                        winnings = betAmount * 2;
                    } else {
                        winnings = -betAmount;
                    }
                    break;

                case NOIR: // Ставка на черное
                    if ("BLACK".equals(resultWheelField.getColor())) {
                        winnings = betAmount * 2;
                    } else {
                        winnings = -betAmount;
                    }
                    break;

                case PAIR: // Ставка на четное
                    if ("EVEN".equals(resultWheelField.getParity())) {
                        winnings = betAmount * 2;
                    } else {
                        winnings = -betAmount;
                    }
                    break;

                case IMPAIR: // Ставка на нечетное
                    if ("ODD".equals(resultWheelField.getParity())) {
                        winnings = betAmount * 2;
                    } else {
                        winnings = -betAmount;
                    }
                    break;

                case MANQUE: // Ставка на 1-18
                    if (resultWheelField.getNumber() >= 1 && resultWheelField.getNumber() <= 18) {
                        winnings = betAmount * 2;
                    } else {
                        winnings = -betAmount;
                    }
                    break;

                case PASSE: // Ставка на 19-36
                    if (resultWheelField.getNumber() >= 19 && resultWheelField.getNumber() <= 36) {
                        winnings = betAmount * 2;
                    } else {
                        winnings = -betAmount;
                    }
                    break;

                default:
                    winnings = -betAmount;
                    break;
            }

            resultHashMap.put(player, winnings);
        }

        return resultHashMap;
    }

}
