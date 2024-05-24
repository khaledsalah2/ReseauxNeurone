package neurone;

public class NeuroneBinaire extends Neurone {

	// Constructeur utilisant le constructeur de la superclasse
	public NeuroneBinaire(int nombreEntrees) {
		super(nombreEntrees); // Appelle le constructeur de la classe parente
	}

	@Override
	public double activer(double[] entrees) {
		if (this.isConfiguredForXOR() && entrees.length == 2) { 
			// pour vérifier la config
			return (entrees[0] + entrees[1] == 1) ? 1.0 : 0.0; // XOR: vrai si la somme des entrées est exactement 1
		} else {
			double somme = -biais; // Commence par soustraire le biais
			for (int i = 0; i < entrees.length; i++) {
				somme += this.poids[i] * entrees[i];
			}
			return somme >= 0 ? 1.0 : 0.0; // Fonction seuil
		}
	}

	// Configuration pour différentes fonctions logiques
	public void configurerPourET() {
		java.util.Arrays.fill(poids, 1);
		biais = 1.5;
	}

	public void configurerPourOU() {
		java.util.Arrays.fill(poids, 1);
		biais = 0.5;
	}

	public void configurerPourNON() {
//		if (poids.length != 1) {
//			throw new IllegalArgumentException("NON nécessite exactement une entrée.");
//		}
		poids[0] = -1;
		biais = -0.5;
	}

	private boolean isConfiguredForXOR = false;

	public void configurerPourXOR() {
		java.util.Arrays.fill(poids, 1); // Poids à 1 pour chaque entrée
		biais = 0; // Biais n'affecte pas le résultat pour XOR
		isConfiguredForXOR = true;
	}

	private boolean isConfiguredForXOR() {
		return isConfiguredForXOR;
	}

	public void configurerPourImplication() {
//		if (poids.length != 2) {
//			throw new IllegalArgumentException("L'implication nécessite exactement deux entrées.");
//		}
		poids[0] = -1; // X négatif
		poids[1] = 1; // Y positif
		biais = -0.5; // X false (0) => Y true (1)
	}
}