package creators;

import managers.CollectionManager;
import models.Location;
import models.Person;
import models.StudyGroup;
import utility.ConsoleHandler;

import java.util.List;
import java.util.Scanner;

public class PersonCreator {
    private static ConsoleHandler scanner = new ConsoleHandler();
    public static Person createPerson(){
        System.out.println("Инициализировано создание человека");
        Person person=new Person();
        person.setLocation(LocationCreator.createLocation());

        System.out.println("Введите имя");
        while (true) {
                String userInput = scanner.getUserInputString();
                if (userInput.isBlank()) {
                    System.out.println("Не может быть пустым");
                    continue;
                }
                person.setName(userInput);
                break;
            }
        System.out.println("Введите ID паспорта");
        while (true) {
            String userInput = scanner.getUserInputString();
            if (userInput.isBlank() || userInput.length()>20) {
                List<StudyGroup> studyGroupList = CollectionManager.getStudyGroupList();
                for (StudyGroup studyGroup : studyGroupList){
                    if (studyGroup.getGroupAdmin().getPassportID().equals(userInput)){
                        System.out.println("Id должен быть уникальным, состоять из цифр и его длина должна быть <=20");
                        continue;
                    }
                }
            }
            person.setPassportID(userInput);
            break;
        }


        return person;
    }

}
