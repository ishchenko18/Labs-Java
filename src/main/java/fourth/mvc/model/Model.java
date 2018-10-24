package fourth.mvc.model;

import fourth.entities.School;
import fourth.entities.classes.Class;
import fourth.entities.classes.*;
import fourth.entities.parsers.ParserUtils;
import fourth.entities.teachers.Teacher;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Model {
    private School school;
    private Properties properties;

    public Model() {
        properties = new Properties();
        initialize();
    }

    private void initialize() {
        try {
            properties.load(new FileReader("src/main/resources/fourth/application.properties"));

            school = new School(Integer.parseInt(properties.getProperty("school")));
            school.setDirector(ParserUtils.parseDirectorFile(String.format("src/main/resources/fourth/%s", properties.getProperty("director"))));
            school.setHeadTeacher(ParserUtils.parseHeadTeacherFile(String.format("src/main/resources/fourth/%s", properties.getProperty("headTeacher"))));
            school.setTeachers(ParserUtils.parseTeachersFile(String.format("src/main/resources/fourth/%s", properties.getProperty("teachers"))));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean createClass(String fileName, ClassNumber classNumber) {
        try {
            List<Learner> learners = ParserUtils.parseLearnersFile(String.format("src/main/resources/fourth/classes/%s", fileName));
            Class cl = school.getHeadTeacher().createClass(learners.toArray(new Learner[0]));

            school.getClasses().put(classNumber, cl);

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public boolean createScheduleForClass(String fileName, ClassNumber classNumber, int day) {
        Class cl = school.getClasses().get(classNumber);
        
        if(cl == null) {
            System.err.println("Class " + classNumber + " doesn't exist.");

            return false;
        }

        try {
            Lesson[] lessons = ParserUtils.parseScheduleFile(String.format("src/main/resources/fourth/schedules/%s", fileName), day)
                    .toArray(new Lesson[0]);

            DailySchedule dailySchedule = school.getHeadTeacher().createSchedule(lessons);
            cl.getDailySchedules().put(WeekDay.of(day), dailySchedule);

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public boolean assignTeacherToLesson(Teacher teacher, Lesson lesson, Class cl) {
        try {
            for (Map.Entry<WeekDay, DailySchedule> scheduleEntry : cl.getDailySchedules().entrySet()) {
                DailySchedule dailySchedule = scheduleEntry.getValue();

                dailySchedule.getLessons().stream().filter(lesson::equals).forEach(l -> l.setTeacher(teacher));
            }

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public List<Lesson> getLessonsForClass(Class cl) {
        Set<Lesson> lessons = new HashSet<>();

        for (Map.Entry<WeekDay, DailySchedule> class1 : cl.getDailySchedules().entrySet()) {
            DailySchedule dailySchedule = class1.getValue();

            dailySchedule.getLessons().forEach(l -> lessons.add(l));
        }

        return new ArrayList<>(lessons);
    }

    public int putGradeForLearner(Lesson lesson, Learner learner) {
        Teacher teacher = lesson.getTeacher();

        if(teacher == null) {
            System.err.println("Not assigned teacher for this subject.");
        } else {
            int grade = teacher.putGrade();
            learner.addGradeForLesson(lesson.getName(), grade);

            return grade;
        }

        return -1;
    }

    public School getSchool() {
        return school;
    }

    public Properties getProperties() {
        return properties;
    }
}
