package rafchatmessages;

import java.util.ArrayList;
import java.util.List;

public class Emojis {

    private static Emojis instance;

    private List<Emoji> emojis = new ArrayList<>();

    private Emojis() {
    }

    public static Emojis getEmojis() {
        if (instance == null)
            instance = new Emojis();
        return instance;
    }

    public boolean dodajEmoji(String naziv, String skracenica) {
        for (Emoji e : this.emojis) {
            if (e.getNaziv().equals(naziv))
                return false;
            if (e.getSkracenica().equals(skracenica))
                return false;
        }
        Emoji emoji = new Emoji(naziv, skracenica);
        this.emojis.add(emoji);
        return true;
    }

    public Emoji getEmojiByNaziv(String naziv) {
        for (Emoji e : emojis) {
            if (e.getNaziv().equals(naziv))
                return e;
        }
        return null;
    }

    public List<Emoji> getEmojije() {
        return this.emojis;
    }
}
