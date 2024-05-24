
package neurone;

import java.util.Arrays;

public abstract class Neurone {
    protected double[] poids; // Coefficients associés à chaque connexion entrante
    protected double biais;   // Seuil pour l'activation du neurone
    protected double[] derniereEntree; // Stocke les dernières entrées pour la rétropropagation

    public Neurone(int nombreEntrees) {
        this.poids = new double[nombreEntrees];
        this.derniereEntree = new double[nombreEntrees];
        for (int i = 0; i < nombreEntrees; i++) {
            this.poids[i] = Math.random() * 0.1 - 0.05; // Initialisation aléatoire des poids
        }
        this.biais = Math.random() * 0.1 - 0.05; // Initialisation aléatoire du biais
    }

    // Méthode abstraite pour activer le neurone avec une fonction spécifique
    public abstract double activer(double[] entrees);

    public double[] getPoids() {
        return poids;
    }

    public double getBiais() {
        return biais;
    }

    public void setBiais(double biais) {
        this.biais = biais;
    }

    public double[] getDerniereEntree() {
        return derniereEntree;
    }
    
    public void afficherInfos() {
        System.out.println("Poids: " + Arrays.toString(poids) + ", Biais: " + biais);
    }

	public void setPoids(double[] poids) {
		this.poids = poids;
	}
	
	

}