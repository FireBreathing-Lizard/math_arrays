package main;

public class EmptyException extends ConsoleException{
    public EmptyException() {
        super("Введенное значение не может быть пустым!");
    }
}
