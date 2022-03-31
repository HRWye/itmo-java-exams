package fitness;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public enum TypesOfSubscription {

    //перечисляем типы возможных абонементов
    FORONEDAY("08:00:00","22:00:00",true,true,false),
    FORONEMONTHDAY("08:00:00","16:00:00", false,true,true),
    FORONEMONTHFULL("08:00:00","22:00:00",true,true,true);

    //задаем свойства элементов
    private LocalTime startOfTraining;
    private LocalTime endOfTraining;
    private boolean pool;
    private boolean gym;
    private boolean groupTrainings;

    //задаем сеттеры для времени начала и конца занятий, в них текстовый формат записи переводится в формат времени с помощью метода parse()
    public void setStartOfTraining(String startOfTrainingToParse) {
        this.startOfTraining = LocalTime.parse(startOfTrainingToParse, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    public void setEndOfTraining(String endOfTrainingToParse) {
        this.endOfTraining = LocalTime.parse(endOfTrainingToParse, DateTimeFormatter.ofPattern("HH:mm:ss"));;
    }

    //задаем конструктор для элементов перечисления, после чего задаем необходимые значения свойств элементов в () при перечислении
    TypesOfSubscription(String startOfTrainingToParse, String endOfTrainingToParse, boolean pool, boolean gym, boolean groupTrainings) {
        setStartOfTraining(startOfTrainingToParse);
        setEndOfTraining(endOfTrainingToParse);
        this.pool = pool;
        this.gym = gym;
        this.groupTrainings = groupTrainings;
    }

    //гетеры, для зон посещения
    public boolean isPool() {
        return pool;
    }
    public boolean isGym() {
        return gym;
    }
    public boolean isGroupTrainings() {
        return groupTrainings;
    }

    //гетеры, для времени возможного посещения
    public LocalTime getStartOfTraining() {
        return startOfTraining;
    }

    public LocalTime getEndOfTraining() {
        return endOfTraining;
    }
}
