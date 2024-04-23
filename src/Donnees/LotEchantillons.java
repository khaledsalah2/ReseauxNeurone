package Donnees;

import java.util.Arrays;

public class LotEchantillons {
    private Echantillon[] echantillons;

    public LotEchantillons(Echantillon[] echantillons) {
        this.echantillons = echantillons;
    }

    public void afficherEchantillons() {
        for (Echantillon echantillon : echantillons) {
            System.out.println("Entrées: " + Arrays.toString(echantillon.getEntrees()) +
                               " Sortie attendue: " + echantillon.getSortieAttendue());
        }
    }
}
