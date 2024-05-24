package apprentissage;

import echantillons.Echantillon;
import reseau.ReseauDeNeurones;
import couche.Couche;
import neurone.Neurone;

public class Apprentissage {
    private ReseauDeNeurones reseau;

    public Apprentissage(ReseauDeNeurones reseau) {
        this.reseau = reseau;
    }

    public double calculerCout(Echantillon echantillon, double[] sorties) {
        double[] sortiesSouhaitees = echantillon.getSortieSouhaiteeL();
        double cout = 0.0;
        for (int i = 0; i < sorties.length; i++) {
            cout += Math.pow(sorties[i] - sortiesSouhaitees[i], 2);
        }
        return cout / sorties.length;
    }

    public void retropropager(Echantillon echantillon, double[] sorties, double tauxApprentissage) {
        double[] sortiesSouhaitees = echantillon.getSortieSouhaiteeL();
        double[] erreurs = new double[sorties.length];

        // Calculer l'erreur de sortie
        for (int i = 0; i < sorties.length; i++) {
            erreurs[i] = sorties[i] - sortiesSouhaitees[i];
        }

        // Rétropropagation des erreurs à travers les couches
        for (int l = reseau.getCouches().length - 1; l >= 0; l--) {
            Couche couche = reseau.getCouches()[l];
            double[] nouvellesErreurs = new double[couche.getNeurones()[0].getPoids().length]; // Assurez-vous que cela reflète la dimension correcte

            for (int i = 0; i < couche.getNeurones().length; i++) {
                Neurone neurone = couche.getNeurones()[i];
                double erreurNeurone = erreurs[i];

                // Mise à jour des poids et des biais
                for (int j = 0; j < neurone.getPoids().length; j++) {
                    neurone.getPoids()[j] -= tauxApprentissage * erreurNeurone * neurone.getDerniereEntree()[j];
                    nouvellesErreurs[j] = (nouvellesErreurs[j] + neurone.getPoids()[j] * erreurNeurone) / couche.getNeurones().length;
                }
                neurone.setBiais(neurone.getBiais() - tauxApprentissage * erreurNeurone);
            }
            erreurs = nouvellesErreurs;
        }
    
    }
}
