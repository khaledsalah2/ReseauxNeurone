package neurone;

public class NeuroneEntree extends Neurone {
    public NeuroneEntree(double[] poids, double seuil) {
        super(poids, seuil);
    }

    @Override
    public double activer(double[] entrees) {
        // La fonction activer est la même que celle déjà définie.
        return super.activer(entrees);
    }
}
