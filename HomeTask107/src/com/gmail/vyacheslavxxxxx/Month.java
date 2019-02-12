package com.gmail.vyacheslavxxxxx;

public enum Month {
    JANUARY("winter", 31, "январь"), FEBRUARY("winter", 28, "февраль"), MARCH("spring", 31, "март"),
    APRIL("spring", 30, "апрель"), MAY("spring", 31, "май"), JUNE("summer", 30, "июнь"), JULY("summer", 31, "лето"),
    AUGUST("summer", 31, "август"), SEPTEMBER("autumn", 30, "сентябрь"), OCTOBER("autumn", 31, "октябрь"),
    NOVEMBER("autumn", 30, "ноябрь"), DECEMBER("winter", 31, "декабрь");
    int days;
    String season;
    String russianName;

    Month() {
    }

    Month(int days) {
        this.days = days;
    }

    Month(String season, int days, String russianName) {
        this.season = season;
        this.days = days;
        this.russianName = russianName;

    }

    public String getRussianName() {
        return russianName;
    }

    public String toStringRussian() {
        StringBuilder sb = new StringBuilder();
        for (Month month : values()) {
            sb.append(month.getRussianName()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Month month : values()) {
            sb.append(month.name()).append(" ").
               append(month.days).append(" ").
               append(month.russianName).append(" ").
               append(month.season).append("; ");
        }
        return sb.toString();
    }

    public Month next() {
        return this.ordinal() < Month.values().length - 1 ? Month.values()[this.ordinal() + 1] : null;
    }

    public Month previous() {
        return this.ordinal() == 0 ? null : Month.values()[this.ordinal() - 1];
    }

    public String season() {
        return this.season;
    }
 
}
