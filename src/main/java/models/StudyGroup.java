package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import managers.CollectionManager;
import managers.PersonDeserializer;
import managers.PersonSerializer;
import managers.SemesterDeserializer;

import java.time.ZonedDateTime;
import java.util.LinkedList;

public class StudyGroup implements Comparable{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    private String name; //Поле не может быть null, Строка не может быть пустой
    @JsonUnwrapped(prefix = "coordinates_")
    private Coordinates coordinates; //Поле не может быть null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer studentsCount; //Значение поля должно быть больше 0, Поле может быть null
    private Long shouldBeExpelled; //Значение поля должно быть больше 0, Поле не может быть null
    private Integer transferredStudents; //Значение поля должно быть больше 0, Поле может быть null
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    @JsonSetter(nulls = Nulls.SKIP) // Пропускать null
    @JsonDeserialize(using = SemesterDeserializer.class)
    private Semester semesterEnum; //Поле может быть null
    @JsonSerialize(using = PersonSerializer.class)
    @JsonDeserialize(using = PersonDeserializer.class)
    private Person groupAdmin; //Поле может быть null

    public StudyGroup() {
        this.creationDate = ZonedDateTime.now();
        LinkedList<StudyGroup> linkedList = CollectionManager.getCollection();
        if (linkedList != null) {
            int maxId = 0;
            for (StudyGroup group : linkedList) {
                if (group.getId() > maxId) {
                    maxId = group.getId();
                }
            }
            this.id = maxId + 1;
        } else {
            this.id = 1;
        }
    }



    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Integer getTransferredStudents() {
        return transferredStudents;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setShouldBeExpelled(Long shouldBeExpelled) {
        this.shouldBeExpelled = shouldBeExpelled;
    }

    public void setTransferredStudents(Integer transferredStudents) {
        this.transferredStudents = transferredStudents;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", studentsCount=" + studentsCount +
                ", shouldBeExpelled=" + shouldBeExpelled +
                ", transferredStudents=" + transferredStudents +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public Long getShouldBeExpelled() {
        return shouldBeExpelled;
    }
}
