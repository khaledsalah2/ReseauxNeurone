package ReseauxNeurones;

public class NeuroneCachee extends Neurone {

	public NeuroneCachee(int nbNeuronesSuivantes) {
		super(nbNeuronesSuivantes);
		
	}

	@Override
	public double CalculerValeur(double[] messageEntrant) {
		double somme = 0.0;
		for (int i = 0; i < messageEntrant.length; i++) {
			somme += messageEntrant[i] * poids[i];
		}
		double valeurSortie = 0.0;
		if(somme>= this.seuil) {
			valeurSortie = 1.0;
		}
		return valeurSortie;
	}

}
