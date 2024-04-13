package IzborPredmeta;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int brojIndeksa;
    private int godinaUpisa;
    private List<Integer> upisaneGodine = new ArrayList<>();
    private List<Predmet> polozeniPredmeti = new ArrayList<>();
    private OznakaPlana plan;
    private boolean izabrao;

    public Student(int brojIndeksa, int godinaUpisa, OznakaPlana plan) {
        this.brojIndeksa = brojIndeksa;
        this.godinaUpisa = godinaUpisa;
        this.plan = plan;
        this.izabrao=false;
    }

    public int vratiTrenutnuGodinuStudija(){
        if(upisaneGodine.size()>0)
        return upisaneGodine.get(upisaneGodine.size()-1);
        return 0;
    }

    public boolean jePonovac(){

        if(upisaneGodine.get(upisaneGodine.size()-1)==upisaneGodine.get(upisaneGodine.size()-2)) return true;
        return false;
    }

    public int ostvarenESPB(){
        int suma=0;
        for(Predmet p:polozeniPredmeti){
            suma+=p.getEspb();
        }

        return suma;
    }

    public void izaberi(){
        this.izabrao=true;
    }

    public boolean isIzabrao() {
        return izabrao;
    }

    public void dodajPolozeniPredmet(Predmet p){
        if(p.semestarGodina()==vratiTrenutnuGodinuStudija() && !polozeniPredmeti.contains(p)) polozeniPredmeti.add(p);
    }

    public int getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(int brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public List<Integer> getUpisaneGodine() {
        return upisaneGodine;
    }

    public void setUpisaneGodine(List<Integer> upisaneGodine) {
        this.upisaneGodine = upisaneGodine;
    }

    public List<Predmet> getPolozeniPredmeti() {
        return polozeniPredmeti;
    }

    public void setPolozeniPredmeti(List<Predmet> polozeniPredmeti) {
        this.polozeniPredmeti = polozeniPredmeti;
    }

    public OznakaPlana getPlan() {
        return plan;
    }

    public void setPlan(OznakaPlana plan) {
        this.plan = plan;
    }
}
