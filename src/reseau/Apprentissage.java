package reseau;

import donnees.Echantillon;
import donnees.LotsEchantillons;

// Cette classe contiendra l'algorithme de rétropropagation pour le réseau de neurones
public class Apprentissage {

    public static void retropropagation(ReseauNeurones reseau, LotsEchantillons lots, double tauxApprentissage) {
        for (Echantillon echantillon : lots.getEchantillons()) {
            // 1. Propager les entrées à travers le réseau
            double[] sorties = reseau.propagationAvant(echantillon.getEntrees());

            // 2. Calculer l'erreur et le gradient sur la couche de sortie
            double[] erreurs = calculErreurSortie(echantillon.getResultatAttendu(), sorties);
            reseau.getCoucheSortie().calculerGradient(erreurs);

            // 3. Rétropropager l'erreur et calculer les gradients pour les couches cachées
            reseau.retropropagerErreurEtGradient(erreurs);

            // 4. Ajuster les poids du réseau
            reseau.miseAJourPoids(tauxApprentissage);
        }
    }

    private static double[] calculErreurSortie(double resultatAttendu, double[] sorties) {
        double[] erreurs = new double[sorties.length];
        for (int i = 0; i < sorties.length; i++) {
            erreurs[i] = resultatAttendu - sorties[i];
        }
        return erreurs;
    }
}
