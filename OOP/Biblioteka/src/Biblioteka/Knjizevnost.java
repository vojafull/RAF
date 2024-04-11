package Biblioteka;

import java.util.Objects;

public abstract class Knjizevnost implements Comparable<Knjizevnost>{

    private String naziv;

    private TipKnjizevnosti tipKnjizevnosti;

    public Knjizevnost(String naziv, TipKnjizevnosti tipKnjizevnosti) {
        this.naziv = naziv;
        this.tipKnjizevnosti = tipKnjizevnosti;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public TipKnjizevnosti getTipKnjizevnosti() {
        return tipKnjizevnosti;
    }

    public void setTipKnjizevnosti(TipKnjizevnosti tipKnjizevnosti) {
        this.tipKnjizevnosti = tipKnjizevnosti;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Knjizevnost)) return false;

        if(((Knjizevnost) obj).getNaziv().equals(this.getNaziv()) && ((Knjizevnost) obj).getTipKnjizevnosti().equals(this.getTipKnjizevnosti())) return true;

        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv, tipKnjizevnosti);
    }

    @Override
    public int compareTo(Knjizevnost o) {
        // vraca int - 0 ako su isti, pozitivan ili negativan broj ako je veci, manji
        return this.naziv.compareTo(o.naziv);
    }
}
