package fourth.entities.teachers;

public interface Teacher {
    default int putGrade() {
        return (int) (Math.random() * 12 + 1);
    }
}
