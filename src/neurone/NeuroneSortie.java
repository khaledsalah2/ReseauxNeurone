package neurone;

public class NeuroneSortie extends Neurone {
    private double delta; // Gradient pour la rétropropagation
    public NeuroneSortie(double[] poids, double seuil) {
        super(poids, seuil);
    }

    @Override
    public double activer(double[] entrees) {
        double somme = 0;
        for (int i = 0; i < entrees.length; i++) {
            somme += entrees[i] * poids[i];
        }
        return somme > seuil ? 1 : 0; // Pour une sortie binaire, on utilise une fonction seuil.
    }
}
