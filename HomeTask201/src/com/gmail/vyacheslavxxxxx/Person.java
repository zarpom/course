package com.gmail.vyacheslavxxxxx;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private Calendar dateOfBirth;

    int age() {
        Calendar now = new GregorianCalendar();

        int fullYears = (int) (now.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR));
        int daysToBirthday = now.get(Calendar.DAY_OF_YEAR) - dateOfBirth.get(Calendar.DAY_OF_YEAR);

        return daysToBirthday == 0 ? fullYears : fullYears - 1;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static void main(String[] args) {
        Person person = new Person();
        Calendar calendar = new GregorianCalendar();
        calendar.set(1996, Calendar.MARCH, 5);
        person.setDateOfBirth(calendar);
        System.out.println("person age:" + person.age());
    }
}
