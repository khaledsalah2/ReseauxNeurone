package donnees;

import java.util.ArrayList;
import java.util.List;

public class LotsEchantillons {
    private List<Echantillon> echantillons;

    public LotsEchantillons() {
        this.echantillons = new ArrayList<>();
    }

    public void ajouterEchantillon(Echantillon echantillon) {
        echantillons.add(echantillon);
    }

    public List<Echantillon> getEchantillons() {
        return echantillons;
    }
}
