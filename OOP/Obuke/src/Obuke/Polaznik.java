package Obuke;

import java.util.ArrayList;
import java.util.List;

public class Polaznik implements Registracija{

    private String ime;
    private String prezime;
    private String email;

    private List<ObukaPolaznika> obuke=new ArrayList<>();

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    @Override
    public boolean registruj(Obuka obuka) {

        if(email==null || !(email.contains("@")) || registrovan(obuka)) return false;

        if(obuka instanceof Kurs) {
            Kurs preduslovi = (Kurs) obuka;
            for(Kurs k:preduslovi.getPreduslovi()){

                boolean f=false;
                for(ObukaPolaznika op:obuke){
                    if(op.getObuka().equals(k)) {
                        f=true;
                        break;
                    }
                    if(!f) return false;
                }

            }
        }

        if(obuka instanceof Projekat){
            Projekat p=(Projekat) obuka;
            if(p.getMaksimalanBrojPolaznika()<=p.getObukePolaznika().size()) return false;
        }

        ObukaPolaznika obukaPolaznika=new ObukaPolaznika(this);

        obukaPolaznika.setRegistracioniBroj(ObukaPolaznika.getPoslednjiBroj());
        ObukaPolaznika.setPoslednjiBroj(ObukaPolaznika.getPoslednjiBroj()+1);

        obuke.add(obukaPolaznika);
        obuka.getObukePolaznika().add(obukaPolaznika);



        return true;
    }

    @Override
    public boolean registrovan(Obuka obuka) {
        return obuke.contains(obuka);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ObukaPolaznika> getObuke() {
        return obuke;
    }

    public void setObuke(List<ObukaPolaznika> obuke) {
        this.obuke = obuke;
    }

    @Override
    public String toString() {
        return this.getIme()+" "+this.getPrezime()+"["+this.getEmail()+"]\n";
    }
}
