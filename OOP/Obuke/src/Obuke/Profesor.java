package Obuke;

import java.util.ArrayList;
import java.util.List;

public class Profesor implements Registracija{

    private String ime;
    private String prezime;
    private String id;
    private Oblast oblast;

    private List<Obuka> obuke=new ArrayList<>();

    public Profesor(String ime, String prezime, String id, Oblast oblast) {
        this.ime = ime;
        this.prezime = prezime;
        this.id = id;
        this.oblast = oblast;
    }

    @Override
    public boolean registruj(Obuka obuka) {

        if(!(this.oblast.equals(obuka.getOblast()))) return false;
        if(registrovan(obuka)) return false;
        if(obuke.size()>3) return false;

        if(obuka instanceof Projekat){
            if(obuka.getPredavaci().size()+1>=((Projekat)obuka).getMaksimalanBrojPolaznika()) return false;
        }

        obuka.getPredavaci().add(this);
        this.obuke.add(obuka);

        return true;
    }

    @Override
    public boolean registrovan(Obuka obuka) {
        return obuke.contains(obuka);
    }
}
