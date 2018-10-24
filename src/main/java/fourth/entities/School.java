package fourth.entities;

import fourth.entities.classes.Class;
import fourth.entities.classes.ClassNumber;
import fourth.entities.teachers.Director;
import fourth.entities.teachers.HeadTeacher;
import fourth.entities.teachers.Teacher;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class School {
    private Integer schoolNumber;
    private Director director;
    private HeadTeacher headTeacher;
    private List<Teacher> teachers;
    private Map<ClassNumber, Class> classes;

    public School() {
        teachers = new ArrayList<>();
        classes = new EnumMap<>(ClassNumber.class);
    }

    public School(Integer schoolNumber) {
        this();
        this.schoolNumber = schoolNumber;
    }

    public Integer getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(Integer schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public HeadTeacher getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(HeadTeacher headTeacher) {
        this.headTeacher = headTeacher;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Map<ClassNumber, Class> getClasses() {
        return classes;
    }

    public void setClasses(Map<ClassNumber, Class> classes) {
        this.classes = classes;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public Teacher getTeacherByIndex(int index) {
        return teachers.get(index);
    }

    public Teacher removeTeacherByIndex(int index) {
        return teachers.remove(index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
                .append("schoolNumber", schoolNumber)
                .append("director", director)
                .append("headTeacher", headTeacher)
                .append("teachers", teachers)
                .append("classes", classes)
                .toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        School rhs = (School) obj;
        return new EqualsBuilder()
                .append(this.schoolNumber, rhs.schoolNumber)
                .append(this.director, rhs.director)
                .append(this.headTeacher, rhs.headTeacher)
                .append(this.teachers, rhs.teachers)
                .append(this.classes, rhs.classes)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(schoolNumber)
                .append(director)
                .append(headTeacher)
                .append(teachers)
                .append(classes)
                .toHashCode();
    }
}
