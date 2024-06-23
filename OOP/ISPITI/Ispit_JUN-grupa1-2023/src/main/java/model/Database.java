package model;

import javafx.scene.chart.PieChart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Kurs> kursList=new ArrayList<>();
    private  static Database instance;

    private int raspolozivo=1000;

    private Database(){


        ucitajFajl();
    }

    public static Database getInstance(){
        if(instance==null) instance=new Database();
        return instance;
    }

    private void ucitajFajl(){

        File file=new File("RAF_Coursera.txt");
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String linija;

            while((linija=bufferedReader.readLine())!=null){
                // Introduction to Web Development,Technology>480 minutes:$99
                String[] split=linija.split("[,>$]");
                String naziv=split[0];
                String kategorija=split[1];
                int trajanje=Integer.parseInt(split[2].split(" ")[0]);
                int cena=Integer.parseInt(split[3]);

                Kurs kurs=new Kurs(naziv,kategorija,trajanje,cena);

                kursList.add(kurs);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void smanjiRaspolozivo(int broj){
        raspolozivo-=broj;
    }
    public List<Kurs> getKursList() {
        return kursList;
    }

    public int getRaspolozivo() {
        return raspolozivo;
    }
}
