package commands;

import managers.CollectionManager;
import managers.DumpManager;

import java.io.IOException;

public class Save extends Command implements Executable {
    public Save(int wordsCount) {
        super(wordsCount);
    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        try {
            DumpManager.saveCollection("collection.csv", CollectionManager.getCollection());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public void describe() {

    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        Executable.super.validateCommand(splitedConsoleRead);
    }

    @Override
    public String toString() {
        return "save";
    }
}

