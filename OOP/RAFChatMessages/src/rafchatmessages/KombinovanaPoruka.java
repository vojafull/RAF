package rafchatmessages;

import java.util.ArrayList;
import java.util.List;

public class KombinovanaPoruka extends Poruka {

    private List<Poruka> sadrzina = new ArrayList<>();

    public KombinovanaPoruka(String posiljalac) {
        super(posiljalac);
    }

    public void dodajUSadrzinu(Poruka poruka) {
        if (!this.getPosiljalac().equals(poruka.getPosiljalac()))
            return;
        if (poruka instanceof KombinovanaPoruka) {
            KombinovanaPoruka kombinovanaPoruka = (KombinovanaPoruka) poruka;
            for (Poruka p : kombinovanaPoruka.sadrzina)
                this.sadrzina.add(p);
            return;
        }
        if (poruka instanceof ViseEmojijaPoruka) {
            ViseEmojijaPoruka viseEmojijaPoruka = (ViseEmojijaPoruka) poruka;
            for (Emoji e : viseEmojijaPoruka.getEmojis()) {
                EmojiPoruka emojiPoruka = new EmojiPoruka(this.getPosiljalac(), e);
                this.sadrzina.add(emojiPoruka);
            }
            return;
        }
        this.sadrzina.add(poruka);
    }

    @Override
    protected String formirajSadrzinu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Poruka p : this.sadrzina)
            stringBuilder.append(p.formirajSadrzinu()).append(" ");
        return stringBuilder.toString().trim();
    }

    public List<Poruka> getSadrzina() {
        return sadrzina;
    }

    public void setSadrzina(List<Poruka> sadrzina) {
        this.sadrzina = sadrzina;
    }
}
