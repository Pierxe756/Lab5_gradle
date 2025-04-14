package commands;


import creators.StudyGroupCreator;
import managers.CollectionManager;
import models.StudyGroup;

import java.util.LinkedList;

public class AddIfMin extends Command implements Executable{
    public AddIfMin(int wordsCount){
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        LinkedList <StudyGroup> linkedList = CollectionManager.getCollection();
        StudyGroup newGroup = StudyGroupCreator.createStudyGroup();

        if (linkedList.isEmpty()){
            System.out.println("Коллекция добавлена.");
            return linkedList.add(newGroup);
        }
        boolean isMin = true;
        for (StudyGroup existingGroup : linkedList) {
            if (newGroup.compareTo(existingGroup) >= 0) {
                isMin = false;
                System.out.println("Коллекция не является минимальной" +
                        existingGroup.getName());
                break;
            }
        }

        if (isMin) {
            System.out.println("Коллекция добавлена");
            return linkedList.add(newGroup);
        } else {
            System.out.println("Группа " + newGroup.getName() +
                    " не добавлена в коллекцию");
            return false;
        }
    }



    @Override
    public void describe() {
        System.out.println("Add_if_min : добавить элемент, если его значение меньше, чем у наименьшего элемента этой коллекции");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        Executable.super.validateCommand(splitedConsoleRead);
    }

    @Override
    public String toString() {
        return "add_if_min";
    }
}
