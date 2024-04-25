package reseau;

import couche.*;
import donnees.Echantillon;
import donnees.LotsEchantillons;
import neurone.NeuroneCachee;
import neurone.NeuroneSortie;

public class ReseauNeurones {
    private CoucheEntree coucheEntree;
    private CoucheCachee coucheCachee;
    private CoucheSortie coucheSortie;

    public ReseauNeurones(CoucheEntree coucheEntree, CoucheCachee coucheCachee, CoucheSortie coucheSortie) {
        this.coucheEntree = coucheEntree;
        this.coucheCachee = coucheCachee;
        this.coucheSortie = coucheSortie;
    }

    // Méthode pour propager les entrées à travers le réseau
    public double[] propagationAvant(double[] entrees) {
        double[] sortiesCoucheEntree = coucheEntree.traiterEntrees(entrees);
        return coucheCachee.traiterEntrees(sortiesCoucheEntree);
    }

    // Méthode pour obtenir les sorties de la couche de sortie
    public double[] getSorties() {
        return coucheSortie.getSorties();
    }

    // Méthodes pour la rétropropagation
    public void calculerGradient(double[] erreurs) {
        coucheSortie.calculerGradient(erreurs);
    }

    public void retropropagerErreurEtGradient(double[] erreurs) {
        coucheCachee.retropropagerErreur(erreurs, coucheSortie);
    }

    public void miseAJourPoids(double tauxApprentissage) {
        coucheCachee.miseAJourPoids(tauxApprentissage);
        coucheSortie.miseAJourPoids(tauxApprentissage);
    }    
    
    public void retropropagation(LotsEchantillons lots, double tauxApprentissage) {
        for (Echantillon echantillon : lots.getEchantillons()) {
            double[] sorties = this.propagationAvant(echantillon.getEntrees());
            double erreur = echantillon.getResultatAttendu() - sorties[0];

            // Calcul du delta pour la couche de sortie
            ((NeuroneSortie)coucheSortie.getNeurones()[0]).calculerDelta(erreur);

            // Rétropropagation de l'erreur à la couche cachée et calcul des deltas
            for (int i = 0; i < coucheCachee.getNombreNeurones(); i++) {
                NeuroneCachee neurone = (NeuroneCachee) coucheCachee.getNeurones()[i];
                double erreurCachee = erreur * coucheSortie.getNeurones()[0].getPoids()[i];
                neurone.calculerDelta(erreurCachee);
            }

            // Mise à jour des poids de la couche de sortie
            coucheSortie.getNeurones()[0].ajusterPoids(tauxApprentissage, coucheCachee.getSorties());

            // Mise à jour des poids de la couche cachée
            for (Neurone neurone : coucheCachee.getNeurones()) {
                neurone.ajusterPoids(tauxApprentissage, coucheEntree.getSorties());
            }
        }
    }

    // Les méthodes propagationAvant, getSorties de CoucheEntree et CoucheCachee devront être implémentées.
}
