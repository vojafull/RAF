package Obuke;

import java.util.ArrayList;
import java.util.List;

public class Tim implements Registracija {

    private List<Polaznik> polaznici=new ArrayList<>();
    private Polaznik vodja;


    @Override
    public boolean registruj(Obuka obuka) {

        if(!(obuka instanceof Projekat) || obuka.getOblast()!=Oblast.PROGRAMIRANJE) return false;


        for(Polaznik p:polaznici){
            ObukaPolaznika obukaPolaznika=new ObukaPolaznika(p);
            obukaPolaznika.setRegistracioniBroj(ObukaPolaznika.getPoslednjiBroj());

            obuka.getObukePolaznika().add(obukaPolaznika);
            p.getObuke().add(obukaPolaznika);
        }

        ObukaPolaznika.setPoslednjiBroj(ObukaPolaznika.getPoslednjiBroj()+1);

        return true;
    }

    @Override
    public boolean registrovan(Obuka obuka) {
        return false;
    }

    public Tim(Polaznik vodja) {
        this.vodja = vodja;
    }

    public void dodajPolaznika(Polaznik p){
        if(!(polaznici.contains(p)) && !(vodja.equals(p))) polaznici.add(p);
    }
}
