package ReseauxNeurones;

public class NeuroneEntree extends Neurone {
	private double message;
	

    
    public NeuroneEntree(int nbNeuronesSuivantes) {
    super(nbNeuronesSuivantes);
    this.message = message;
    }
    
    public double getMessage() {
    	return this.message;
    }

	@Override
	public double CalculerValeur(double[] messageEntrant) {
	   return this.message;
	}
    
    
}
