package couche;

public abstract class Couche {
    protected int nombreNeurones;
    protected TypeCouche type;

    public Couche(int nombreNeurones, TypeCouche type) {
        this.nombreNeurones = nombreNeurones;
        this.type = type;
    }

    public abstract void envoyerSignal();
}
