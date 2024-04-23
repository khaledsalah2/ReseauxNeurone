package Test;

import Donnees.Echantillon;
import Donnees.LotEchantillons;
import Neurone.NeuroneSortie;

public class TestReseauOU {
    public static void main(String[] args) {
        // Poids et biais pour la fonction OU
        double[] poids = {1.0, 1.0};
        double biais = -0.5;

        // Création du neurone de sortie
        NeuroneSortie neuroneSortie = new NeuroneSortie(poids, biais);

        // Création des échantillons
        Echantillon[] echantillons = {
            new Echantillon(new int[]{0, 0}, 0),
            new Echantillon(new int[]{0, 1}, 1),
            new Echantillon(new int[]{1, 0}, 1),
            new Echantillon(new int[]{1, 1}, 1)
        };

        // Création du lot d'échantillons
        LotEchantillons lotEchantillons = new LotEchantillons(echantillons);

        // Affichage des échantillons
        lotEchantillons.afficherEchantillons();

        // Vérification du bon fonctionnement du réseau
        for (Echantillon echantillon : echantillons) {
            int sortieCalculee = neuroneSortie.activer(echantillon.getEntrees());
            System.out.println("Sortie calculée: " + sortieCalculee +
                               " Sortie attendue: " + echantillon.getSortieAttendue());
        }
    }
}