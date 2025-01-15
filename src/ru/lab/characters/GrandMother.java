package ru.lab.characters;


import ru.lab.objects.Money;

public class GrandMother extends Persona implements Player {
    public GrandMother(String nationality, String name, Money money) {
        super(nationality, name, money);
    }
    public void leaveHall(){
        System.out.println();
    }

}
