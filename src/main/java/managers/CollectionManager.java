package managers;

import models.StudyGroup;

import java.util.LinkedList;
import java.util.List;

public class CollectionManager {
    private static LinkedList<StudyGroup> studyGroupList = new LinkedList<>();

    public static LinkedList<StudyGroup> getStudyGroupList() {
        return studyGroupList;
    }

    public static void addStudyGroup(StudyGroup studyGroup) {
        studyGroupList.add(studyGroup);
    }

    public static LinkedList<StudyGroup> getCollection() {
        return studyGroupList;
    }
}
