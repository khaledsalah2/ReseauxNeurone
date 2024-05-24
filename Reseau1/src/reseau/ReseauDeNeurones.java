
package reseau;

import couche.Couche;

public class ReseauDeNeurones {
    private Couche[] couches;

    public ReseauDeNeurones(Couche... couches) {
        this.couches = couches;
    }

    public double[] propagerAvant(double[] entrees) {
        double[] sorties = entrees;
        for (Couche couche : couches) {
            sorties = couche.traiterEntrees(sorties);
        }
        return sorties;
    }

    public Couche[] getCouches() {
        return couches;
    }
}