package consolegame;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Start extends Menu {
    private ObjectOfTheGame gameObject;

    public Start(ObjectOfTheGame gameObject) {
        this.gameObject = gameObject;
    }


    @Override
    public void execute() {
        Paragraphs paragraphs = new Paragraphs();
        Paragraphs.game(gameObject);
    }
}
