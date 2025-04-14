package commands;

public class Exit extends Command implements Executable {

    public Exit(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public String toString() {
        return "exit";
    }

    @Override
    public boolean execute(String[] splitedConsoleRead)  {
        System.exit(0);
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Exit : Завершение программы без сохранения файла.");

    }

    @Override
    public void validateCommand(String[] splitedConsoleRead)  {
        Executable.super.validateCommand(splitedConsoleRead);
    }
}
