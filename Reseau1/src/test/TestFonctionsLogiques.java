package test;

import couche.*;
import echantillons.Echantillon;
import echantillons.LotEchantillons;
import neurone.NeuroneBinaire;

public class TestFonctionsLogiques {
    public static void main(String[] args) throws Exception {
        // Test pour la logique ET
        testerFonctionLogique("ET", new double[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, new double[]{0, 0, 0, 1});

        // Test pour la logique OU
        testerFonctionLogique("OU", new double[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, new double[]{0, 1, 1, 1});

        // Test pour la logique NON
        testerFonctionLogique("NON", new double[][]{{0}, {1}}, new double[]{1, 0});

        // Test pour la logique XOR
        testerFonctionLogique("XOR", new double[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, new double[]{0, 1, 1, 0});

        // Test pour l'Implication
        testerFonctionLogique("Implication", new double[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, new double[]{1, 1, 0, 1});
    }

    private static void testerFonctionLogique(String type, double[][] entrees, double[] sortiesAttendues) throws Exception {
    	// 1 neurone avec 2 entrées pour la logique ET 
    	CoucheBinaire coucheSortie= new CoucheBinaire(1, entrees.length);
    	System.out.print(entrees[0].length);
    	      
    	NeuroneBinaire neurone =  ((NeuroneBinaire)coucheSortie.getNeurones()[0]);
//        NeuroneBinaire neurone = new NeuroneBinaire(entrees[0].length);
        switch (type) {
            case "ET":
                neurone.configurerPourET();
                break;
            case "OU":
                neurone.configurerPourOU();
                break;
            case "NON":
                neurone.configurerPourNON();
                break;
            case "XOR":
                neurone.configurerPourXOR();
                break;
            case "Implication":
                neurone.configurerPourImplication();
                break;
            default:
                throw new IllegalArgumentException("Type de fonction logique non reconnu: " + type);
        }

        LotEchantillons lot = new LotEchantillons();
        for (int i = 0; i < entrees.length; i++) {
            lot.ajouterEchantillon(new Echantillon(entrees[i], sortiesAttendues[i]));
        }

        System.out.println("Test de la fonction logique: " + type);
        boolean allTestsPassed = true;
        for (Echantillon echantillon : lot.getEchantillons()) {
            double sortie = neurone.activer(echantillon.getEntrees());
            boolean isCorrect = sortie == echantillon.getSortieSouhaitee();
            allTestsPassed &= isCorrect;
            System.out.println("Test entrées: " + java.util.Arrays.toString(echantillon.getEntrees())
                    + " - Sortie obtenue: " + sortie
                    + " - Sortie attendue: " + echantillon.getSortieSouhaitee()
                    + " - Résultat: " + (isCorrect ? "Correct" : "Incorrect"));
        }

        if (allTestsPassed) {
            System.out.println(type + ": Tous les tests ont passé avec succès.\n");
        } else {
            System.out.println(type + ": Certains tests ont échoué.\n");
        }
    }
}
