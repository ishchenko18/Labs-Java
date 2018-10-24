package fourth.entities.teachers;

import fourth.entities.Human;

public class TeacherImpl extends Human implements Teacher {
    public TeacherImpl() {
    }

    public TeacherImpl(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
