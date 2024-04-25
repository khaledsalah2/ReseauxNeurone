package couche;

public class CoucheEntree extends Couche {
    public CoucheEntree(int nombreNeurones) {
        super(nombreNeurones, TypeCouche.ENTREE);
    }

    @Override
    public void envoyerSignal() {
        // Logique spécifique pour envoyer des signaux depuis la couche d'entrée
    }
    
    public double[] traiterEntrees(double[] entrees) {
        // Dans une couche d'entrée, "traiter" pourrait simplement renvoyer les entrées.
        return entrees;
    }
}
