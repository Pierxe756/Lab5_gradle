package commands;

import managers.CollectionManager;
import models.StudyGroup;

import java.util.LinkedList;

public class Remove extends Command implements Executable{
    public Remove(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        int id = 0;
        this.validateCommand(splitedConsoleRead);
        try {
            id = Integer.valueOf(splitedConsoleRead[1]);
        } catch (NumberFormatException e) {
            System.out.println("id должно быть числом.");
        }

        LinkedList <StudyGroup> linkedList = CollectionManager.getCollection();
        StudyGroup groupToRemove = null;
        for (StudyGroup group : linkedList) {
            if (group.getId() == id) {
                groupToRemove = group;
                break;
            }
        }

        if (groupToRemove == null) {
            System.out.println("Элемент с ID " + id + " не найден.");
            return false;
        }

        linkedList.remove(groupToRemove);
        System.out.println("Элемент с ID " + id + " успешно удалён.");
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Remove id : удалить элемент из коллекции по его id");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {

    }

    @Override
    public String toString() {
        return "remove_id";
    }
}
