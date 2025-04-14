package commands;


public interface Executable {
    default boolean execute(String[] splitedConsoleRead) {
        System.out.println("Команда выполнена?");
        return false;
    }

    void describe();

    default void validateCommand(String[] splitedConsoleRead)  {
        System.out.println("Проверка пройдена?");
    }
}
