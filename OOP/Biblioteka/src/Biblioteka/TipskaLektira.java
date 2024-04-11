package Biblioteka;

import java.util.List;

public class TipskaLektira extends Lektira{

    private TipKnjizevnosti tip;

    public TipskaLektira(int razred, Skola skola, TipKnjizevnosti tip) {
        super(razred, skola);
        this.tip = tip;
    }

    @Override
    public boolean dodajKnjigu(Knjizevnost knjizevnost,Biblioteka biblioteka) {

        if(!(biblioteka.getKnjige().contains(knjizevnost))){
            return false;
        }

        if (this.getKnjige().size() == 4) return false;

        if (knjizevnost.getTipKnjizevnosti() == tip) {
                this.getKnjige().add(knjizevnost);
        }

        return true;
    }


}
