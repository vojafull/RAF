package rafchatmessages;

public class ChatApp {
    public static void main(String[] args) {
        Chat chat = new Chat();

        Emojis.getEmojis().dodajEmoji("happy", ":)");
        Emojis.getEmojis().dodajEmoji("sad", ":(");
        Emojis.getEmojis().dodajEmoji("heart", "<3");
        Emojis.getEmojis().dodajEmoji("shocked", ":O");
        Emojis.getEmojis().dodajEmoji("funny", ":O");

        TekstualnaPoruka tp1 = new TekstualnaPoruka("Mihajlo", "dgashjdfa");
        TekstualnaPoruka tp2 = new TekstualnaPoruka("Aleksa", "dshjagdhj");

        EmojiPoruka ep1 = new EmojiPoruka("Ana",
                Emojis.getEmojis().getEmojiByNaziv("heart"));
        EmojiPoruka ep2 = new EmojiPoruka("Masa",
                Emojis.getEmojis().getEmojiByNaziv("happy"));

        KombinovanaPoruka kp1 = new KombinovanaPoruka("Anja");
        kp1.dodajUSadrzinu(new TekstualnaPoruka("Anja", "gdsahjdfgh"));
        kp1.dodajUSadrzinu(new EmojiPoruka("Anja",
                Emojis.getEmojis().getEmojiByNaziv("heart")));

        KombinovanaPoruka kp2 = new KombinovanaPoruka("Filip");
        kp2.dodajUSadrzinu(new TekstualnaPoruka("Filip", "gdajdfhadfah"));

        ViseEmojijaPoruka vep1 = new ViseEmojijaPoruka("Mihajlo");
        vep1.dodajUSadrzinu(
                Emojis.getEmojis().getEmojiByNaziv("sad"),
                Emojis.getEmojis().getEmojiByNaziv("heart"),
                Emojis.getEmojis().getEmojiByNaziv("happy"));

        ViseEmojijaPoruka vep2 = new ViseEmojijaPoruka("Lazar");
        vep2.dodajUSadrzinu(Emojis.getEmojis().getEmojiByNaziv("sad"));

        chat.napisiPoruku(tp1);
        chat.napisiPoruku(tp2);
        chat.napisiPoruku(ep1);
        chat.napisiPoruku(ep2);
        chat.napisiPoruku(kp1);
        chat.napisiPoruku(kp2);
        chat.napisiPoruku(vep1);
        chat.napisiPoruku(vep2);

        for (Poruka p : chat.getPoruke())
            System.out.println(p.formirajIspis());

        FileUtils.writeEmojis(Emojis.getEmojis().getEmojije());

    }
}
