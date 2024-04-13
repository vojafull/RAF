package IzborPredmeta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Izbori {

    private static Izbori instance;
    private List<Student> studenti = new ArrayList<>();
    private List<IzborStudenta> izbori = new ArrayList<>();

    private Izbori() {

    }

    public static Izbori getInstance() {
        if (instance == null)
            instance = new Izbori();
        return instance;
    }

    public boolean dodaj(Student s, IzborStudenta predmet) {

        if (predmet instanceof IzborniPredmet && s.jePonovac()) {
            IzborniPredmet izborniPredmet = (IzborniPredmet) predmet;
            if (!izborniPredmet.mozeDaIazebere(s)) return false;


            studenti.add(s);
            izbori.add((IzborniPredmet) predmet);
        } else if (predmet instanceof IzbornaGrupa && !s.jePonovac()) {
            IzbornaGrupa izborniGrupa = (IzbornaGrupa) predmet;
            if (!izborniGrupa.mozeDaIazebere(s) || s.isIzabrao()) return false;
            s.izaberi();

            studenti.add(s);
            izbori.add((IzbornaGrupa) predmet);
        } else if (predmet instanceof IzborniModul && !s.jePonovac()) {
            IzborniModul izborniModul = (IzborniModul) predmet;
            if (!izborniModul.mozeDaIazebere(s) || s.isIzabrao()) return false;

            s.izaberi();
            studenti.add(s);
            izbori.add((IzborniModul) predmet);
        }

        return false;
    }

    public void Ispis(){

        try {
            FileWriter fw=new FileWriter(new File("ispis.txt"));

            StringBuilder sb=new StringBuilder();

            for(int i=0;i<studenti.size();i++){
                sb.append(studenti.get(i).getBrojIndeksa());
                sb.append(" ");

                if (izbori.get(i) instanceof IzborniPredmet) {
                    sb.append(((IzborniPredmet) izbori.get(i)).getNaziv());

                } else if (izbori.get(i) instanceof IzbornaGrupa) {
                    sb.append(((IzbornaGrupa) izbori.get(i)).getOznaka());

                } else if (izbori.get(i) instanceof IzborniModul) {
                    sb.append(((IzborniModul) izbori.get(i)).getNaziv());
                }

                sb.append("\n");
            }

            fw.write(sb.toString());
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
