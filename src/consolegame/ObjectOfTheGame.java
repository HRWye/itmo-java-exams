package consolegame;

import java.io.Serializable;

public class ObjectOfTheGame implements Serializable{
    private int first;
    private int second;
    private String text;


    public ObjectOfTheGame(int first, int second, String text) {
        this.first = first;
        this.second = second;
        this.text = text;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public String getText() {
        return text;
    }
}