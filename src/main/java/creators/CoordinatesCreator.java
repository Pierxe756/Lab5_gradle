package creators;

import models.Coordinates;
import utility.ConsoleHandler;

public class CoordinatesCreator {
    private static ConsoleHandler scanner = new ConsoleHandler();

    public static Coordinates createCoordinates() {
        System.out.println("Инициализировано создание координат");
        Coordinates coordinates = new Coordinates();
        System.out.println("Введите координтау x. Значение должно быть больше -901");

        while (true) {
            try {
                String userInput = scanner.getUserInputString();
                int x = Integer.valueOf(userInput);
                if (x <= -901) {
                    System.out.println("Значение должно быть больше -901");
                    continue;
                }
                coordinates.setX(x);
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
                coordinates.setY(newY);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Попробуйте снова");
            }
        }
        return coordinates;
    }
}
