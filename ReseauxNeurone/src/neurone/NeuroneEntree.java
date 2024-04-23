package neurone;

public class NeuroneEntree extends Neurone {

    public NeuroneEntree(int nbNeuronesSuivantes) {
    super(nbNeuronesSuivantes);
    }
    
	@Override
	public double CalculerValeur(double[] entrees) {
		return entrees[0];
	}
       
}
