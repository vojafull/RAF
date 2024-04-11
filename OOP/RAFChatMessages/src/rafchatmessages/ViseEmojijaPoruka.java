package rafchatmessages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViseEmojijaPoruka extends Poruka {

    private List<Emoji> emojis = new ArrayList<>();

    public ViseEmojijaPoruka(String posiljalac) {
        super(posiljalac);
    }

    public void dodajUSadrzinu(Emoji... emojis) {
        this.emojis.addAll(Arrays.asList(emojis));
    }

    @Override
    protected String formirajSadrzinu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Emoji e : emojis)
            stringBuilder.append(e.getSkracenica()).append(" ");
        return stringBuilder.toString().trim();
    }

    public List<Emoji> getEmojis() {
        return this.emojis;
    }
}
