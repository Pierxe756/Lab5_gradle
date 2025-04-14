package commands;

import managers.CollectionManager;
import models.StudyGroup;

import java.util.LinkedList;

public class MinByCreationDate extends Command implements Executable{
    public MinByCreationDate(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        LinkedList <StudyGroup> linkedList = CollectionManager.getCollection();
        if (linkedList.isEmpty()) {
            System.out.println("Список групп пуст!");
            return false;
        }

        StudyGroup earliestGroup = linkedList.get(0);

        for (StudyGroup group : linkedList) {
            if (group.getCreationDate().isBefore(earliestGroup.getCreationDate())) {
                earliestGroup = group;
            }
        }

        System.out.println("Группа с самой ранней датой: " + earliestGroup);
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Min_Date : вывести любой объект из коллекции с минимальным значением поля creationDate");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
    }

    @Override
    public String toString() {
        return "min_date";
    }
}
