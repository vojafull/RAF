package RAFChats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JustMeChat implements Chat{

    private Korisnik k;

    private List<String> poruke=new ArrayList<>();

    public JustMeChat(Korisnik k) {
        this.k = k;
    }

    @Override
    public boolean mozeNapisatiPoruku(Korisnik korisnik) {
        if(korisnik.equals(k)) return true;
        return false;
    }

    @Override
    public void dodajPoruku(Korisnik korisnik, String poruku) {
        if(!(mozeNapisatiPoruku(korisnik))) {FajlUpis(korisnik,poruku); return;}
        poruke.add(poruku);
    }

    @Override
    public void FajlUpis(Korisnik korisnik, String poruku) {
        try{
            FileWriter fw=new FileWriter(new File("neuspesne.txt"),true);
            StringBuilder sb=new StringBuilder();
            sb.append(korisnik.getPrikazanoIme());
            sb.append(" => ");
            sb.append(poruku);

            sb.append("\nJustMeCet: ");
            sb.append(k.getPrikazanoIme());
            sb.append(" ");

            sb.append("\n");

            fw.append(sb.toString());

            fw.close();
        }
        catch (IOException e){
            throw  new RuntimeException(e);
        }
    }

    public Korisnik getK() {
        return k;
    }

    public void setK(Korisnik k) {
        this.k = k;
    }

    public List<String> getPoruke() {
        return poruke;
    }

    public void setPoruke(List<String> poruke) {
        this.poruke = poruke;
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
