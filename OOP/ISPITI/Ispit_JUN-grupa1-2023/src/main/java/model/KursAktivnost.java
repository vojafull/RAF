package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class KursAktivnost implements Comparable<KursAktivnost> {
    private Kurs kurs;
    private String naziv;
    private String kategorija;
    private LocalDateTime pocetak;
    private LocalDateTime kraj;
    private double kompletiranost;

    public KursAktivnost(Kurs kurs, LocalDateTime pocetak, LocalDateTime kraj, double kompletiranost) {
        this.kurs = kurs;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.kompletiranost = kompletiranost;
        this.naziv=kurs.getNaziv();
        this.kategorija=kurs.getKategorija();
    }

    public String getNaziv() {
        return naziv;
    }

    public String getKategorija() {
        return kategorija;
    }

    public String getPocetakDatum(){
        return pocetak.format(DateTimeFormatter.ISO_DATE);
    }public String getKrajDatum(){
        return kraj.format(DateTimeFormatter.ISO_DATE);
    }
    public String getPocetakVreme(){
        return pocetak.format(DateTimeFormatter.ofPattern("HH:mm"));
    }public String getKrajVreme(){
        return kraj.format(DateTimeFormatter.ofPattern("HH:mm"));
    }


    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public LocalDateTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalDateTime pocetak) {
        this.pocetak = pocetak;
    }

    public LocalDateTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalDateTime kraj) {
        this.kraj = kraj;
    }

    public double getKompletiranost() {
        return kompletiranost;
    }

    public void setKompletiranost(double kompletiranost) {
        this.kompletiranost = kompletiranost;
    }


    @Override
    public int compareTo(KursAktivnost o) {
        return pocetak.compareTo(o.getPocetak());
    }

    @Override
    public String toString() {
        return pocetak.format(DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd")) +" - "+kraj.format(DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd"));
    }
}
