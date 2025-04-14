package commands;

import managers.CollectionManager;
import models.StudyGroup;

import java.util.LinkedList;

public class Clear extends Command implements Executable{
    public Clear(int wordsCount){
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        LinkedList<StudyGroup> linkedList = CollectionManager.getCollection();
        if (CollectionManager.getStudyGroupList().isEmpty()){
            System.out.println("Коллекция уже пуста!");
            return false;
        }
        CollectionManager.setStudyGroupList(new LinkedList<StudyGroup>());
        System.out.println("Коллекция успешно очищена.");
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Clear : очистить коллекцию");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        Executable.super.validateCommand(splitedConsoleRead);
    }

    @Override
    public String toString() {
        return "clear";
    }
}
