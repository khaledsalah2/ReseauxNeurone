package test;

import couche.*;
import neurone.*;
import reseau.*;
import echantillons.*;
import apprentissage.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // Création des couches
        CoucheEntree coucheEntree = new CoucheEntree(2, 2); // 2 neurones d'entrée
        CoucheCachee coucheCachee = new CoucheCachee(2, 2); // 2 neurones cachés
        CoucheSortie coucheSortie = new CoucheSortie(1, 2); // 1 neurone de sortie

        // Création du réseau de neurones
        ReseauDeNeurones reseau = new ReseauDeNeurones(coucheEntree, coucheCachee, coucheSortie);

        // Exemple d'échantillon
        double[] entrees = {1, 0};
        double[] sortiesSouhaitees = {1};
        Echantillon echantillon = new Echantillon(entrees, sortiesSouhaitees);

        // Apprentissage
        Apprentissage apprentissage = new Apprentissage(reseau);

        // Boucle d'entraînement
        for (int epoch = 0; epoch < 1000; epoch++) {
            double[] sorties = reseau.propagerAvant(entrees);
            double cout = apprentissage.calculerCout(echantillon, sorties);
            apprentissage.retropropager(echantillon, sorties, 0.1);
            if (epoch % 100 == 0) {
                System.out.println("Epoch " + epoch + ": Coût = " + cout);
            }
        }

        // Tester le réseau après l'entraînement
        double[] result = reseau.propagerAvant(entrees);
        System.out.println("Sorties après entraînement : " + Arrays.toString(result));
    }
}
