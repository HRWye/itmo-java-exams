package fitness;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HolderOfSubscription {

    //задаем приватные переменные свойств держателя абонемента:
    private String name;
    private String surname;
    private LocalDate dayOfBirth;

    //задаем сеттеры и геттеры
    public void setName(String name) {
        if (name==null||name.length()<=2){throw new IllegalArgumentException("Имя должно содержать более 2-ух символов");}
        this.name = name;
    }
    public void setSurname(String surname) {
        if (surname==null||surname.length()<=2){throw new IllegalArgumentException("Фамилия должна содержать более 2-ух символов");}
        this.surname = surname;
    }
    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(String dayOfBirthToParse) {
        if (ChronoUnit.YEARS.between(LocalDate.parse(dayOfBirthToParse, DateTimeFormatter.ofPattern("dd.MM.yyyy")),LocalDate.now())<0){throw new IllegalArgumentException("Введите дату рождения корректно");}
        this.dayOfBirth = LocalDate.parse(dayOfBirthToParse, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    //задаем конструктор для держателя абонемента
    public HolderOfSubscription(String name, String surname, String dayOfBirthToParse) {
        setName(name);
        setSurname(surname);
        setDayOfBirth(dayOfBirthToParse);
    }

    //гетер, возвращающий имя и фамилию
    public String getNameAndSurname(){
        return name + " " + surname;
    }
}
