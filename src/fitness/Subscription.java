package fitness;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Subscription {

    //задаем свойства, к этим свойствам относится: тип абонемента и его владелец, а так же дата регистрации абонемента и срок истечения
    private TypesOfSubscription type;
    private HolderOfSubscription holder;
    private LocalDate startOfSubscription;
    private LocalDate endOfSubscription;

    //задаем сеттер для держателя абонемента для проверки
    public void setHolder(HolderOfSubscription holder) {
        if(ChronoUnit.YEARS.between(holder.getDayOfBirth(), LocalDate.now())<=13)
        {throw new IllegalArgumentException("Посещение фитнес клуба возможно только с 14 лет");}
        this.holder = holder;
    }

    //задаем конструктор
    public Subscription(TypesOfSubscription type, HolderOfSubscription holder) {
        startOfSubscription=LocalDate.now();
        this.type = type;
        setHolder(holder);
        if (type==TypesOfSubscription.FORONEDAY){
            endOfSubscription=LocalDate.now().plusDays(1);
        }else endOfSubscription=LocalDate.now().plusDays(31);
    }

    //гетер, для даты срока истечения абонемента
    public LocalDate getEndOfSubscription() {
        return endOfSubscription;
    }

    //гетер, возвращающий тип абонемента
    public TypesOfSubscription getType() {
        return type;
    }

    //гетер, возвращающий владельца абонемента
    public HolderOfSubscription getHolder() {
        return holder;
    }
}
