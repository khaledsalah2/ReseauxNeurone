package neurone;

public abstract class Neurone {
	 protected double[] poids;
	 protected double seuil;
	 
	 public Neurone(int nbNeuronesSuivantes) {
		 poids = new double[nbNeuronesSuivantes];
		 seuil = 0.0;
	 }
	 
	 public void setPoids(int index, double poids) {
		 this.poids[index]=poids;
	 }
	 public double[] getPoids() {
		 return this.poids;
	 }
	 
	 public void setSeuil(double seuil) {
		 this.seuil = seuil;
	 }
	 public double getSeuil() {
		 return this.seuil;
	 }
	 
	 public abstract double CalculerValeur(double[] entrees);
}
