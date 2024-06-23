package model;

public class Kurs {

    private String naziv;
    private String kategorija;
    private int trajanje;
    private int cena;

    public Kurs(String naziv, String kategorija, int trajanje, int cena) {
        this.naziv = naziv;
        this.kategorija = kategorija;
        this.trajanje = trajanje;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv+", "+kategorija+", Trajanje "+trajanje+", $"+cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

}
