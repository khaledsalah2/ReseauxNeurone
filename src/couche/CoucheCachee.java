package couche;

import neurone.*;

public class CoucheCachee extends Couche {
    public CoucheCachee(int nombreNeurones) {
        super(nombreNeurones, TypeCouche.CACHEE);
    }

    @Override
    public void envoyerSignal() {
        // Logique spécifique pour la couche cachée
    }
    
    public double[] traiterEntrees(double[] entrees) {
        double[] sorties = new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
            sorties[i] = ((NeuroneCachee)neurones[i]).activer(entrees);
        }
        return sorties;
    }

    public void retropropagerErreur(double[] erreurs, CoucheSortie coucheSortie) {
        // Calculer l'erreur pour chaque neurone de la couche cachée basée sur la couche de sortie
    }

    public void miseAJourPoids(double tauxApprentissage) {
        // Mettre à jour les poids de chaque neurone basé sur les deltas calculés
    }
}
