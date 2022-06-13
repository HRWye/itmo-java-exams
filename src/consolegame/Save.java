package consolegame;

import java.io.*;

public class Save extends Menu {

    private ObjectOfTheGame gameObject;

    public Save(ObjectOfTheGame gameObject){
        this.gameObject=gameObject;
    }

    @Override
    public void execute() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(new File("save")))) {
            outputStream.writeObject(gameObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Start(gameObject).execute();
    }
}
