package ReseauxNeurones;

public class NeuroneSortie extends Neurone{
	private double biais;
	
	public NeuroneSortie(int nbNeuronesSuivantes) {
		super(nbNeuronesSuivantes);
	
	}
	public NeuroneSortie(int nbNeuronesSuivantes, double biais) {
		super(nbNeuronesSuivantes);
		this.biais = biais;
	}

	public double getBiais() {
		return this.biais;
	}
	public void setBiais(double biais) {
		this.biais = biais;
	}
	@Override
	public double CalculerValeur(double[] messageEntrant) {
		double somme = 0.0;
		for (int i = 0; i< messageEntrant.length; i++) {
			somme += this.poids[i] * messageEntrant[i];
		}
        double valeurSortie = 0.0;
        if (somme + this.biais >= this.seuil) {
            valeurSortie = 1.0;
        }
		return valeurSortie;
	}
	public void afficherSortie() {}
	
}
