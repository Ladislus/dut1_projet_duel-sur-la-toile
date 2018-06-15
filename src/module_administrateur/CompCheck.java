package module_administrateur;

import java.util.Comparator;

public class CompCheck implements Comparator<Rapport> {
    public int compare(Rapport c1, Rapport c2) {
        if (c1.getLu() && !(c2.getLu())) {
            return 1;
        }
        else if (!(c1.getLu()) && c2.getLu()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
