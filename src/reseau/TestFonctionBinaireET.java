package reseau;

import neurone.NeuroneSortie;
import donnees.Echantillon;
import donnees.EchantillonET;
import donnees.LotsEchantillons;

import java.util.Arrays;

public class TestFonctionBinaireET {
    public static void main(String[] args) {
    	// Création des échantillons pour la fonction ET
        LotsEchantillons lotsET = new LotsEchantillons();
        lotsET.ajouterEchantillon(new EchantillonET(new double[]{0, 0}, 0));
        lotsET.ajouterEchantillon(new EchantillonET(new double[]{0, 1}, 0));
        lotsET.ajouterEchantillon(new EchantillonET(new double[]{1, 0}, 0));
        lotsET.ajouterEchantillon(new EchantillonET(new double[]{1, 1}, 1));

        // Logique fictive pour la démonstration
        // Normalement, le réseau serait construit et configuré ici
        // On suppose que le réseau est déjà entraîné avec les poids et seuils corrects
        NeuroneSortie neuroneSortie = new NeuroneSortie(new double[]{1, 1}, 1.5); // Poids et seuil pour la fonction ET

        // Test du réseau pour la fonction ET
        System.out.println("Test du réseau pour la fonction ET:");
        for (Echantillon echantillon : lotsET.getEchantillons()) {
            double[] entrees = echantillon.getEntrees();
            double sortieCalculee = neuroneSortie.activer(entrees);
            System.out.println("Entrées: " + Arrays.toString(entrees) +
                               " Sortie calculée: " + sortieCalculee +
                               " Résultat attendu: " + echantillon.getResultatAttendu());
        }
    }
}
