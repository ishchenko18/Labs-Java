package fourth.entities.teachers;

import fourth.entities.*;
import fourth.entities.classes.Class;
import fourth.entities.classes.DailySchedule;
import fourth.entities.classes.Learner;
import fourth.entities.classes.Lesson;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HeadTeacherImpl extends Human implements HeadTeacher {
    public HeadTeacherImpl() {
    }

    public HeadTeacherImpl(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public Class createClass(Learner... learners) {
        Class cl = new Class();
        cl.setLearners(Arrays.stream(learners).collect(Collectors.toList()));

        return cl;
    }

    @Override
    public DailySchedule createSchedule(Lesson... lessons) {
        DailySchedule dailySchedule = new DailySchedule();

        Arrays.stream(lessons).forEach(dailySchedule::addLesson);

        return dailySchedule;
    }
}
