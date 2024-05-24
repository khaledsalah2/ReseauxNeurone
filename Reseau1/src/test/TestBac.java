package test;

import java.util.Arrays;

import couche.CoucheSortie;
import reseau.ReseauDeNeurones;

public class TestBac {
    public static void main(String[] args) throws Exception {
		ReseauDeNeurones reseau = new ReseauDeNeurones(new CoucheSortie(1, 1));
        // Coefficients pour chaque matière
        double[] coeffs = {12, 16, 10, 8, 8};

        // Notes des élèves [MATH, NSI, PC, SVT, SI]
        double[][] notesEleves = {
            {14, 10, 20, 15, 16}, // HAL
            {7, 14, 2, 12, 8},   // IBM
            {14, 13, 6, 4, 8},   // JCN
            {6, 11, 16, 12, 20}, // KDO
            {4, 12, 4, 18, 12},  // LEP
            {9, 10.4, 8, 10, 13},// MFQ
            {10, 7.4, 6, 14, 16},// NGR
            {4, 8, 10, 12, 18},  // OHS
            {5, 13, 5, 14, 12},  // PIT
            {6, 19, 12, 8, 10}   // QJU
        };

        // Calcul des moyennes pondérées et normalisation
        for (double[] notes : notesEleves) {
            double moyennePonderee = 0;
            for (int i = 0; i < notes.length; i++) {
                moyennePonderee += notes[i] * coeffs[i];
            }
            moyennePonderee /= Arrays.stream(coeffs).sum(); // Somme des coefficients
            double normalizedScore = moyennePonderee / 20;  // Normalisation sur 20

            // Prédiction avec le réseau (simulation)
            double prediction = reseau.propagerAvant(new double[]{normalizedScore})[0]; // Assume que cela est votre méthode de prédiction
            //double prediction = normalizedScore > 0.5 ? 1 : 0; // Simulé ici comme une prédiction simple
            System.out.println("Prédiction pour une moyenne de " + moyennePonderee + " : " + (prediction > -1 ? "Réussi" : "Échoué"));
        }
    }
}
