package commands;

import managers.CollectionManager;
import models.StudyGroup;

import java.util.LinkedList;

public class MaxByStudentCount extends Command implements Executable{
    public MaxByStudentCount(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        LinkedList<StudyGroup> linkedList = CollectionManager.getCollection();
        if (linkedList.isEmpty()) {
            System.out.println("Список групп пуст!");
            return false;
        }

        StudyGroup maxStudentsGroup = linkedList.get(0);

        for (StudyGroup group : linkedList) {
            if (group.getStudentsCount() > maxStudentsGroup.getStudentsCount()) {
                maxStudentsGroup = group;
            }
        }

        System.out.println("Группа с самой ранней датой: " + maxStudentsGroup);
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Max_Students : вывести любой объект из коллекции с максимальным значением поля studentsCount");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
    }

    @Override
    public String toString() {
        return "max_students";
    }
}
