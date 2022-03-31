package fitness;

public class Application {
    public static void main(String[] args) {

        HolderOfSubscription holder1 = new HolderOfSubscription("Егор", "Герасимов","05.02.1999");
        HolderOfSubscription holder2 = new HolderOfSubscription("Александр", "Альканов","08.01.1999");
        HolderOfSubscription holder3 = new HolderOfSubscription("Андрей", "Павлов","04.11.1999");
        HolderOfSubscription holder4 = new HolderOfSubscription("Вячеслав", "Шестопалов", "26.11.1998");
        HolderOfSubscription holder5 = new HolderOfSubscription("Ильнур", "Миннигалиев", "02.07.1999");
        HolderOfSubscription holder6 = new HolderOfSubscription("Богдан", "Жмышенко", "02.07.2000");
        HolderOfSubscription holder7 = new HolderOfSubscription("Вячеслав", "Гуро", "22.09.1999");
        HolderOfSubscription holder8 = new HolderOfSubscription("Максим", "Лотник", "01.04.1999");
        HolderOfSubscription holder9 = new HolderOfSubscription("Максим", "Касымов", "06.01.2000");
        HolderOfSubscription holder10 = new HolderOfSubscription("Данил", "Верхоланцев", "23.12.1998");

        Subscription subscription1 = new Subscription(TypesOfSubscription.FORONEMONTHFULL,holder1);
        Subscription subscription2 = new Subscription(TypesOfSubscription.FORONEDAY,holder2);
        Subscription subscription3 = new Subscription(TypesOfSubscription.FORONEMONTHDAY,holder3);
        Subscription subscription4 = new Subscription(TypesOfSubscription.FORONEMONTHFULL,holder4);
        Subscription subscription5 = new Subscription(TypesOfSubscription.FORONEDAY,holder5);
        Subscription subscription6 = new Subscription(TypesOfSubscription.FORONEMONTHFULL,holder6);
        Subscription subscription7 = new Subscription(TypesOfSubscription.FORONEMONTHDAY,holder7);
        Subscription subscription8 = new Subscription(TypesOfSubscription.FORONEDAY,holder8);
        Subscription subscription9 = new Subscription(TypesOfSubscription.FORONEMONTHDAY,holder9);
        Subscription subscription10 = new Subscription(TypesOfSubscription.FORONEMONTHFULL,holder10);

        Fitness fitnessClub = new Fitness();

        fitnessClub.holderComesToFitness("тренажерный зал", subscription1);
        fitnessClub.holderComesToFitness("групповые занятия", subscription2);
        fitnessClub.holderComesToFitness("групповые занятия", subscription3);
        fitnessClub.holderComesToFitness("тренажерный зал", subscription4);
        fitnessClub.holderComesToFitness("бассейн", subscription5);
        fitnessClub.holderComesToFitness("групповые занятия", subscription6);
        fitnessClub.holderComesToFitness("тренажерный зал", subscription7);
        fitnessClub.holderComesToFitness("бассейн", subscription8);
        fitnessClub.holderComesToFitness("групповые занятия", subscription9);
        fitnessClub.holderComesToFitness("тренажерный зал", subscription10);

        fitnessClub.informationAboutEveryone();

        fitnessClub.fitnessIsClosing();

    }
}
