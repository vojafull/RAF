package IzborPredmeta;

import java.util.ArrayList;
import java.util.List;

public class IzbornaGrupa implements IzborStudenta{

    private String oznaka;
    private List<IzborniPredmet> predmeti=new ArrayList<>();

    private OznakaPlana plan;

    private int godina;

    public IzbornaGrupa() {

        this.godina=Character.getNumericValue(oznaka.charAt(0));

        if(oznaka.charAt(3)=='3') this.plan=OznakaPlana.S;
        if(oznaka.charAt(3)=='2') this.plan=OznakaPlana.RI;
        if(oznaka.charAt(3)=='1') this.plan=OznakaPlana.RN;

    }

    public IzbornaGrupa(String oznaka) {

        this.oznaka=oznaka;

        this.godina=Character.getNumericValue(oznaka.charAt(0));

        if(oznaka.charAt(2)=='3') this.plan=OznakaPlana.S;
        if(oznaka.charAt(2)=='2') this.plan=OznakaPlana.RI;
        if(oznaka.charAt(2)=='1') this.plan=OznakaPlana.RN;

    }

    public boolean dodajPredmet(IzborniPredmet izborniPredmet){

        if(izborniPredmet.semestarGodina()!=godina) return false;
        if(izborniPredmet.getOznakaPlana()!=plan) return false;

       if(predmeti.contains(izborniPredmet)) return false;

        predmeti.add(izborniPredmet);

        return true;
    }

    @Override
    public boolean mozeDaIazebere(Student s) {

        if(s.jePonovac()) return false;
        if(s.vratiTrenutnuGodinuStudija()!=godina) return false;
        if(s.getPlan()!=plan) return false;
        if(!((Predmet)predmeti).getPreduslovi().containsAll(s.getPolozeniPredmeti())) return false;

        return true;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public List<IzborniPredmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<IzborniPredmet> predmeti) {
        this.predmeti = predmeti;
    }

    public OznakaPlana getPlan() {
        return plan;
    }

    public void setPlan(OznakaPlana plan) {
        this.plan = plan;
    }
}
