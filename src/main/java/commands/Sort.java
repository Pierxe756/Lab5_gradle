package commands;

import managers.CollectionManager;
import models.StudyGroup;

import java.util.Comparator;
import java.util.LinkedList;

public class Sort extends Command implements Executable{
    public Sort(int wordsCount){
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        LinkedList<StudyGroup> linkedList = CollectionManager.getCollection();
        if (linkedList.isEmpty()) {
            System.out.println("Коллекция пустая.");
            return false;
        }
        
        linkedList.sort(Comparator.comparing(StudyGroup::getName));

        System.out.println("Коллекция отсортирована.");
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Sort : сортировать коллекцию в естественном порядке");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        Executable.super.validateCommand(splitedConsoleRead);
    }

    @Override
    public String toString() {
        return "sort";
    }
}
