package commands;

import managers.CollectionManager;

public class Info extends Command implements Executable{
    public Info(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        System.out.println("Информация о коллекции : \n" +
                "Тип :"+
                CollectionManager.getStudyGroupList().getClass().getName()+
                "\nКоличество элементов : "+ CollectionManager.getStudyGroupList().size());
        return false;
    }

    @Override
    public void describe() {
        System.out.println("Info : выводит информацию о коллекции");

    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        Executable.super.validateCommand(splitedConsoleRead);
    }

    @Override
    public String toString() {
        return "info";
    }
}
