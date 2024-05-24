package neurone;

public class NeuroneCache extends Neurone {
//	 public NeuroneCache(double[] poids, double seuil) {
//	        super(poids, seuil);
//	    }
	
    public NeuroneCache(int nombreEntrees) {
        super(nombreEntrees);
    }

    @Override
    public double activer(double[] entrees) {
        System.arraycopy(entrees, 0, this.derniereEntree, 0, entrees.length); // Met à jour derniereEntree
        double somme = biais;
        for (int i = 0; i < poids.length; i++) {
            somme += poids[i] * entrees[i];
        }
        return sigmoid(somme); // Utilise une fonction d'activation, par exemple sigmoid
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}