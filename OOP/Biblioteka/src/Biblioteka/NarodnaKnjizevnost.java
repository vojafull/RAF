package Biblioteka;

public class NarodnaKnjizevnost extends Knjizevnost{

    private Sakupljac sakupljac;

    public NarodnaKnjizevnost(String naziv, TipKnjizevnosti tipKnjizevnosti){
        super(naziv,tipKnjizevnosti);
    }

    public Sakupljac getSakupljac() {
        return sakupljac;
    }

    public void setSakupljac(Sakupljac sakupljac) {
        this.sakupljac = sakupljac;
    }
}
