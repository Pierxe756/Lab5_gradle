package commands;

import creators.StudyGroupCreator;
import managers.CollectionManager;

public class Add extends Command implements Executable{

    public Add(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        CollectionManager.addStudyGroup(StudyGroupCreator.createStudyGroup());
        System.out.println("Элемент добавлен!");
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Add : добавить элемент в коллекцию");

    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        Executable.super.validateCommand(splitedConsoleRead);
    }

    @Override
    public String toString() {
        return "add";
    }
}
