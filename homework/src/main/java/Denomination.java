public enum Denomination {
    FIFTY(50),
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    THOUSAND(1000),
    TWO_THOUSAND(2000),
    FIVE_THOUSAND(5000);

    private final int value;

    Denomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static Denomination valueOf(int value) {
        for (Denomination d : values()) {
            if (d.value == value) {
                return d;
            }
        }
        throw new IllegalArgumentException("Неверное значение : " + value);
    }
}
