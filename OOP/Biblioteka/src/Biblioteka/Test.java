package Biblioteka;

public class Test {
    public static void main(String[] args) {

        Pisac p1=new ProzniPisac("AA","AA",1966);
        Pisac p2=new ProzniPisac("BB","BB",1986);
        Pisac p3=new Pesnik("CC","CC",1746);

        Sakupljac s=new Sakupljac("Sakupljac");

        Biblioteka b=new Biblioteka("Bibl");

        Knjizevnost k1=p1.objavljuje("P1 KNJIGA 1",2001,TipKnjizevnosti.EPIKA);
        Knjizevnost k2=p1.objavljuje("AP1 KNJIGA 2",1241,TipKnjizevnosti.EPIKA);
        Knjizevnost k3=p1.objavljuje("P1 KNJIGA 3",3245,TipKnjizevnosti.EPIKA);
        Knjizevnost k9=p1.objavljuje("P1 KNJIGA 3",3245,TipKnjizevnosti.EPIKA);

        Knjizevnost k4=p2.objavljuje("zP2 KNJIGA 4",645,TipKnjizevnosti.EPIKA);
        Knjizevnost k5=p2.objavljuje("4P2 KNJIGA 4",645,TipKnjizevnosti.EPIKA);
        Knjizevnost k6=p2.objavljuje("P2 KNJIGA 6",5435,TipKnjizevnosti.EPIKA);
        Knjizevnost k0=p2.objavljuje("P2 KNJIGA 6",5435,TipKnjizevnosti.EPIKA);

        Knjizevnost k7=s.objavljuje("S KNJIGA 7",1532,TipKnjizevnosti.LIRSKO_EPSKI);
        Knjizevnost k8=s.objavljuje("S KNJIGA 8",4564,TipKnjizevnosti.LIRSKO_EPSKI);

        Knjizevnost k10=p3.objavljuje("P3 knjiga 345",34634,TipKnjizevnosti.LIRIKA);
        Knjizevnost k11=p3.objavljuje("dfgP3 knjiga 435",34634,TipKnjizevnosti.LIRIKA);
        Knjizevnost k12=p3.objavljuje("35p knjiga 12545",34634,TipKnjizevnosti.LIRIKA);

        b.dodajKnjigu(k1);
        b.dodajKnjigu(k2);
        b.dodajKnjigu(k3);
        b.dodajKnjigu(k4);
        b.dodajKnjigu(k5);
        b.dodajKnjigu(k6);
        b.dodajKnjigu(k7);
        b.dodajKnjigu(k8);
        b.dodajKnjigu(k9); // duplikat
        b.dodajKnjigu(k0); // duplikat
        b.dodajKnjigu(k10);
        b.dodajKnjigu(k11);
        b.dodajKnjigu(k12);

        b.IspisSvihKnjiga();

        Lektira tipskaLektira=new TipskaLektira(4,Skola.OSNOVNA,TipKnjizevnosti.EPIKA);
        Lektira kombinovanaLektira=new KombinovanaLektira(3,Skola.GIMAZIJA);

        Knjizevnost NEMA=p3.objavljuje("NEMA JE",2222,TipKnjizevnosti.LIRSKO_EPSKI);

        tipskaLektira.dodajKnjigu(NEMA,b);
        kombinovanaLektira.dodajKnjigu(NEMA,b);

        tipskaLektira.dodajKnjigu(k4,b);
        tipskaLektira.dodajKnjigu(k5,b);

        kombinovanaLektira.dodajKnjigu(k1,b);
        kombinovanaLektira.dodajKnjigu(k11,b);

        System.out.println("\n\nTIPSKA LEKTIRA\n");
        System.out.println(tipskaLektira.toString());

        System.out.println("\nKOMBINOVANA LEKTIRA\n");
        System.out.println(kombinovanaLektira.toString());

        kombinovanaLektira.upisFajl("kombinovanaLektira.txt");

    }
}
