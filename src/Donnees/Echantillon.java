package Donnees;

public class Echantillon {
    private double[] entrees;
    private int sortieAttendue;

    public Echantillon(double[] entrees, int sortieAttendue) {
        this.entrees = entrees;
        this.sortieAttendue = sortieAttendue;
    }

    public double[] getEntrees() {
        return entrees;
    }

    public int getSortieAttendue() {
        return sortieAttendue;
    }
}
