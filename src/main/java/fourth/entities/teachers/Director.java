package fourth.entities.teachers;

import fourth.entities.classes.Lesson;

public interface Director extends Teacher {
    void assignTeacherToLesson(Teacher teacher, Lesson lesson);
}
