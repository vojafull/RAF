package IzborPredmeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Predmet {
    private String naziv;
    private int semestar;
    private int espb;
    private List<Predmet> preduslovi=new ArrayList<>();
    private OznakaPlana oznakaPlana;

    public Predmet(String naziv, int semestar, int espb, OznakaPlana oznakaPlana) {
        this.naziv = naziv;
        this.semestar = semestar;
        this.espb = espb;
        this.oznakaPlana = oznakaPlana;
    }

    public void dodajPreduslov(Predmet p){
        if(p.oznakaPlana==this.oznakaPlana && p.semestar<this.semestar) preduslovi.add(p);
    }

    public int semestarGodina(){

        if(semestar==1 || semestar==2) return 1;
        if(semestar==3 || semestar==4) return 2;
        if(semestar==5 || semestar==6) return 3;

        return 4;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public List<Predmet> getPreduslovi() {
        return preduslovi;
    }

    public void setPreduslovi(List<Predmet> preduslovi) {
        this.preduslovi = preduslovi;
    }

    public OznakaPlana getOznakaPlana() {
        return oznakaPlana;
    }

    public void setOznakaPlana(OznakaPlana oznakaPlana) {
        this.oznakaPlana = oznakaPlana;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        return Objects.equals(naziv, ((Predmet) obj).getNaziv());
    }
}
