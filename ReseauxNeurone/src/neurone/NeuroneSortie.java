package neurone;

public class NeuroneSortie extends Neurone{
	
	public NeuroneSortie() {
		super(0);
	}

	@Override
	public double CalculerValeur(double[] entrees) {
		double somme = 0.0;
        for (double entree : entrees) {
            somme += entree;
        }
        return somme > seuil ? 1.0 : 0.0; 
    }

	public void setseuil(double random) {
		
	}
}
