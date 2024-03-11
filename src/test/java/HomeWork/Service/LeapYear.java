package HomeWork.Service;

public enum LeapYear {
    ZERO(2000),
    FOUR(2004),
    EIGHT(2008),
    TWELVE(2012),
    SIXTEEN(2016),
    TWENTY(2020),
    TWENTY_FOUR(2024);

    private final int year;

    LeapYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
