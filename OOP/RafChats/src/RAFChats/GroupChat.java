package RAFChats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupChat implements Chat{

    private List<String> poruke=new ArrayList<>();
    private List<Korisnik> grupa=new ArrayList<>();
    private List<Korisnik> posiljaoci=new ArrayList<>();

    public GroupChat(){

    }

    public void dodajUGrupu(Korisnik korisnik){

        if(!(grupa.contains(korisnik))){
            grupa.add(korisnik);
        }

    }

    public void ukloniIzGrupe(Korisnik korisnik){
        grupa.remove(korisnik);
    }

    @Override
    public boolean mozeNapisatiPoruku(Korisnik korisnik) {
        if(grupa.contains(korisnik)) return true;
        return false;
    }

    @Override
    public void dodajPoruku(Korisnik korisnik, String poruka) {
        if(!(mozeNapisatiPoruku(korisnik))){FajlUpis(korisnik,poruka); return;}
        posiljaoci.add(korisnik);
        poruke.add(poruka);
    }

    @Override
    public void FajlUpis(Korisnik korisnik, String poruku) {
        try{
            FileWriter fw=new FileWriter(new File("neuspesne.txt"),true);
            StringBuilder sb=new StringBuilder();
            sb.append(korisnik.getPrikazanoIme());
            sb.append(" => ");
            sb.append(poruku);

            sb.append("\nCet: ");
            for(Korisnik k:grupa){
                sb.append(k.getPrikazanoIme());
                sb.append(", ");
            }
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

    public List<Korisnik> getGrupa() {
        return grupa;
    }

    public void setGrupa(List<Korisnik> grupa) {
        this.grupa = grupa;
    }

    public List<Korisnik> getPosiljaoci() {
        return posiljaoci;
    }

    public void setPosiljaoci(List<Korisnik> posiljaoci) {
        this.posiljaoci = posiljaoci;
    }

    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder();
        for(String s:poruke) {
            sb.append(s+"\n");
        }
        return sb.toString();
    }
}
