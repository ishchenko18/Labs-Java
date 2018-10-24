package fourth.entities.teachers;

import fourth.entities.Human;
import fourth.entities.classes.Lesson;

public class DirectorImpl extends Human implements Director {

    public DirectorImpl() {

    }

    public DirectorImpl(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void assignTeacherToLesson(Teacher teacher, Lesson lesson) {
        lesson.setTeacher(teacher);
    }
}
