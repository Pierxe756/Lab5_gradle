package utility;

import commands.*;
import managers.CollectionManager;
import managers.CommandManager;
import managers.DumpManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Engine {
    String filepath;
    private Scanner scanner = new Scanner(System.in);
    private CommandManager commandManager;

    public Engine(String[] filepath) {
        this.filepath = filepath[0];
    }

    public void runProgramm() {
        this.commandManager = new CommandManager(new HashMap<String, Executable>());
        commandManager.setUpCommand(new Exit(1));
        commandManager.setUpCommand(new Help(1, commandManager));
        commandManager.setUpCommand(new Info(1));
        commandManager.setUpCommand(new Add(1));
        commandManager.setUpCommand(new Show(1));
        commandManager.setUpCommand(new Update(1));
        commandManager.setUpCommand(new Remove(1));
        commandManager.setUpCommand(new Clear(1));
        commandManager.setUpCommand(new RemoveIndex(1));
        commandManager.setUpCommand(new AddIfMin(1));
        commandManager.setUpCommand(new Sort(1));
        commandManager.setUpCommand(new MinByCreationDate(1));
        commandManager.setUpCommand(new MaxByStudentCount(1));
        commandManager.setUpCommand(new ThanSholdBeExpelled(1));
        commandManager.setUpCommand(new ExecuteScript(2, this));
        commandManager.setUpCommand(new Save(1));

        try {
            CollectionManager.setStudyGroupList(DumpManager.loadCollection(filepath));
        } catch (IOException e) {
            System.out.println("Возникла ошибка при считывании коллекции!");;
        }

        while (scanner.hasNextLine()) {
            try {
                commandManager.setUserRequest(scanner.nextLine().trim().split(" "));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                ;
            }
        }
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}

