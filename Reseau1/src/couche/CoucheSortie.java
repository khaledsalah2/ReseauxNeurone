package couche;

import neurone.NeuroneSortie;

public class CoucheSortie extends Couche {
    public CoucheSortie(int nombreNeurones, int nombreEntrees) throws Exception {
        super(nombreNeurones, nombreEntrees, NeuroneSortie.class);
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