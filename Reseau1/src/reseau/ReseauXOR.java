package reseau;

import couche.*;
import neurone.NeuroneBinaire;

public class ReseauXOR extends ReseauDeNeurones {
	
    public ReseauXOR() throws Exception {
        super(new CoucheEntree(2, 2), new CoucheCachee(2, 2), new CoucheSortie(1, 2));

        // Configuration des poids et des biais pour la couche cachée
        for (int i = 0; i < getCouches()[1].getNeurones().length; i++) {
            getCouches()[1].getNeurones()[i].setPoids(new double[]{1.0, 1.0});
            getCouches()[1].getNeurones()[i].setBiais(i == 0 ? -0.5 : -1.5);
        }

        // Configuration des poids et des biais pour la couche de sortie
        getCouches()[2].getNeurones()[0].setPoids(new double[]{1.0, -1.0});
        getCouches()[2].getNeurones()[0].setBiais(0.5);
    }
}
