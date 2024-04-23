package test;

import Donnees.Echantillon;
import Donnees.LotEchantillons;
import neurone.NeuroneSortie;

public class TestReseauET {
    public static void main(String[] args) {
        // Poids et biais pour la fonction ET
        double[] poids = {1.0, 1.0};
        double biais = -1.5;

        // Création du neurone de sortie
        NeuroneSortie neuroneSortie = new NeuroneSortie();

        // Création des échantillons
        Echantillon[] echantillons = {
            new Echantillon(new int[]{0, 0}, 0),
            new Echantillon(new int[]{0, 1}, 0),
            new Echantillon(new int[]{1, 0}, 0),
            new Echantillon(new int[]{1, 1}, 1)
        };

        // Création du lot d'échantillons
        LotEchantillons lotEchantillons = new LotEchantillons(echantillons);

        // Affichage des échantillons
        lotEchantillons.afficherEchantillons();

        // Vérification du bon fonctionnement du réseau
        for (Echantillon echantillon : echantillons) {
            double sortieCalculee = neuroneSortie.CalculerValeur(echantillon.getEntrees());
            System.out.println("Sortie calculée: " + sortieCalculee +
                               " Sortie attendue: " + echantillon.getSortieAttendue());
        }
    }
}
