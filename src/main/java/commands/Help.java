package commands;


import managers.CommandManager;

public class Help extends Command implements Executable{
    private CommandManager cm;

    public Help(int wordsCount,CommandManager commandManager) {
        super(wordsCount);
        this.cm=commandManager;
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        for (Executable command : this.cm.getCommands().values()){
            command.describe();
        }
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Help : Выводит список команд и информацию о них");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        Executable.super.validateCommand(splitedConsoleRead);
    }

    @Override
    public String toString() {
        return "help";
    }
}
