package Biblioteka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteka {

    private String naziv;
    private List<Knjizevnost> knjige= new ArrayList<>();;

    public Biblioteka(String naziv) {
        this.naziv = naziv;
    }

    public void dodajKnjigu(Knjizevnost knjizevnost) {
        if (!knjige.contains(knjizevnost)) {
            knjige.add(knjizevnost);
        }
    }

    public void IspisSvihKnjiga() {

        Collections.sort(knjige);

        StringBuilder sb = new StringBuilder();
        sb.append("Knjige na raspolaganju u biblioteci " + this.getNaziv());
        sb.append("\n");
        for (Knjizevnost k : knjige) {
            sb.append(k.getNaziv());
            if (k instanceof AutorskaKnjizevnost) {
                sb.append(", Autor: " + ((AutorskaKnjizevnost) k).getAutor().getIme() + " " + ((AutorskaKnjizevnost) k).getAutor().getPrezime());
            } else {
                sb.append(", Sakupljac: " + ((NarodnaKnjizevnost) k).getSakupljac().getPseudonim());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public Pisac najcitanijiPisac() {
        return null;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Knjizevnost> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjizevnost> knjige) {
        this.knjige = knjige;
    }

}
