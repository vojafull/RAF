package rafchatmessages;

public class TekstualnaPoruka extends Poruka {

    private String tekst;

    public TekstualnaPoruka(String posiljalac, String tekst) {
        super(posiljalac);
        this.tekst = tekst;
    }

    @Override
    protected String formirajSadrzinu() {
        return this.tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
