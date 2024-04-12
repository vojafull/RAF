package Obuke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Coursera {

    private static Coursera instance;
    private List<Registracija> registracije = new ArrayList<>();
    private List<Obuka> obuke = new ArrayList<>();

    private Coursera() {

    }

    public void sveObukePolaznika(Polaznik polaznik) {
        for (ObukaPolaznika o : polaznik.getObuke()) {
            System.out.println("\n" + o.getObuka().getNaziv());
        }
    }

    public boolean dodajRegistraciju(Registracija registracija) {

        if (registracije.contains(registracija)) return false;

        registracije.add(registracija);

        return true;
    }

    public static Coursera getInstance() {
        if (instance == null)
            instance = new Coursera();

        return instance;
    }

    private void IspisObuka() {

        Collections.sort(obuke, new Comparator<Obuka>() {
            @Override
            public int compare(Obuka o1, Obuka o2) {
                if (o1.getObukePolaznika().size() < o2.getObukePolaznika().size()) return -1;

                else if (o1.getObukePolaznika().size() > o2.getObukePolaznika().size()) return 1;

                return o1.getNaziv().compareTo(o2.getNaziv());
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Obuka o : obuke) {
            if (o.getMinimalanBrojPolaznika() <= o.getObukePolaznika().size()) {
                sb.append("Obuka: ");
                sb.append(o.getNaziv());
                sb.append(" ");
                sb.append(o.getObukePolaznika().size());
                sb.append(" polaznika\n");
                sb.append("Polaznici: ");
                for (ObukaPolaznika obukaPolaznika : o.getObukePolaznika()) {
                    Polaznik p = obukaPolaznika.getPolaznik();
                    sb.append(p.getEmail());
                    sb.append(" ");
                    sb.append(obukaPolaznika.getRegistracioniBroj() + "\n");
                }
            }
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }

    private void IspisUFajl(String fajl){
        try{
            File file=new File(fajl);
            FileWriter fw=new FileWriter(file);

            Collections.sort(obuke, new Comparator<Obuka>() {
                @Override
                public int compare(Obuka o1, Obuka o2) {
                    if (o1.getObukePolaznika().size() < o2.getObukePolaznika().size()) return -1;

                    else if (o1.getObukePolaznika().size() > o2.getObukePolaznika().size()) return 1;

                    return o1.getNaziv().compareTo(o2.getNaziv());
                }
            });

            StringBuilder sb = new StringBuilder();

            for (Obuka o : obuke) {
                if (o.getMinimalanBrojPolaznika() <= o.getObukePolaznika().size()) {
                    sb.append("Obuka: ");
                    sb.append(o.getNaziv());
                    sb.append(" ");
                    sb.append(o.getObukePolaznika().size());
                    sb.append(" polaznika\n");
                    sb.append("Polaznici: ");
                    for (ObukaPolaznika obukaPolaznika : o.getObukePolaznika()) {
                        Polaznik p = obukaPolaznika.getPolaznik();
                        sb.append(p.getEmail());
                        sb.append(" ");
                        sb.append(obukaPolaznika.getRegistracioniBroj() + "\n");
                    }
                }
            }
            sb.append("\n");
            fw.append(sb.toString());

            fw.close();

        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    public void Ispis(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("1. Ispis na ekran\n2. Ispis u fajl\n");
        int opcija=Integer.parseInt(scanner.nextLine());

        if(opcija==1) this.IspisObuka();
        else{
            System.out.println("Unesite naziv fajla");
            this.IspisUFajl(scanner.nextLine());
        }
    }

    public List<Registracija> getRegistracije() {
        return registracije;
    }

    public void setRegistracije(List<Registracija> registracije) {
        this.registracije = registracije;
    }

    public List<Obuka> getObuke() {
        return obuke;
    }

    public void setObuke(List<Obuka> obuke) {
        this.obuke = obuke;
    }
}
