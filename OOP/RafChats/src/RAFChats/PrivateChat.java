package RAFChats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrivateChat implements Chat{

    private List<String> poruke=new ArrayList<>();

    private Korisnik k1;
    private Korisnik k2;
    private Korisnik prethodniPosiljalac;

    public PrivateChat(Korisnik k1, Korisnik k2) {
        this.k1 = k1;
        this.k2 = k2;
        this.prethodniPosiljalac=k2;
    }

    @Override
    public boolean mozeNapisatiPoruku(Korisnik korisnik) {
        if(korisnik.equals(k1) && !(korisnik.equals(prethodniPosiljalac))){ prethodniPosiljalac=k1; return true;}
        else if(korisnik.equals(k2) && !(korisnik.equals(prethodniPosiljalac))){ prethodniPosiljalac=k2; return true; }
        return false;
    }

    @Override
    public void dodajPoruku(Korisnik korisnik, String poruka) {
        if(!(mozeNapisatiPoruku(korisnik))) {FajlUpis(korisnik,poruka); return;}
        poruke.add(poruka);
        prethodniPosiljalac=korisnik;
    }

    @Override
    public void FajlUpis(Korisnik korisnik, String poruku) {
        try{
            FileWriter fw=new FileWriter(new File("neuspesne.txt"),true);
            StringBuilder sb=new StringBuilder();
            sb.append(korisnik.getPrikazanoIme());
            sb.append(" => ");
            sb.append(poruku);

            sb.append("\nPriavteCet: ");
            sb.append(k1.getPrikazanoIme());
            sb.append(",");
            sb.append(k2.getPrikazanoIme());
            sb.append("\n");

            fw.append(sb.toString());

            fw.close();
        }
        catch (IOException e){
            throw  new RuntimeException(e);
        }
    }

    public List<String> getPoruke() {
        return poruke;
    }

    public void setPoruke(List<String> poruke) {
        this.poruke = poruke;
    }

    public Korisnik getK1() {
        return k1;
    }

    public void setK1(Korisnik k1) {
        this.k1 = k1;
    }

    public Korisnik getK2() {
        return k2;
    }

    public void setK2(Korisnik k2) {
        this.k2 = k2;
    }

    public Korisnik getPrethodniPosiljalac() {
        return prethodniPosiljalac;
    }

    public void setPrethodniPosiljalac(Korisnik prethodniPosiljalac) {
        this.prethodniPosiljalac = prethodniPosiljalac;
    }

    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder();
        for(String s:poruke) {
            sb.append(s);
        }
        return sb.toString();
    }
}
