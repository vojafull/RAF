package Obuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Coursera coursera= Coursera.getInstance();

        Profesor profesor1=new Profesor("Gospodin","Kruskica","11111", Oblast.SLIKARSTVO);
        Profesor profesor2=new Profesor("Kem","Bridz","35231", Oblast.PROGRAMIRANJE);

        Projekat projekat1=new Projekat("Kruske",2,Oblast.SLIKARSTVO,5);
        Projekat projekat2=new Projekat("Most",2,Oblast.PROGRAMIRANJE,3);

        Kurs kurs=new Kurs("KURS",3,Oblast.SLIKARSTVO,true);

        Polaznik p1=new Polaznik("Marko1","Marko1","mejl1@gmail.com");
        Polaznik p2=new Polaznik("Marko2","Marko2","mejl2@gmail.com");
        Polaznik p3=new Polaznik("Marko3","Marko3","mejl3@gmail.com");
        Polaznik p4=new Polaznik("Marko4","Marko4","mejl4@gmail.com");
        Polaznik p5=new Polaznik("Marko5","Marko5","mejl5@gmail.com");

        profesor1.registruj(projekat1);
        profesor2.registruj(projekat2);

        p1.registruj(projekat1);
        p1.registruj(projekat2);
        p2.registruj(projekat1);
        p2.registruj(projekat2);
        p3.registruj(projekat1);

        Tim tim=new Tim(p1); // vodja

        tim.dodajPolaznika(p5);
        tim.dodajPolaznika(p3);
        tim.dodajPolaznika(p4);

        tim.registruj(projekat2);

        List<Registracija> registracijaList=new ArrayList<>();
        List<Obuka> obukaList=new ArrayList<>();

        registracijaList.add(profesor1);
        registracijaList.add(profesor2);
        registracijaList.add(p1);
        registracijaList.add(p2);
        registracijaList.add(p3);
        registracijaList.add(p4);
        registracijaList.add(p5);

        obukaList.add(projekat1);
        obukaList.add(projekat2);
        obukaList.add(kurs);

        coursera.setObuke(obukaList);
        coursera.setRegistracije(registracijaList);

        coursera.Ispis();
    }
}
