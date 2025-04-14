import commands.*;
import managers.CommandManager;

import java.util.HashMap;
import java.util.Scanner;

import models.Coordinates;
import utility.Engine;

import static creators.CoordinatesCreator.createCoordinates;

public class Main {
    public static void main(String[] args) {

        try {
            Engine engine = new Engine(args);
            engine.runProgramm();
        } catch (Exception e) {
            Engine engine = new Engine("collection.csv".split(" "));
            engine.runProgramm();;
        }

    }
}
