package Obuke;

import java.util.ArrayList;
import java.util.List;

public abstract class Obuka{
    private String naziv;
    private int minimalanBrojPolaznika;
    private List<Profesor> predavaci=new ArrayList<>();
    private List<ObukaPolaznika> obukePolaznika=new ArrayList<>();
    private Oblast oblast;

    public Obuka(String naziv, int minimalanBrojPolaznika, Oblast oblast) {
        this.naziv = naziv;
        this.minimalanBrojPolaznika = minimalanBrojPolaznika;
        this.oblast=oblast;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getMinimalanBrojPolaznika() {
        return minimalanBrojPolaznika;
    }

    public void setMinimalanBrojPolaznika(int minimalanBrojPolaznika) {
        this.minimalanBrojPolaznika = minimalanBrojPolaznika;
    }

    public List<Profesor> getPredavaci() {
        return predavaci;
    }

    public void setPredavaci(List<Profesor> predavaci) {
        this.predavaci = predavaci;
    }

    public List<ObukaPolaznika> getObukePolaznika() {
        return obukePolaznika;
    }

    public void setObukePolaznika(List<ObukaPolaznika> obukePolaznika) {
        this.obukePolaznika = obukePolaznika;
    }

    public Oblast getOblast() {
        return oblast;
    }

    public void setOblast(Oblast oblast) {
        this.oblast = oblast;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Obuka)) {
            return false;
        }

        return naziv.equals(((Obuka)obj).getNaziv());
    }





}
