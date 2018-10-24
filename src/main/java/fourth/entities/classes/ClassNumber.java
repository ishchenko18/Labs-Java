package fourth.entities.classes;

public enum  ClassNumber {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    SIXTH,
    SEVENTH,
    EIGHTH,
    NINTH,
    TENTH,
    ELEVENTH;

    public static ClassNumber of(int i) {
        if(i < 1 || i > 11) {
            throw new IllegalStateException("Illegal class number.");
        }

        return ClassNumber.values()[i - 1];
    }
}
