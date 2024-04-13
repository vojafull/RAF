package IzborPredmeta;

import java.util.ArrayList;
import java.util.List;

public class IzborniModul implements IzborStudenta {

    private String naziv;

    private List<Predmet> predmeti = new ArrayList<>();

    public IzborniModul(String naziv) {
        this.naziv = naziv;
    }

    public boolean dodajPredmet(Predmet p) {
        if (predmeti.contains(p)) return false;
        if (p.semestarGodina() != 3 || p.semestarGodina() != 4) return false;

        predmeti.add(p);

        return true;
    }

    @Override
    public boolean mozeDaIazebere(Student s) {

        if (s.jePonovac()) return false;
        if (s.vratiTrenutnuGodinuStudija() != 3) return false;
        if (s.ostvarenESPB() < 90) return false;


        return true;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }
}
