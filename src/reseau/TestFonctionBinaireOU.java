package reseau;

import donnees.Echantillon;
import donnees.EchantillonOU;
import donnees.LotsEchantillons;
import neurone.NeuroneSortie;

import java.util.Arrays;

public class TestFonctionBinaireOU {
    public static void main(String[] args) {
        // Création des échantillons pour la fonction OU
        LotsEchantillons lotsOU = new LotsEchantillons();
        lotsOU.ajouterEchantillon(new EchantillonOU(new double[]{0, 0}, 0));
        lotsOU.ajouterEchantillon(new EchantillonOU(new double[]{0, 1}, 1));
        lotsOU.ajouterEchantillon(new EchantillonOU(new double[]{1, 0}, 1));
        lotsOU.ajouterEchantillon(new EchantillonOU(new double[]{1, 1}, 1));

        // Configuration du neurone de sortie pour la fonction OU
        NeuroneSortie neuroneSortieOU = new NeuroneSortie(new double[]{1, 1}, 0.5);

        // Test du réseau pour la fonction OU
        System.out.println("Test du réseau pour la fonction OU:");
        for (Echantillon echantillon : lotsOU.getEchantillons()) {
            double[] entrees = echantillon.getEntrees();
            double sortieCalculee = neuroneSortieOU.activer(entrees);
            System.out.println("Entrées: " + Arrays.toString(entrees) +
                               " Sortie calculée: " + sortieCalculee +
                               " Résultat attendu: " + echantillon.getResultatAttendu());
        }
    }
}
