package commands;

import managers.CollectionManager;
import models.StudyGroup;

import java.util.LinkedList;

public class ThanSholdBeExpelled extends Command implements Executable{
    public ThanSholdBeExpelled(int wordsCount){
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        int count = 0;
        this.validateCommand(splitedConsoleRead);
        try {
            count = Integer.valueOf(splitedConsoleRead[1]);
        } catch (NumberFormatException e) {
            System.out.println("count должно быть числом.");
        }

        LinkedList<StudyGroup> linkedList = CollectionManager.getCollection();
        StudyGroup groupExpelled = null;
        for (StudyGroup group : linkedList) {
            if (StudyGroup.getShouldBeExpelled() > Integer.valueOf(splitedConsoleRead[1])) {
                count++;
                break;
            }
        }
        System.out.println(count);
        return true;
    }

    @Override
    public void describe() {
        System.out.println("Count_Expelled_Than (count) : вывести количество элементов, значение поля shouldBeExpelled которых больше заданного");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
    }

    @Override
    public String toString() {
        return "count_expelled_than";
    }
}
