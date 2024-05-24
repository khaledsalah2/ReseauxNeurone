
package couche;

import neurone.NeuroneCache;

public class CoucheCachee extends Couche {
    public CoucheCachee(int nombreNeurones, int nombreEntrees) throws Exception {
        super(nombreNeurones, nombreEntrees, NeuroneCache.class);
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