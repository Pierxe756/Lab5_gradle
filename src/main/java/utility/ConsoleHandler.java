package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleHandler {
    private static Scanner scanner = new Scanner(System.in);

    public ConsoleHandler() {
    }

    public static void setInput(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
    }

    public static void refreshScannerIn() {
        scanner = new Scanner(System.in);
    }

    public static String getScriptInput(){
        return scanner.nextLine().trim();
    }

    public static boolean hasNextScript() {
        return scanner.hasNextLine();
    }

    public String getUserInputString() {
        return scanner.nextLine().trim();
    }

}

