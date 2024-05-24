package test;

import java.util.Arrays;

import couche.CoucheSortie;
import echantillons.Echantillon;
import echantillons.LotEchantillons;
import reseau.ReseauDeNeurones;

public class TestBac1 {
	public static void main(String[] args) throws Exception {
		ReseauDeNeurones reseau = new ReseauDeNeurones(new CoucheSortie(1, 1));
		LotEchantillons lot = new LotEchantillons();
		// Coefficients pour chaque matière
		double[] coeffs = { 12, 16, 10, 8, 8 };

		// Notes des élèves [MATH, NSI, PC, SVT, SI]
		double[][] notes = { 
				{ 14, 10, 20, 15, 16 }, // HAL
				{ 7, 14, 2, 12, 8 }, // IBM
				{ 14, 13, 6, 4, 8 }, // JCN
				{ 6, 11, 16, 12, 20 }, // KDO
				{ 4, 12, 4, 18, 12 }, // LEP
				{ 9, 10.4, 8, 10, 13 }, // MFQ
				{ 10, 7.4, 6, 14, 16 }, // NGR
				{ 4, 8, 10, 12, 18 }, // OHS
				{ 5, 13, 5, 14, 12 }, // PIT
				{ 6, 19, 12, 8, 10 } // QJU
		};

		String[] resultats = { "AB", "P", "P", "P", "P", "P", "P", "R", "P", "AB" };

		// Convertir les résultats en valeurs numériques pour la classification
		int[] resultatsNumeriques = new int[resultats.length];
		for (int i = 0; i < resultats.length; i++) {
			switch (resultats[i]) {
			case "AB":
				resultatsNumeriques[i] = 1;
				break;
			case "P":
				resultatsNumeriques[i] = 0;
				break;
			case "R":
				resultatsNumeriques[i] = 2;
				break;
			default:
				resultatsNumeriques[i] = 0; // Gérer les cas inconnus ou ajouter plus de catégories si nécessaire
			}
		}

		// Remplir le lot d'échantillons
		for (int i = 0; i < notes.length; i++) {
			double moyennePonderee = 0;
			for (int j = 0; j < notes[i].length; j++) {
				moyennePonderee += notes[i][j] * coeffs[j];
			}
			moyennePonderee /= 54; // Total des coefficients
			double[] entrees = { moyennePonderee / 20 }; // Normalisation

			// Création de l'échantillon
			lot.ajouterEchantillon(new Echantillon(entrees, resultatsNumeriques[i]));
		}

		// Utilisation du lot pour l'entraînement ou le test
		for (Echantillon echantillon : lot.getEchantillons()) {
			double[] sorties = reseau.propagerAvant(echantillon.getEntrees());
			double prediction = sorties[0];
			System.out.println("Prédiction: " + (prediction > 0.5 ? "Réussi" : "Échoué") + ", Attendu: "
					+ (echantillon.getSortieSouhaitee() > 0.5 ? "Réussi" : "Échoué"));
		}
	}
}