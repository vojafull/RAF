package Biblioteka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Lektira {

    private int razred;
    private Skola skola;
    private List<Knjizevnost> knjige=new ArrayList<>();

    public Lektira(int razred, Skola skola) {
        this.razred = razred;
        this.skola = skola;
    }

    public int getRazred() {
        return razred;
    }

    public void setRazred(int razred) {
        this.razred = razred;
    }

    public Skola getSkola() {
        return skola;
    }

    public void setSkola(Skola skola) {
        this.skola = skola;
    }

    public List<Knjizevnost> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjizevnost> knjige) {
        this.knjige = knjige;
    }

    public abstract boolean dodajKnjigu(Knjizevnost knjizevnost, Biblioteka biblioteka);

    public void upisFajl(String fajl){
        try{
            File file=new File(fajl);
            FileWriter fw=new FileWriter(file);

            fw.write(this.toString());

            fw.close();
        }
        catch (IOException e){
            throw  new RuntimeException(e);
        }

    }
    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder();
        sb.append(getSkola());
        sb.append(" ");
        sb.append(getRazred());
        sb.append(". razred\n");
        for(Knjizevnost k: knjige){
            if(k instanceof AutorskaKnjizevnost){
                sb.append(((AutorskaKnjizevnost) k).getAutor().getIme());
                sb.append(" ");
                sb.append(((AutorskaKnjizevnost) k).getAutor().getPrezime());
            }
            else{
                sb.append(((NarodnaKnjizevnost)k).getSakupljac().getPseudonim());
            }
            sb.append(" ");
            sb.append(k.getNaziv());
            sb.append(" ");
            sb.append(k.getTipKnjizevnosti());
            sb.append("\n");
        }

        return sb.toString();
    }
}
