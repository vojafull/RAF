package rafchatmessages;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private final List<String> posiljaoci = new ArrayList<>();

    private final List<Poruka> poruke = new ArrayList<>();

    public void napisiPoruku(Poruka poruka) {
        this.poruke.add(poruka);
        if (!this.posiljaoci.contains(poruka.getPosiljalac()))
            this.posiljaoci.add(poruka.getPosiljalac());
    }

    public List<Poruka> getPoruke() {
        return poruke;
    }
}
