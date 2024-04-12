package Obuke;

public class Projekat extends Obuka{

    private int maksimalanBrojPolaznika;

    public Projekat(String naziv, int minimalanBrojPolaznika, Oblast oblast, int maksimalanBrojPolaznika) {
        super(naziv, minimalanBrojPolaznika, oblast);
        this.maksimalanBrojPolaznika = maksimalanBrojPolaznika;
    }

    public int getMaksimalanBrojPolaznika() {
        return maksimalanBrojPolaznika;
    }

    public void setMaksimalanBrojPolaznika(int maksimalanBrojPolaznika) {
        this.maksimalanBrojPolaznika = maksimalanBrojPolaznika;
    }
}
