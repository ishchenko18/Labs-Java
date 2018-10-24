package fourth.mvc.controller;

import fourth.entities.classes.Class;
import fourth.entities.classes.*;
import fourth.entities.teachers.Teacher;
import fourth.mvc.model.Model;
import fourth.mvc.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {
    private Model model;
    private View view;
    private Scanner scanner;

    public Controller() {
        this.model = new Model();
        this.view = new View();
        this.scanner = new Scanner(System.in);
    }

    private void printInfoDev() {
        view.printString("Developer: Vladyslav Ishchenko\n");
        view.printString("Group: IS-63\n");
    }

    public void createClass() {
        view.printString("----------CREATING OF CLASS----------\n");
        view.printString("Head Teacher: " + model.getSchool().getHeadTeacher() + "\n\n");

        ClassNumber cn = getClassNumber();

        boolean response = model.createClass(String.format("class%d.csv", ClassNumber.valueOf(cn.toString()).ordinal() + 1), cn);

        if (response) {
            view.printString("\n----Created class----\n");
            view.printString(model.getSchool().getClasses().get(cn).toString() + "\n\n");
        }
    }

    public void createSchedule() {
        view.printString("----------CREATING OF SCHEDULE----------\n\n");
        view.printString("Head Teacher: " + model.getSchool().getHeadTeacher() + "\n");

        ClassNumber cn = getClassNumber();
        int day = getDayOFWeek();

        boolean response = model.createScheduleForClass(String.format("schedule%d.csv", ClassNumber.valueOf(cn.toString()).ordinal() + 1), cn, day);

        if (response) {
            System.out.println(model.getSchool().getClasses().get(cn).getDailySchedules().get(WeekDay.of(day)) + "\n\n");
        }
    }

    public void putGrade() {
        view.printString("----------PUTTING GRADES----------\n\n");

        ClassNumber classNumber = getClassNumber();
        Class cl = model.getSchool().getClasses().get(classNumber);

        if (cl != null) {
            int day = getDayOFWeek();

            System.out.println(day);
            if (day > 0 && day < 5) {
                List<Lesson> lessons = cl.getDailySchedules()
                        .get(WeekDay.of(day))
                        .getLessons();

                view.printString("\n------Choose lesson------\n");
                view.printChooseList(lessons);

                int numberLesson = getEnteredNumber();

                if (numberLesson <= lessons.size()) {
                    Lesson lesson = lessons.get(numberLesson - 1);
                    List<Learner> learners = cl.getLearners();

                    view.printString("\n------Choose learner------\n");
                    view.printChooseList(learners);

                    int numberLearner = getEnteredNumber();

                    if (numberLearner <= learners.size()) {
                        Learner learner = learners.get(numberLearner - 1);

                        int puttedGrade = model.putGradeForLearner(lesson, learner);

                        if (puttedGrade > 0) {
                            view.printString("\nGrade putted: ");
                            view.printString("\nLearner: " + learner);
                            view.printString("\nLesson: " + lesson);
                            view.printString("\nGrade: " + puttedGrade + "\n");
                        }
                    } else {
                        System.err.println("You entered wrong number of learner.");
                    }
                } else {
                    System.err.println("You entered wrong lesson number.");
                }
            } else {
                System.err.println("Such day isn't week or schedule doesn't exist.");
            }
        } else {
            System.err.println("Class " + classNumber + " isn't created.");
        }
    }

    public void assingTeacherToSubject() {
        view.printString("----------ASSIGN TEACHER----------\n\n");

        ClassNumber classNumber = getClassNumber();
        Class cl = model.getSchool().getClasses().get(classNumber);

        if (cl != null) {
            List<Lesson> lessons = model.getLessonsForClass(cl);

            view.printString("\n------Choose lesson------\n");
            view.printChooseList(lessons);

            int numberLesson = getEnteredNumber();

            if (numberLesson <= lessons.size()) {
                Lesson lesson = lessons.get(numberLesson - 1);

                List<Teacher> teachers = model.getSchool().getTeachers();

                view.printString("\n------Choose teacher------\n");
                view.printChooseList(teachers);

                int numberTeacher = getEnteredNumber();

                if (numberTeacher <= teachers.size()) {
                    Teacher teacher = teachers.get(numberTeacher - 1);

                    boolean response = model.assignTeacherToLesson(teacher, lesson, cl);

                    if(response) {
                        view.printString("\nTeacher assigned: ");
                        view.printString("\nTeacher: " + teacher);
                        view.printString("\nClass: " + classNumber);
                        view.printString("\nLesson: " + lesson + "\n");
                    }
                } else {
                    System.err.println("You entered wrong number of learner.");
                }
            } else {
                System.err.println("You entered wrong lesson number.");
            }
        } else {
            System.err.println("Class " + classNumber + " isn't created.");
        }
    }

    public void doTask() {
        int choose;
        printInfoDev();
        view.printString("\n\n");

        do {
            view.printString("----------TASKS----------\n");
            view.printString("1 - Create Class\n");
            view.printString("2 - Create Schedule\n");
            view.printString("3 - Put Grade\n");
            view.printString("4 - Assign Teacher To Subject\n");
            view.printString("5 - Exit\n");
            choose = getEnteredNumber();

            switch (choose) {
                case 1:
                    createClass();
                    break;
                case 2:
                    createSchedule();
                    break;
                case 3:
                    putGrade();
                    break;
                case 4:
                    assingTeacherToSubject();
                    break;
                case 5:
                    break;
                default:
                    view.printString("Such task doesn't exist! You can try again:)");
            }
        } while (choose != 5);
    }

    private ClassNumber getClassNumber() {
        List<ClassNumber> classNumbers = Arrays.stream(model.getProperties().getProperty("classes").split(","))
                .map(Integer::new)
                .map(ClassNumber::of)
                .collect(Collectors.toList());

        view.printString("------Choose class------\n");
        view.printChooseList(classNumbers);

        return classNumbers.get(getEnteredNumber() - 1);
    }

    private int getDayOFWeek() {
        view.printString("------Choose day of week------\n");
        view.printChooseList(Arrays.asList(WeekDay.values()));

        return getEnteredNumber();
    }


    private int getEnteredNumber() {
        view.printString("Enter number: ");
        return scanner.nextInt();
    }
}
