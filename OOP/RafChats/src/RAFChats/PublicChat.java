package RAFChats;

import java.util.ArrayList;
import java.util.List;

public class PublicChat implements Chat {

    private List<String> poruke = new ArrayList<>();

    public PublicChat() {

    }

    @Override
    public boolean mozeNapisatiPoruku(Korisnik korisnik) {
        return true;
    }

    @Override
    public void dodajPoruku(Korisnik korisnik, String poruka) {

        StringBuilder sb = new StringBuilder();

        sb.append("[" + korisnik.getPrikazanoIme() + "]");
        sb.append(" ==> ");
        sb.append("[" + poruka + "]\n");

        poruke.add(sb.toString());
    }

    @Override
    public void FajlUpis(Korisnik korisnik, String poruku) {
        return;
    }

    public List<String> getPoruke() {
        return poruke;
    }

    public void setPoruke(List<String> poruke) {
        this.poruke = poruke;
    }

    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder();
        for(String s:poruke) {
            sb.append(s);
        }
        return sb.toString();
    }
}
