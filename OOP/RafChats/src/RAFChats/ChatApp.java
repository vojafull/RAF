package RAFChats;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatApp {
    public static void main(String[] args) {

       // List<Korisnik> korisnikList=new ArrayList<>();

        try{
            File file=new File("korisnici.txt");
            BufferedReader fr=new BufferedReader(new FileReader(file));

            String line=fr.readLine();

            while (line!=null){
                String[] lines=line.split(",");
                Korisnik k=new Korisnik(lines[0],lines[1],lines[2]);
                Svi.getSvi().getKorisnikList().add(k);
               // korisnikList.add(k);
                line=fr.readLine();
            }
            fr.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

        /*
        maree,Marko,MarkoC4r
        luleee,Luka,Pacovcina123
        */

        Korisnik atila=Svi.getSvi().prijava("Atila","Ahahaha123");
        Korisnik bic=Svi.getSvi().prijava("Bicuj","Ahahaha123");
        Korisnik po=Svi.getSvi().prijava("Poatan","Ahahaha123");
        Korisnik iva=Svi.getSvi().prijava("Lola","Ahahaha123");
        Korisnik dr=Svi.getSvi().prijava("Konjina","Ahahaha123");

        GroupChat groupChat1=new GroupChat();
        GroupChat groupChat2=new GroupChat();

        PublicChat publicChat1=new PublicChat();
        PublicChat publicChat2=new PublicChat();

        PrivateChat privateChat1=new PrivateChat(atila,bic);
        PrivateChat privateChat2=new PrivateChat(iva,dr);

        JustMeChat just1=new JustMeChat(po);
        JustMeChat just2=new JustMeChat(atila);

        groupChat1.dodajUGrupu(bic);
        groupChat1.dodajUGrupu(iva);
        groupChat1.dodajUGrupu(po);

        groupChat2.dodajUGrupu(atila);

        groupChat1.dodajPoruku(bic,"de");
        groupChat1.dodajPoruku(iva,"riba");
        groupChat1.dodajPoruku(po,"mu");

        groupChat2.dodajPoruku(atila,"KEKEKKEKEKEK");
        groupChat2.dodajPoruku(bic,"KEKEKKEKEKEK"); // ne moze

        publicChat1.dodajPoruku(atila,"IDEMOO");
        publicChat2.dodajPoruku(dr,"bumerang");

        privateChat1.dodajPoruku(atila,"JA");
        privateChat2.dodajPoruku(atila,"JA"); // ne moze
        privateChat2.dodajPoruku(iva,"aaaa");

        just1.dodajPoruku(po,"hmm");
        just2.dodajPoruku(atila,"boze");
        just2.dodajPoruku(iva,"boze"); // ne moze

        System.out.println(groupChat1.toString());
        System.out.println(groupChat2.toString());
        System.out.println(publicChat1.toString());
        System.out.println(publicChat2.toString());
        System.out.println(privateChat1.toString());
        System.out.println(privateChat2.toString());
        System.out.println(just1.toString());
        System.out.println(just2.toString());

    }
}
