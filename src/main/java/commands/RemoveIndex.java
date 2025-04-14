package commands;

import managers.CollectionManager;
import models.StudyGroup;

import java.util.LinkedList;

public class RemoveIndex extends Command implements Executable {
    public RemoveIndex(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        int index = 0;
        this.validateCommand(splitedConsoleRead);
        try {
            index = Integer.valueOf(splitedConsoleRead[1]);
        } catch (NumberFormatException e) {
            System.out.println("index должно быть числом.");
            return false;
        }

        LinkedList <StudyGroup> linkedList = CollectionManager.getCollection();

        if (linkedList.isEmpty()){
            System.out.println("Коллекция пуста!");
            return false;
        }
        try {
            linkedList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index не существует.");
            return false;
        }
        System.out.println("Объект удален");
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Remove index : удалить элемент из коллекции по его индексу");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
    }

    @Override
    public String toString() {
        return "remove_index";
    }
}
