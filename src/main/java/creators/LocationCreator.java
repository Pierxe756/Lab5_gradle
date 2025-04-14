package creators;

import models.Coordinates;
import models.Location;
import utility.ConsoleHandler;

import java.util.Scanner;

public class LocationCreator {
    private static ConsoleHandler scanner = new ConsoleHandler();

    public static Location createLocation() {
        System.out.println("Инициализировано создание локации");
        Location location = new Location();
        System.out.println("Введите координату x. Значение должно быть больше -901");

        while (true) {
            try {
                String userInput = scanner.getUserInputString();
                double x = Double.valueOf(userInput);
                location.setX(x);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Попробуйте снова");
            }
        }

        System.out.println("Введите координату y");
        while (true) {
            try {
                String userInput = scanner.getUserInputString();
                Float newY = Float.valueOf(userInput);
                location.setY(newY);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Попробуйте снова");
            }
        }

        System.out.println("Введите координату z");
        while (true) {
            try {
                String userInput = scanner.getUserInputString();
                long z = Long.valueOf(userInput);
                location.setZ(z);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Попробуйте снова");
            }
        }

        System.out.println("Введите название локации");
        while (true){
            String userInput=scanner.getUserInputString();
            if(userInput.isBlank()){
                System.out.println("Имя не может быть пустым");
                continue;
            }
            location.setName(userInput);
            break;
        }


        return location;
    }
}
