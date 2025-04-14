package commands;

import managers.CollectionManager;
import models.StudyGroup;

public class Show extends Command implements Executable{
    public Show(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        if (CollectionManager.getStudyGroupList().isEmpty()){
            System.out.println("Коллекция пуста!");
            return false;
        }
        for (StudyGroup studyGroup : CollectionManager.getStudyGroupList()){
            System.out.println(studyGroup.toString());
        }
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Show : вывести в стандартный поток вывода все элементы коллекции");
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        Executable.super.validateCommand(splitedConsoleRead);
    }

    @Override
    public String toString() {
        return "show";
    }
}
