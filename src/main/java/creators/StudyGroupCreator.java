package creators;
import models.Semester;
import models.StudyGroup;
import utility.ConsoleHandler;

import java.util.Scanner;

public class StudyGroupCreator {
    private static ConsoleHandler scanner = new ConsoleHandler();

    public static StudyGroup createStudyGroup(){
        System.out.println("Инициализировано создание учебной группы");
        StudyGroup studyGroup= new StudyGroup();
        studyGroup.setCoordinates(CoordinatesCreator.createCoordinates());
        studyGroup.setGroupAdmin(PersonCreator.createPerson());

        System.out.println("Введите имя");
        while (true){
            String userInput=scanner.getUserInputString();
            if(userInput.isBlank()){
                System.out.println("Имя не может быть пустым");
                continue;
            }
            studyGroup.setName(userInput);
            break;
        }
        System.out.println("Введите количество студентов");
        while (true){
            String userInput=scanner.getUserInputString();
            if (userInput.isBlank()){
                studyGroup.setStudentsCount(null);
                break;
            }
            Integer studentsCount = Integer.valueOf(userInput);
            if(studentsCount < 0){
                System.out.println("Количество должно быть больше 0");
                continue;
            }
            studyGroup.setStudentsCount(studentsCount);
            break;
        }

        System.out.println("Введите количество студентов, которых надо отчислить");
        while (true){
            String userInput=scanner.getUserInputString();
            Long shouldBeExpelled = Long.valueOf(userInput);
            if(userInput.isBlank() || shouldBeExpelled < 0){
                System.out.println("Количество не может быть пустым, должно быть больше 0");
                continue;
            }
            studyGroup.setShouldBeExpelled(shouldBeExpelled);
            break;
        }

        System.out.println("Введите количество студентов, которые перевелись");
        while (true){
            String userInput=scanner.getUserInputString();
            if (userInput.isBlank()){
                studyGroup.setStudentsCount(null);
                break;
            }
            Integer transferredStudents = Integer.valueOf(userInput);
            if(transferredStudents < 0){
                System.out.println("Количество должно быть больше 0");
                continue;
            }
            studyGroup.setTransferredStudents(transferredStudents);
            break;
        }
        System.out.println("Введите текущий семестр\n[1]-SECOND \n[2]-THIRD \n[3]-SEVENTH \n[4]-EIGHTH");
        while (true){
            String userInput=scanner.getUserInputString();
            switch (userInput){
                case ("1"):
                    studyGroup.setSemesterEnum(Semester.SECOND);
                    break;
                case ("2"):
                    studyGroup.setSemesterEnum(Semester.THIRD);
                    break;
                case ("3"):
                    studyGroup.setSemesterEnum(Semester.SEVENTH);
                    break;
                case ("4"):
                    studyGroup.setSemesterEnum(Semester.EIGHTH);
                    break;
                default:
                    System.out.println("Такого выбора нет!");
                    break;
            }
            break;
        }
    return studyGroup;
    }


}

