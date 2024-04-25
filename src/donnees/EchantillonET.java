package donnees;

import java.util.Arrays;

public class EchantillonET extends Echantillon {
    public EchantillonET(double[] entrees, double resultatAttendu) {
        super(entrees, resultatAttendu);
    }

    @Override
    public String toString() {
        return "EchantillonET{" +
               "entrees=" + Arrays.toString(getEntrees()) +
               ", resultatAttendu=" + getResultatAttendu() +
               '}';
    }
}
