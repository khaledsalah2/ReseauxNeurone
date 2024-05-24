package couche;

import neurone.*;

public class CoucheBinaire extends Couche{
	 public CoucheBinaire(int nombreNeurones, int nombreEntrees) throws Exception {
	        super(nombreNeurones, nombreEntrees, NeuroneBinaire.class);
	    }

	    @Override
	    public double[] traiterEntrees(double[] entrees) {
	        double[] sorties = new double[neurones.length];
	        for (int i = 0; i < neurones.length; i++) {
	            sorties[i] = neurones[i].activer(entrees);
	        }
	        return sorties;
	    }
}
