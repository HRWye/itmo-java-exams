package consolegame;

public class Play extends Menu {
    private ObjectOfTheGame gameObject;

    public void StartGame(ObjectOfTheGame gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public void execute() {
        Paragraphs gameList = new Paragraphs();
        Paragraphs.game(gameObject);
    }

}
