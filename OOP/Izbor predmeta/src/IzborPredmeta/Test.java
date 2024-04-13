package IzborPredmeta;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Predmet p1 = new Predmet("AAA", 2, 6, OznakaPlana.RI);
        Predmet p2 = new Predmet("BBB", 5, 8, OznakaPlana.RN);
        Predmet p3 = new Predmet("CCC", 1, 3, OznakaPlana.RI);

        IzborniPredmet izborniPredmet1 = new IzborniPredmet("aaa", 2, 3, OznakaPlana.RI);
        IzborniPredmet izborniPredmet2 = new IzborniPredmet("bbb", 4, 3, OznakaPlana.RI);
        IzborniPredmet izborniPredmet3 = new IzborniPredmet("ccc", 3, 3, OznakaPlana.S);
        IzborniPredmet izborniPredmet4 = new IzborniPredmet("ddd", 1, 3, OznakaPlana.RN);
        IzborniPredmet izborniPredmet5 = new IzborniPredmet("eee", 1, 3, OznakaPlana.RN);

        izborniPredmet1.dodajPreduslov(p1);
        izborniPredmet2.dodajPreduslov(p2);
        izborniPredmet3.dodajPreduslov(p1);
        izborniPredmet4.dodajPreduslov(p2);
        izborniPredmet5.dodajPreduslov(p1);
        izborniPredmet1.dodajPreduslov(p3);

        IzbornaGrupa izbornaGrupa1=new IzbornaGrupa("101");
        IzbornaGrupa izbornaGrupa2=new IzbornaGrupa("102");

        izbornaGrupa1.dodajPredmet(izborniPredmet1);
        izbornaGrupa1.dodajPredmet(izborniPredmet2);
        izbornaGrupa1.dodajPredmet(izborniPredmet3);

        izbornaGrupa2.dodajPredmet(izborniPredmet4);
        izbornaGrupa2.dodajPredmet(izborniPredmet5);

        IzborniModul izborniModul1=new IzborniModul("MODUL1");
        IzborniModul izborniModul2=new IzborniModul("MODUL2");

        izborniModul1.dodajPredmet(izborniPredmet3);
        izborniModul1.dodajPredmet(izborniPredmet1);
        izborniModul1.dodajPredmet(izborniPredmet2);

        izborniModul2.dodajPredmet(izborniPredmet4);
        izborniModul2.dodajPredmet(izborniPredmet5);

        Student s1=new Student(12,2001,OznakaPlana.RI);
        Student s2=new Student(412,2021,OznakaPlana.RN);

        s1.dodajPolozeniPredmet(p1);
        s1.dodajPolozeniPredmet(p2);
        s2.dodajPolozeniPredmet(p1);
        s2.dodajPolozeniPredmet(p3);

        List<Integer> l1=new ArrayList<>();
        l1.add(1);
        l1.add(2);

        s1.setUpisaneGodine(l1);
        l1.add(2);
        s2.setUpisaneGodine(l1);

        Izbori izbori= Izbori.getInstance();
        izbori.dodaj(s1,izborniPredmet1);
        izbori.dodaj(s1,izborniPredmet2);
        izbori.dodaj(s1,izborniPredmet3);
        izbori.dodaj(s1,izborniPredmet4);
        izbori.dodaj(s1,izborniPredmet5);
        izbori.dodaj(s1,izbornaGrupa1);
        izbori.dodaj(s1,izbornaGrupa2);
        izbori.dodaj(s1,izborniModul1);
        izbori.dodaj(s1,izborniModul2);

        izbori.dodaj(s2,izborniPredmet1);
        izbori.dodaj(s2,izborniPredmet2);
        izbori.dodaj(s2,izborniPredmet3);
        izbori.dodaj(s2,izborniPredmet4);
        izbori.dodaj(s2,izborniPredmet5);
        izbori.dodaj(s2,izbornaGrupa1);
        izbori.dodaj(s2,izbornaGrupa2);
        izbori.dodaj(s2,izborniModul1);
        izbori.dodaj(s2,izborniModul2);

        izbori.Ispis();
    }
}
