package couche;

import java.util.ArrayList;
import java.util.List;

import neurone.Neurone;

public abstract class Couche {
  protected List<Neurone> neurones;
  protected int nbNeurones;
  protected TypeCouche typeDeCouche;
  protected int nbPoidsParNeurone;
  
  
  public Couche(int nbNeurones, int nbPoidsParNeurone, TypeCouche typeDeCouche) {
	  this.nbNeurones = nbNeurones;
	  this.nbPoidsParNeurone = nbPoidsParNeurone;
	  this.neurones= new ArrayList<>();
	  this.typeDeCouche = typeDeCouche;
	  
	  for(int i = 0; i<nbNeurones; i++) {
		  Neurone neurone = creerNeurone();
		  initialiserNeurone(neurone);
		  neurones.add(neurone);
	  }
  }
  public abstract void initialiserNeurone(Neurone neurone);
  public abstract Neurone creerNeurone();
  
  public int getNbNeurones() {
	  return nbNeurones;
  }
  public List<Neurone> getNeurones(){
	  return neurones;
  }
  public int getNbPoidsParNeurone() {
	  return nbPoidsParNeurone;
  }
  
  public TypeCouche getTypeDeCouche() {
	  return typeDeCouche;
  }
 public void afficher() {
	 for(Neurone neurone : neurones) {
		 
	 }
 }
}
