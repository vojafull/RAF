package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Database;
import model.Kurs;
import model.KursAktivnost;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Forma extends VBox {

    private HBox hBox;
    private GridPane aktivnostGrid;
    private VBox dostupniVbox;
    private VBox mojiVbox;
    private VBox aktivnostVbox;
    private ListView<Kurs> dostupniKursevi;
    private ListView<Kurs> mojiKursevi;
    private Label dostupniKurseviLabel;
    private Label mojiKurseviLabel;
    private Label RAF;
    private Label Raspolozivo;
    private Label PocetakAkt;
    private Label TrajanjeAkt;
    private Label Sati;
    private Label Minuti;
    private Label Max;
    private Label Poruka;
    private Button DodajBttn;
    private Button OdgledajBttn;
    private Button SnimiBttn;
    private ComboBox<Integer> comboSati;
    private ComboBox<Integer> comboMinuti;
    private TableView<KursAktivnost> tableView;
    private TextField textField;


    public Forma(){
        init();
        placements();
        adjustments();
        tabela();
        actions();

        dostupniKursevi.getItems().addAll(Database.getInstance().getKursList());

    }

    private void actions(){

        DodajBttn.setOnAction(e->{
            Kurs izabran=dostupniKursevi.getSelectionModel().getSelectedItem();

            if(izabran!=null){
                if(mojiKursevi.getItems().contains(izabran)){
                    Poruka.setText("Kurs je vec dodat");
                }
                else if(izabran.getCena()>Database.getInstance().getRaspolozivo()) Poruka.setText("Nemate dovoljno raspolozivog novca");
                else{
                    Database.getInstance().smanjiRaspolozivo(izabran.getCena());
                    Raspolozivo.setText("Raspolozivo: "+Database.getInstance().getRaspolozivo());
                    mojiKursevi.getItems().add(izabran);
                    Poruka.setText("");
                }

            }
            else{
                Poruka.setText("Morate izabrati kurs");
            }


        });


        OdgledajBttn.setOnAction(actionEvent->{
            Integer minuti=comboMinuti.getSelectionModel().getSelectedItem();
            Integer sati=comboSati.getSelectionModel().getSelectedItem();
            Kurs izabran=mojiKursevi.getSelectionModel().getSelectedItem();
            if(minuti==null || sati==null || izabran==null){
                Poruka.setText("Morate uneti sve vrednosti");
            }
            else if(textField.getText().isEmpty()){
                Poruka.setText("Nepravilan unos trajanja");
            }

            else{
                int trajanje=0;
                try{
                trajanje=Integer.parseInt(textField.getText());
                }
                catch (Exception e){
                    Poruka.setText("Nepravilan unos trajanja");
                    return;
                }
                if  (trajanje<1 || trajanje>120) Poruka.setText("Nepravilan unos trajanja");
                Poruka.setText("");

                LocalDate danas= LocalDate.now();
                LocalTime pocetakVreme=LocalTime.of(sati,minuti);
                LocalDateTime pocetak=LocalDateTime.of(danas,pocetakVreme);
                LocalDateTime kraj=pocetak.plusMinutes(trajanje);

                KursAktivnost kursAktivnost11=null;

                for(KursAktivnost ka: tableView.getItems()){

                    if((!ka.getPocetak().isAfter(pocetak) && ka.getKraj().isAfter(pocetak)) || (!pocetak.isAfter(ka.getPocetak()) && kraj.isAfter(ka.getPocetak()))){
                        Poruka.setText("Aktivnost vec postoji za to vreme"); return;
                    }
                    else if(ka.getKurs().equals(izabran) && pocetak.isBefore(ka.getPocetak())){
                        Poruka.setText("Nije moguće da se doda aktivnost za neki kurs čiji početak je pre početka postojeće aktivnosti za taj isti kurs tog\n" +
                                "dana. ");
                    }

                    if(ka.getKurs().equals(izabran)&& (kursAktivnost11==null || !kursAktivnost11.getKraj().isAfter(ka.getPocetak()))){
                        kursAktivnost11=ka;
                    }

                }

                double kompletiranost= (kursAktivnost11!=null) ? kursAktivnost11.getKompletiranost()/100 : 0;


                kompletiranost+=(double)trajanje/izabran.getTrajanje();
                if(kompletiranost > 1.00) {
                    Poruka.setText("Aktivnost je vec zavrsena"); return;
                }
                KursAktivnost ka=new KursAktivnost(izabran,pocetak,kraj,kompletiranost*100);
                tableView.getItems().add(ka);



            }

        });

        SnimiBttn.setOnAction(e->{

            if(tableView.getItems().isEmpty()) {
                Poruka.setText("Greska"); return;
            }
            else{

                Map<String,Map<Kurs, List<KursAktivnost>>> kategorisano=new HashMap<>();

                for(KursAktivnost ka:tableView.getItems()){
                    if(!kategorisano.containsKey(ka.getKurs().getKategorija())){
                        kategorisano.put(ka.getKurs().getKategorija(),new HashMap<>());
                    }

                    Map<Kurs, List<KursAktivnost>> kursevi=kategorisano.get(ka.getKurs().getKategorija());
                    if(!kursevi.containsKey(ka.getKurs())){
                        kursevi.put(ka.getKurs(),new ArrayList<>());
                    }

                    List<KursAktivnost> lista=kursevi.get(ka.getKurs());
                    lista.add(ka);

                }

                try {
                    BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("izlaz.txt"));
                    StringBuilder sb=new StringBuilder();

                    for (String kategorija: kategorisano.keySet()){
                        sb.append("Kategorija: ").append(kategorija);
                        for(Kurs k: kategorisano.get(kategorija).keySet()){
                                sb.append("\n\tNaziv kursa: ").append(k.getNaziv());
                                double kompletiranost=0;
                                for(KursAktivnost ka: kategorisano.get(kategorija).get(k)){
                                    sb.append("\n\t").append(ka);
                                    kompletiranost=ka.getKompletiranost();
                                }
                                sb.append("\n\tUkupno kompletirano: ").append(kompletiranost);

                        }

                    }

                    bufferedWriter.write(sb.toString());
                    bufferedWriter.close();


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

    }

    private void tabela(){

        TableColumn kursCol=new TableColumn("Kurs");
        TableColumn kategorijaCol=new TableColumn("Kategorija");
        TableColumn pocetakDatumCol=new TableColumn("Pocetak(Datum)");
        TableColumn pocetakVremeCol=new TableColumn("Pocetak(Vreme)");
        TableColumn krajDatumCol=new TableColumn("Kraj(Datum)");
        TableColumn krajVremeCol=new TableColumn("Kraj(Vreme)");
        TableColumn kompletiranostCol=new TableColumn("Kompletiranost");

        tableView.getColumns().addAll(kursCol,kategorijaCol,pocetakDatumCol,pocetakVremeCol,krajDatumCol,krajVremeCol,kompletiranostCol);

        kursCol.setPrefWidth(200);
        kategorijaCol.setPrefWidth(120);
        pocetakVremeCol.setPrefWidth(120);
        pocetakDatumCol.setPrefWidth(120);
        krajVremeCol.setPrefWidth(120);
        krajDatumCol.setPrefWidth(120);
        kompletiranostCol.setPrefWidth(120);

        kursCol.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        kategorijaCol.setCellValueFactory(new PropertyValueFactory<>("kategorija"));
        pocetakDatumCol.setCellValueFactory(new PropertyValueFactory<>("pocetakDatum"));
        pocetakVremeCol.setCellValueFactory(new PropertyValueFactory<>("pocetakVreme"));
        krajDatumCol.setCellValueFactory(new PropertyValueFactory<>("krajDatum"));
        krajVremeCol.setCellValueFactory(new PropertyValueFactory<>("krajVreme"));
        kompletiranostCol.setCellValueFactory(new PropertyValueFactory<>("kompletiranost"));

    }
    private void adjustments(){
        hBox.setAlignment(Pos.CENTER);
        this.setAlignment(Pos.CENTER);
        mojiVbox.setAlignment(Pos.CENTER);
        dostupniVbox.setAlignment(Pos.CENTER);
        aktivnostGrid.setAlignment(Pos.CENTER);
        aktivnostVbox.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        hBox.setPadding(new Insets(10));
        this.setSpacing(16);
        textField.setPrefColumnCount(3);
        this.setSpacing(10);
        dostupniKursevi.setPrefWidth(400);
        mojiKursevi.setPrefWidth(400);
        aktivnostGrid.setHgap(5);
        aktivnostGrid.setVgap(5);
        Poruka.setAlignment(Pos.CENTER);
        aktivnostVbox.setSpacing(20);
        aktivnostVbox.setPadding(new Insets(50));
        hBox.setSpacing(20);

    }

    private void placements(){

        dostupniVbox.getChildren().addAll(dostupniKurseviLabel,dostupniKursevi);

        mojiVbox.getChildren().addAll(mojiKurseviLabel,mojiKursevi);



        aktivnostGrid.add(Sati,0,1);
        aktivnostGrid.add(comboSati,1,1);
        aktivnostGrid.add(Minuti,2,1);
        aktivnostGrid.add(comboMinuti,3,1);
        aktivnostGrid.add(PocetakAkt,1,0,2,1);
        aktivnostGrid.add(TrajanjeAkt,1,2,2,1);
        aktivnostGrid.add(textField,1,3);
        aktivnostGrid.add(Max,2,3,2,1);
        aktivnostVbox.getChildren().addAll(aktivnostGrid,OdgledajBttn,Poruka);

        hBox.getChildren().addAll(dostupniVbox,DodajBttn,mojiVbox,aktivnostVbox);

        this.getChildren().addAll(RAF,Raspolozivo,hBox,tableView,SnimiBttn);
    }

    private void init(){

        hBox=new HBox(5);
        RAF=new Label("RAF Coursera");
        dostupniKurseviLabel=new Label("Dostupni Kursevi:");
        mojiKurseviLabel=new Label("Moji Kursevi:");
        Raspolozivo=new Label("Raspolozivo: 1000$");
        DodajBttn=new Button("Dodaj kurs");
        aktivnostGrid=new GridPane();
        dostupniVbox=new VBox(10);
        mojiVbox=new VBox(10);
        aktivnostVbox=new VBox(25);
        Sati=new Label("Sati");
        Minuti=new Label("Minuti");
        PocetakAkt=new Label("Pocetak aktivnosti: ");
        TrajanjeAkt=new Label("Trajanje aktivnosti: ");
        textField=new TextField();
        comboMinuti=new ComboBox<>();
        comboSati=new ComboBox<>();
        OdgledajBttn=new Button("Odgledaj");
        Poruka=new Label();
        SnimiBttn=new Button("Snimi aktivnosti");
        tableView=new TableView<>();
        Max=new Label("(max 120 min)");
        dostupniKursevi=new ListView<>();
        mojiKursevi=new ListView<>();

        List<Integer> integerList=new ArrayList<>();
        ObservableList<Integer> list= FXCollections.observableList(integerList);
        for(int i=0; i<24;i++){
            integerList.add(i);
        }
        comboSati.setItems(list);

        List<Integer> integerList1=new ArrayList<>();
        ObservableList<Integer> list1= FXCollections.observableList(integerList1);
        for(int i=0; i<60;i+=5){
            integerList1.add(i);
        }
        comboMinuti.setItems(list1);
    }

}
