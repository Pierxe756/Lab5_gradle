package commands;

import exceptions.ScriptRecursionException;
import utility.ConsoleHandler;
import utility.Engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExecuteScript extends Command implements Executable{
    private final Set<String> executedFiles = new HashSet<>();
    Engine engine;

    public ExecuteScript(int wordsCount, Engine engine) {
        super(wordsCount);
        this.engine = engine;
    }

    @Override
    public void describe() {

    }

    @Override
    public boolean execute(String[] splitedConsoleRead) {
        validateCommand(splitedConsoleRead);
        File file = new File(splitedConsoleRead[1]);
        file.setReadable(true);
        if (executedFiles.contains(splitedConsoleRead[1])) {
            throw new ScriptRecursionException("Запущена защита от рекурсии : файл не должен вызывать сам себя");
        }
        executedFiles.add(splitedConsoleRead[1]);
        try {
            ConsoleHandler.setInput(file);
            while (ConsoleHandler.hasNextScript()) {
                String[] scriptLine = ConsoleHandler.getScriptInput().split(" ");
                System.out.println("\nВыполняется строка " + Arrays.toString(scriptLine));
                this.engine.getCommandManager().setUserRequest(scriptLine);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            ConsoleHandler.refreshScannerIn();
        }


        return true;
    }

    @Override
    public void validateCommand(String[] splitedConsoleRead) {
        if (splitedConsoleRead.length != this.getWordsCount()) {
            throw new IllegalArgumentException("У команды execute_script file_name 2 аргумента.");
        }
        File file = new File(splitedConsoleRead[1]);
        if (!file.exists()) {
            throw new IllegalArgumentException("Файла не существует!");
        };
    }

    @Override
    public String toString() {
        return "execute_script";
    }
}
