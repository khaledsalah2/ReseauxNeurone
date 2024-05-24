
package echantillons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LotEchantillons {
    private List<Echantillon> echantillons;

    public LotEchantillons() {
        this.echantillons = new ArrayList<>();
    }

    public void ajouterEchantillon(Echantillon echantillon) {
        this.echantillons.add(echantillon);
    }

    public List<Echantillon> getEchantillons() {
        return echantillons;
    }
    
    
    public void afficherEchantillons() {
        for (Echantillon echantillon : echantillons) {
            System.out.println("Entrées: " + Arrays.toString(echantillon.getEntrees()) + ", Sortie attendue: " + echantillon.getSortieSouhaitee());
        }
    }


}