package RAFChats;

public class Korisnik {
    private String prikazanoIme;
    private String korisnickoIme;
    private String lozinka;

    public Korisnik(String prikazanoIme, String korisnickoIme, String lozinka) {
        this.prikazanoIme = prikazanoIme;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Korisnik(String prikazanoIme, String korisnickoIme, String lozinka, String lozinka2) {
        this.prikazanoIme = prikazanoIme;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }


    public void napisiPoruku(Chat chat, String poruka){
        if(chat.mozeNapisatiPoruku(this)){
            chat.dodajPoruku(this,poruka);
        }
    }



    public String getPrikazanoIme() {
        return prikazanoIme;
    }

    public void setPrikazanoIme(String prikazanoIme) {
        this.prikazanoIme = prikazanoIme;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return ""+prikazanoIme + ','+ korisnickoIme + ',' + lozinka;
    }
}
