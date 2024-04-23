package couche;

import neurone.Neurone;
import neurone.NeuroneCachee;

public class CoucheCachee extends Couche {
    public CoucheCachee(int nbNeurones, int nbPoidsParNeurone,TypeCouche typeDeCouche) {
        super(nbNeurones, nbPoidsParNeurone, typeDeCouche.CoucheCache);
    }

    @Override
    public Neurone creerNeurone() {
        return new NeuroneCachee(getNbPoidsParNeurone());
    }

    @Override
    public void initialiserNeurone(Neurone neurone) {
        NeuroneCachee neuroneCache = (NeuroneCachee) neurone;
        for (int i = 0; i < getNbPoidsParNeurone(); i++) {
            double valeur = Math.random() * 2 - 1;
            neuroneCache.setPoids(i, valeur);
        }
        neuroneCache.setSeuil(Math.random() * 2 - 1);
    }
}