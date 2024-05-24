package couche;

import neurone.NeuroneEntree;

public class CoucheEntree extends Couche {
    public CoucheEntree(int nombreNeurones, int nombreEntrees) throws Exception {
        super(nombreNeurones, nombreEntrees, NeuroneEntree.class);
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