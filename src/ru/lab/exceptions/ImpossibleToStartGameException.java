package ru.lab.exceptions;

public class ImpossibleToStartGameException extends Exception {
    public ImpossibleToStartGameException() {
        super("Невозможно начать игру: отсутствуют принятые ставки.");
    }

    public ImpossibleToStartGameException(String message) {
        super(message);
    }
}
