
package neurone;

public class NeuroneEntree extends Neurone {
//	 public NeuroneEntree(double[] poids, double seuil) {
//	        super(poids, seuil);
//	    }
    public NeuroneEntree(int nombreEntrees) {
        super(nombreEntrees);
    }

    @Override
    public double activer(double[] entrees) {
        System.arraycopy(entrees, 0, this.derniereEntree, 0, entrees.length); // Met à jour derniereEntree
        double somme = 0;
        for (int i = 0; i < poids.length; i++) {
            somme += poids[i] * entrees[i];
        }
        return somme; // Pas de fonction d'activation ici
    }
}