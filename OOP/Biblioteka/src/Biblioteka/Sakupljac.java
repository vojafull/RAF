package Biblioteka;

public class Sakupljac implements Objavljivanje{

    private String pseudonim;

    public Sakupljac(String pseudonim) {
        this.pseudonim = pseudonim;
    }

    @Override
    public Knjizevnost objavljuje(String naziv, int godina, TipKnjizevnosti tipKnjizevnosti) {
        Knjizevnost k=new NarodnaKnjizevnost(naziv,tipKnjizevnosti);
        ((NarodnaKnjizevnost)k).setSakupljac(this);
        return k;
    }

    public String getPseudonim() {
        return pseudonim;
    }

    public void setPseudonim(String pseudonim) {
        this.pseudonim = pseudonim;
    }
}
