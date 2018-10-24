package fourth.entities.classes;

public enum WeekDay {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    public static WeekDay of(int i) {
        if(i < 1 || i > 5) {
            throw new IllegalStateException("Illegal day number.");
        }

        return WeekDay.values()[i - 1];
    }
}
