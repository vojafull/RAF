package Biblioteka;

public class Pesnik extends Pisac{


    public Pesnik(String ime, String prezime, int godinaRodjenja) {
        super(ime, prezime, godinaRodjenja);
    }

    @Override
    public Knjizevnost objavljuje(String naziv, int godina, TipKnjizevnosti tipKnjizevnosti) {
        Knjizevnost k = new AutorskaKnjizevnost(naziv, TipKnjizevnosti.LIRIKA);
        ((AutorskaKnjizevnost) k).setGodina(godina);
        ((AutorskaKnjizevnost) k).setAutor(this);
        return k;
    }
}
