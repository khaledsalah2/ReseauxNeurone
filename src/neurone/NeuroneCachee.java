package neurone;


public class NeuroneCachee extends Neurone {
    private double delta; // Gradient pour la rétropropagation

    public NeuroneCachee(double[] poids, double seuil) {
        super(poids, seuil);
    }

    @Override
    public double activer(double[] entrees) {
        double somme = 0;
        for (int i = 0; i < entrees.length; i++) {
            somme += entrees[i] * poids[i];
        }
        derniereActivation = 1 / (1 + Math.exp(-somme)); // On stocke la dernière activation
        return derniereActivation;
    }
    
    public void calculerDelta(double erreur) {
        this.delta = erreur * derniereActivation * (1 - derniereActivation);
    }

    public void ajusterPoids(double tauxApprentissage, double[] entrees) {
        for (int i = 0; i < this.poids.length; i++) {
            this.poids[i] += tauxApprentissage * this.delta * entrees[i];
        }
        this.seuil -= tauxApprentissage * this.delta;
    }

    // Getter pour le delta
    public double getDelta() {
        return delta;
    }
}