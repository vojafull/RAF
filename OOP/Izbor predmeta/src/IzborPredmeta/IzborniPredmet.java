package IzborPredmeta;

public class IzborniPredmet extends Predmet implements IzborStudenta{
    public IzborniPredmet(String naziv, int semestar, int espb, OznakaPlana oznakaPlana) {
        super(naziv, semestar, espb, oznakaPlana);
    }

    @Override
    public boolean mozeDaIazebere(Student s) {

        if(!s.jePonovac()) return false;
        if(!this.getPreduslovi().containsAll(s.getPolozeniPredmeti())) return false;

        for(Predmet p: s.getPolozeniPredmeti()){
            if(p.getNaziv().equals(this.getNaziv())) return false;
            if(p.getOznakaPlana()!=this.getOznakaPlana()) return false;

        }
        if(this.semestarGodina()!=s.vratiTrenutnuGodinuStudija()) return false;

        return true;
    }
}
