package rafchatmessages;

public class Emoji implements Comparable<Emoji> {

    private String naziv;

    private String skracenica;

    Emoji(String naziv, String skracenica) {
        this.naziv = naziv;
        this.skracenica = skracenica;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSkracenica() {
        return skracenica;
    }

    public void setSkracenica(String skracenica) {
        this.skracenica = skracenica;
    }

    @Override
    public int compareTo(Emoji o) {
        return this.naziv.compareTo(o.naziv);
    }
}
