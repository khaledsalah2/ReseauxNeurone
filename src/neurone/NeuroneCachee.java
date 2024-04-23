package neurone;

public class NeuroneCachee extends Neurone {

	public NeuroneCachee(int nbNeuronesSuivantes) {
		super(nbNeuronesSuivantes);
	}

	@Override
	public double CalculerValeur(double[] entrees) {
		double somme = 0.0;
		for (int i = 0; i < entrees.length; i++) {
			somme += entrees[i] * poids[i];
		}
		
        return somme > seuil ? 1.0 : 0.0; 
    }

}
