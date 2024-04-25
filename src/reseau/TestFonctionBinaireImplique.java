package reseau;

import donnees.Echantillon;
import donnees.EchantillonImplique;
import donnees.LotsEchantillons;
import neurone.NeuroneSortie;

import java.util.Arrays;

public class TestFonctionBinaireImplique {
    public static void main(String[] args) {
        // Création des échantillons pour la fonction IMPLIQUE
        LotsEchantillons lotsImplique = new LotsEchantillons();
        lotsImplique.ajouterEchantillon(new EchantillonImplique(new double[]{0, 0}, 1));
        lotsImplique.ajouterEchantillon(new EchantillonImplique(new double[]{0, 1}, 1));
        lotsImplique.ajouterEchantillon(new EchantillonImplique(new double[]{1, 0}, 0));
        lotsImplique.ajouterEchantillon(new EchantillonImplique(new double[]{1, 1}, 1));

        // Configuration du neurone de sortie pour la fonction IMPLIQUE
        NeuroneSortie neuroneSortieImplique = new NeuroneSortie(new double[]{-1, 1}, 0);

        // Test du réseau pour la fonction IMPLIQUE
        System.out.println("Test du réseau pour la fonction IMPLIQUE:");
        for (Echantillon echantillon : lotsImplique.getEchantillons()) {
            double[] entrees = echantillon.getEntrees();
            double sortieCalculee = neuroneSortieImplique.activer(entrees);
            System.out.println("Entrées: " + Arrays.toString(entrees) +
                               " Sortie calculée: " + sortieCalculee +
                               " Résultat attendu: " + echantillon.getResultatAttendu());
        }
    }
}
