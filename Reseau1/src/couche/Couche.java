package couche;

import neurone.*;

public abstract class Couche {
    protected Neurone[] neurones;

    public Couche(int nombreNeurones, int nombreEntrees, Class<? extends Neurone> classeNeurone) throws Exception {
        this.neurones = new Neurone[nombreNeurones];
        for (int i = 0; i < nombreNeurones; i++) {
            this.neurones[i] = classeNeurone.getDeclaredConstructor(int.class).newInstance(nombreEntrees);
        }
    }

    public abstract double[] traiterEntrees(double[] entrees);
    
    public Neurone[] getNeurones() {
        return neurones;
    }

}