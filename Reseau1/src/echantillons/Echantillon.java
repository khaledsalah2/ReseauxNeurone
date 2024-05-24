package echantillons;

public class Echantillon {
    private double[] entrees;
    private double sortieSouhaitee;
    private double[] sortieSouhaiteeL;

    public Echantillon(double[] entrees, double sortieSouhaitee) {
        this.entrees = entrees;
        this.sortieSouhaitee = sortieSouhaitee;
    }
    public Echantillon(double[] entrees, double[] sortieSouhaitee) {
        this.entrees = entrees;
        this.sortieSouhaiteeL = sortieSouhaitee;
    }

    public double[] getEntrees() {
        return entrees;
    }

    public double getSortieSouhaitee() {
        return sortieSouhaitee;
    }
	
    public double[] getSortieSouhaiteeL() {
		return sortieSouhaiteeL;
	}

	
}