package commands;

import creators.StudyGroupCreator;
import managers.CollectionManager;
import models.StudyGroup;
import java.util.LinkedList;

public class Update extends Command implements Executable {

    public Update( int wordsCount) {
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
        StudyGroup groupToUpdate = null;
        for (StudyGroup group : linkedList) {
            if (group.getId() == id) {
                groupToUpdate = group;
                break;
            }
        }

        if (groupToUpdate == null) {
            System.out.println("Элемент с ID " + id + " не найден.");
            return false;
        }
        StudyGroup studyGroup = StudyGroupCreator.createStudyGroup();
        linkedList.remove(groupToUpdate);
        linkedList.add(studyGroup);
        System.out.println("Элемент с ID " + id + " успешно обновлен.");
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Update id : обновить значение элемента");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        Executable.super.validateCommand(splitedConsoleRead);
    }

    @Override
    public String toString() {
        return "update";
    }
}

