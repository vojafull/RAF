package Biblioteka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class KombinovanaLektira extends Lektira{

    private int brEp;
    private  int brLi;
    private int brLP;

    public KombinovanaLektira(int razred, Skola skola) {
        super(razred, skola);
    }

    // 1 lirsko epski!
    //  2 epika
    //  1 lirika
    @Override
    public boolean dodajKnjigu(Knjizevnost knjizevnost,Biblioteka biblioteka) {

        if(!(biblioteka.getKnjige().contains(knjizevnost))){
            return false;
        }
       if(this.getKnjige().size()==5) return false;

        if(brLP==1 && knjizevnost.getTipKnjizevnosti()==TipKnjizevnosti.LIRSKO_EPSKI) return  false;
        if(brLi==2 && brLP==1 &&  knjizevnost.getTipKnjizevnosti()!=TipKnjizevnosti.EPIKA) return  false;
        if(brEp==3 && brLP==1 && knjizevnost.getTipKnjizevnosti()!=TipKnjizevnosti.LIRIKA) return false;
        if(brLi==3 && knjizevnost.getTipKnjizevnosti()!=TipKnjizevnosti.EPIKA) return false;
        if(brEp==4 && knjizevnost.getTipKnjizevnosti()!=TipKnjizevnosti.LIRIKA) return false;

        this.getKnjige().add(knjizevnost);

        return  true;
    }


}
