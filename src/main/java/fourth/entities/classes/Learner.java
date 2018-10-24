package fourth.entities.classes;

import fourth.entities.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Learner extends Human {
    private final Map<String, List<Integer>> grades = new HashMap<>();

    public Learner() {

    }

    public Learner(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void addGradeForLesson(String lesson, Integer grade) {
        if (grades.containsKey(lesson)) {
            List<Integer> gradesOfLesson = grades.get(lesson);

            if (gradesOfLesson != null) {
                gradesOfLesson.add(grade);
            } else {
                grades.put(lesson, new ArrayList<Integer>() {{
                    add(grade);
                }});
            }
        } else {
            grades.put(lesson, new ArrayList<Integer>() {{
                add(grade);
            }});
        }
    }

    public List<Integer> getGradesByLesson(String lesson) {
        return grades.get(lesson);
    }
}
