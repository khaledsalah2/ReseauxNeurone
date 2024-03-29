package ReseauxNeurones;

import java.util.List;

public class CoucheEntree extends Couche{

	public CoucheEntree(int nbNeurones, int nbPoidsParNeurone, TypeCouche typeDeCouche) {
		super(nbNeurones, nbPoidsParNeurone, typeDeCouche.CoucheEntree);
	}
	public Neurone creerNeurone() {
		return new NeuroneEntree(getNbPoidsParNeurone());
	}
	@Override
	public void initialiserNeurone(Neurone neurone) {
		NeuroneEntree neuroneEntree = (NeuroneEntree) neurone;
		
		for (int i = 0; i < getNbPoidsParNeurone(); i++) {
			double valeur = Math.random();
			neuroneEntree.setPoids(i, valeur);
		}
		
	}
}
