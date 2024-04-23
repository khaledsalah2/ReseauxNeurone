package couche;

import neurone.Neurone;
import neurone.NeuroneSortie;

public class CoucheSortie extends Couche {
    public CoucheSortie(int nbNeurones, int nbPoidsParNeurone, TypeCouche typeDeCouche) {
        super(nbNeurones, nbPoidsParNeurone, typeDeCouche.CoucheSortie);
    }

    @Override
    public Neurone creerNeurone() {
        return new NeuroneSortie();
    }

    @Override
    public void initialiserNeurone(Neurone neurone) {
        NeuroneSortie neuroneSortie = (NeuroneSortie) neurone;
        for (int i = 0; i < getNbPoidsParNeurone(); i++) {
            double valeur = Math.random() * 2 - 1;
            neuroneSortie.setPoids(i, valeur);
        }
        neuroneSortie.setseuil(Math.random());
    }
}
