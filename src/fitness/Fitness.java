package fitness;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Fitness {

    //задаем три массива абонементов по 20 элементов
    private final Subscription[] gym = new Subscription[20];
    private final Subscription[] pool = new Subscription[20];
    private final Subscription[] groupTrainings = new Subscription[20];

    /*метод прихода посетителя в тренажерный зал,
    в () передается type - желаемое место посещения и subscription - абонемент посетителя, в котором записана вся информация о нем*/
    public void holderComesToFitness(String whereHolderWantsToGo, Subscription subscription){
        if(ChronoUnit.DAYS.between(subscription.getEndOfSubscription(),LocalDate.now())>=0){
            System.out.println("Абонемент просрочен, вы не можете посетить фитнес клуб");
          }else if(ChronoUnit.MINUTES.between(subscription.getType().getStartOfTraining(),LocalTime.now())<0||ChronoUnit.MINUTES.between(subscription.getType().getEndOfTraining(),LocalTime.now())>0){
            System.out.println(subscription.getHolder().getNameAndSurname()+", вы пришли не вовремя, посмотрите возможное время посещения в абонементе");}
            else if (whereHolderWantsToGo.equalsIgnoreCase("gym")||whereHolderWantsToGo.equalsIgnoreCase("тренажерный зал")){
                if(subscription.getType().isGym()){
                    for (int i=0;i<gym.length;i++){
                        if(gym[i]==null){
                            gym[i]=subscription;
                            System.out.println(subscription.getHolder().getNameAndSurname()+", можете проходить в тренажерный зал. " +
                                    "Время посещения: "+LocalDate.now()+ " " + LocalTime.now());
                            return;
                        }
                    }System.out.println("В тренажерном зале мест нет, приходите в другой раз");
                }else {
                    System.out.println(subscription.getHolder().getNameAndSurname()+", вы не можете пройти в тренажерный зал с таким типом абонемента");
                }
            } else if (whereHolderWantsToGo.equalsIgnoreCase("pool")||whereHolderWantsToGo.equalsIgnoreCase("бассейн")){
                if(subscription.getType().isPool()){
                    for (int i=0;i<pool.length;i++){
                        if (pool[i]==null){
                            pool[i]=subscription;
                            System.out.println(subscription.getHolder().getNameAndSurname()+", можете проходить в бассейн. " +
                                    "Время посещения: "+LocalDate.now()+ " " + LocalTime.now());
                            return;
                        }
                    }System.out.println("В бассейне мест нет, приходите в другой раз");
                }else {
                    System.out.println(subscription.getHolder().getNameAndSurname()+", вы не можете пройти в тренажерный зал с таким типом абонемента");
                }
            } else if (whereHolderWantsToGo.equalsIgnoreCase("group trainings")||whereHolderWantsToGo.equalsIgnoreCase("групповые занятия")){
                if(subscription.getType().isGroupTrainings()){
                    for (int i=0;i<groupTrainings.length;i++){
                        if (groupTrainings[i]==null){
                            groupTrainings[i]=subscription;
                            System.out.println(subscription.getHolder().getNameAndSurname()+", можете проходить на групповые занятия. " +
                                    "Время посещения: "+LocalDate.now()+ " " + LocalTime.now());
                            return;
                        }
                    }System.out.println("Группа для групповых занятий на сегодня уже заполнена");
                }else {
                    System.out.println(subscription.getHolder().getNameAndSurname()+", вы не можете пройти в тренажерный зал с таким типом абонемента");
                }
            } else {
                System.out.println(subscription.getHolder().getNameAndSurname()+", пожалуйста укажите желаемое место посещение корректно");
            }
        }

    //метод закрытия фитнес клуба, который заполняет все массивы null-ми
    public void fitnessIsClosing(){
        Arrays.fill(gym, null);
        Arrays.fill(pool, null);
        Arrays.fill(groupTrainings,null);
        System.out.println("\nФитнес зал закрывается!\nПроверка пустоты фитнес клуба перед закрытием:\n"
                +Arrays.toString(gym)+" -тренажерный зал;\n"
                        +Arrays.toString(pool)+" -бассейн;\n"
                                +Arrays.toString(groupTrainings)+" -групповые занятия.");
    }

    //метод, выводящий информацию о посетителях фитнес клуба
    public  void informationAboutEveryone(){
        System.out.println("\nПосетители тренажерного зала: ");
        for (Subscription subscription : gym) {
            if (subscription!=null){
            System.out.print(subscription.getHolder().getNameAndSurname()+"; ");}
        }
        System.out.println("\nПосетители бассейна: ");
        for (Subscription subscription : pool) {
            if (subscription!=null){
            System.out.print(subscription.getHolder().getNameAndSurname()+"; ");}
        }
        System.out.println("\nПосетители групповых тренировок: ");
        for (Subscription subscription : groupTrainings) {
            if (subscription!=null){
            System.out.print(subscription.getHolder().getNameAndSurname()+"; ");}
        }
    }
}
