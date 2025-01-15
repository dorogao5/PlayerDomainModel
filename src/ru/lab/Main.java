package ru.lab;

import ru.lab.characters.*;
import ru.lab.exceptions.ImpossibleToStartGameException;
import ru.lab.objects.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создание мест
        Voksal vokzal = new Voksal("Центральный вокзал", "Место прибытия гостей");
        Hall mainHall = new Hall("Главный зал", "Зал для гостей казино");
        GamblingHall gamblingHall = new GamblingHall("Игровой зал", "Зал с игровыми столами");

        mainHall.connectPlace(vokzal);
        mainHall.connectPlace(gamblingHall);

        // Швейцар открывает двери
        Doorman doorman = new Doorman("Гена", "Швейцарец", "Отвечает за открытие и закрытие дверей");
        System.out.println(doorman);
        Doors doors = new Doors(true);
        doorman.openDoors(doors);
        System.out.println(doors);
        doorman.openDoors(doors);
        System.out.println(doors);

        // Игроки
        GrandMother grandMother = new GrandMother("Русская", "Антонида Васильевна", new Money(10000));
        FrenchLady frenchLady = new FrenchLady("Неизвестная француженка", new Money(3000));
        YoungMan youngMan = new YoungMan("Неизвестный молодой человек", "Неизвестный", new Money(5000));
        YoungMan stranger = new YoungMan("Проходимец", "Неизвестный", new Money(0));

        // Лакей рассаживает гостей
        Valet valet = new Valet("Иван", "Русский", "Отвечает за рассадку гостей");
        ArrayList<Seats> seatsList = new ArrayList<>();
        seatsList.add(new Seats("ближе к крупье"));
        seatsList.add(new Seats("подальше от крупье"));
        seatsList.add(new Seats("подальше от крупье"));

        valet.arrangeSeats(grandMother, seatsList);
        valet.arrangeSeats(frenchLady, seatsList);
        valet.arrangeSeats(youngMan, seatsList);
        valet.arrangeSeats(stranger, seatsList);

        // Создание крупье, рулетки и стола
        Croupier croupier = new Croupier("Влад", "Еврей", "Главный за Игорным столом");
        Roulette roulette = new Roulette();
        RouletteTable rouletteTable = new RouletteTable("Рулетка №1", 5, roulette);
        gamblingHall.addTable(rouletteTable);

        // Первые ставки игроков
        grandMother.placeBet(BetType.PAIR, new Money(5000));
        frenchLady.placeBet(BetType.IMPAIR, new Money(2500));
        youngMan.placeBet(BetType.MANQUE, new Money(1700));
        System.out.println("Список ставок игроков: " + Player.betArrayList);

        // Прием ставок и запуск игры
        croupier.acceptBets(Player.betArrayList);
        System.out.println("Список принятых ставок: " + croupier.getFinalBetHashMap());
        croupier.spinWheel(roulette);
        croupier.announceResult();
        croupier.payOut(roulette);

        // Второй раунд ставок
        grandMother.placeBet(BetType.ZERO, new Money(5000));
        frenchLady.placeBet(BetType.NOIR, new Money(2300));
        youngMan.placeBet(BetType.PASSE, new Money(3400));
        System.out.println("Список ставок игроков: " + Player.betArrayList);

        croupier.acceptBets(Player.betArrayList);
        System.out.println("Список принятых ставок: " + croupier.getFinalBetHashMap());
        croupier.spinWheel(roulette, WheelField.ZERO);
        croupier.announceResult();
        croupier.payOut(roulette);



    }
}
