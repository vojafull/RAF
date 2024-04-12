package RAFChats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Svi {
    private static Svi svi;
    private List<Korisnik> korisnikList = new ArrayList<>();

    private Svi() {

    }

    public static Svi getSvi() {
        if (svi == null)
            svi = new Svi();
        return svi;
    }

    public Korisnik prijava(String korisnickoIme, String lozinka) {
        for (Korisnik k : korisnikList) {
            if (k.getKorisnickoIme().equals(korisnickoIme) && k.getLozinka().equals(lozinka)) return k;
        }
        return null;
    }

    private boolean imaBroj(String lozinka) {
        for (char c : lozinka.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    private boolean imaVeliko(String lozinka) {
        for (char c : lozinka.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    private boolean imaMalo(String lozinka) {
        for (char c : lozinka.toCharArray()) {
            if (Character.isLowerCase(c)) return true;
        }
        return false;
    }

    private boolean validnaRegistracija(String korisnickoIme, String lozinka, String lozinka2) {

        if (!(lozinka.equals(lozinka2))) return false;

        for (Korisnik k : korisnikList) {
            if (k.getKorisnickoIme().equals(korisnickoIme)) return false;
        }

        if (lozinka.length() < 8) return false;
        if (!imaBroj(lozinka)) return false;
        if (!imaVeliko(lozinka) || !imaMalo(lozinka)) return false;

        return true;
    }

    public void Registracija(String prikazanoIme, String korisnickoIme, String lozinka, String lozinka2) {

        if (validnaRegistracija(korisnickoIme, lozinka, lozinka2)) {
            Korisnik k = new Korisnik(prikazanoIme, korisnickoIme, lozinka);
            korisnikList.add(k);
        }
    }

//    public void Upis(Korisnik korisnik){
//        try {
//
//            File file = new File("korisnici.txt");
//            FileWriter fw = new FileWriter(file,true);
//
//            for(Korisnik k: korisnikList) {
//                if(!(k.equals(korisnik))) fw.append(k.toString() + '\n');
//            }
//            fw.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public List<Korisnik> getKorisnikList() {
        return korisnikList;
    }

    public void setKorisnikList(List<Korisnik> korisnikList) {
        this.korisnikList = korisnikList;
    }


}
