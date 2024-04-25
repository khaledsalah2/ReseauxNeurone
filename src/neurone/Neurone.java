package neurone;

public abstract class Neurone {
    protected double[] poids;
    protected double seuil;

    public Neurone(double[] poids, double seuil) {
        this.poids = poids;
        this.seuil = seuil;
    }

    public abstract double activer(double[] entrees);
}
