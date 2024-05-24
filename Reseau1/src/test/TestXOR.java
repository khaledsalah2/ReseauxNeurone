package test;

import apprentissage.Apprentissage;
import echantillons.Echantillon;
import echantillons.LotEchantillons;
import reseau.ReseauXOR;

public class TestXOR {
    public static void main(String[] args) {
        try {
            // Initialisation du réseau XOR
            ReseauXOR reseau = new ReseauXOR();
            Apprentissage apprentissage = new Apprentissage(reseau);

            // Définition des entrées et des sorties attendues
            double[][] entrees = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
            double[] sortiesSouhaitees = {0, 1, 1, 0};

            // Création du lot d'échantillons avec sorties attendues sous forme de tableau
            LotEchantillons lot = new LotEchantillons();
            for (int i = 0; i < entrees.length; i++) {
                double[] sortieSouhaiteeArray = {sortiesSouhaitees[i]}; // Conversion en tableau
                lot.ajouterEchantillon(new Echantillon(entrees[i], sortieSouhaiteeArray));
            }

            // Test initial du réseau XOR
            System.out.println("Test initial du réseau XOR:");
            for (Echantillon echantillon : lot.getEchantillons()) {
                double[] sortie = reseau.propagerAvant(echantillon.getEntrees());
                double cout = apprentissage.calculerCout(echantillon, sortie);
                System.out.println("Entrée: " + java.util.Arrays.toString(echantillon.getEntrees()) +
                                   " - Sortie: " + java.util.Arrays.toString(sortie) +
                                   " - Coût: " + cout);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
