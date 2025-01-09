package ru.lab.characters;

import ru.lab.objects.Money;

import java.util.Objects;

public abstract class Persona {
    private String nationality;
    private String name;
    private Money money;
    public Persona(String nationality, String name, Money money) {
        this.nationality = nationality;
        this.name = name;
        this.money = money;
    }

    public Persona(String name, String nationality) {
        this.nationality = nationality;
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nationality='" + nationality + '\'' +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(nationality, persona.nationality) && Objects.equals(name, persona.name) && Objects.equals(money, persona.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationality, name, money);
    }
}
