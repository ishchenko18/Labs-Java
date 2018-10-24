package fourth.entities.teachers;

import fourth.entities.classes.Class;
import fourth.entities.classes.DailySchedule;
import fourth.entities.classes.Learner;
import fourth.entities.classes.Lesson;

public interface HeadTeacher extends Teacher {
    Class createClass(Learner... learners);
    DailySchedule createSchedule(Lesson... lessons);
}
