package reseau;

import donnees.Echantillon;
import donnees.EchantillonNON;
import donnees.LotsEchantillons;
import neurone.NeuroneSortie;

import java.util.Arrays;

public class TestFonctionBinaireNON {
    public static void main(String[] args) {
        // Création des échantillons pour la fonction NON
        LotsEchantillons lotsNON = new LotsEchantillons();
        lotsNON.ajouterEchantillon(new EchantillonNON(new double[]{0}, 1));
        lotsNON.ajouterEchantillon(new EchantillonNON(new double[]{1}, 0));

        // Configuration du neurone de sortie pour la fonction NON
        NeuroneSortie neuroneSortieNON = new NeuroneSortie(new double[]{-2}, -1);

        // Test du réseau pour la fonction NON
        System.out.println("Test du réseau pour la fonction NON:");
        for (Echantillon echantillon : lotsNON.getEchantillons()) {
            double[] entrees = echantillon.getEntrees();
            double sortieCalculee = neuroneSortieNON.activer(entrees);
            System.out.println("Entrée: " + Arrays.toString(entrees) +
                               " Sortie calculée: " + sortieCalculee +
                               " Résultat attendu: " + echantillon.getResultatAttendu());
        }
    }
}
