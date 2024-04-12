package Obuke;

import java.util.ArrayList;
import java.util.List;

public class Kurs extends Obuka{

    private boolean onlajn;

    private List<Kurs> preduslovi=new ArrayList<>();
    public Kurs(String naziv, int minimalanBrojPolaznika, Oblast oblast, boolean onlajn) {
        super(naziv, minimalanBrojPolaznika, oblast);
        this.onlajn = onlajn;
    }

    public boolean isOnlajn() {
        return onlajn;
    }

    public void setOnlajn(boolean onlajn) {
        this.onlajn = onlajn;
    }

    public List<Kurs> getPreduslovi() {
        return preduslovi;
    }

    public void setPreduslovi(List<Kurs> preduslovi) {
        this.preduslovi = preduslovi;
    }
}
