package module_mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resultat { // Modèle des résultats du mastermind

     /**Un résultat est une combinaison spéciale. Pour chacun des 4 éléments:
     *         0 signifie "Mauvais pion"
     *         1 signifie "Pion présent et bien placé"
     *         2 signifie "Pion présent mais mal placé"
     */
    public static Combinaison compare(Combinaison rep,Combinaison essai){
        Combinaison courant = essai;
        Combinaison resultat = new Combinaison(rep);
//        System.out.println(rep);
        List<Integer> listeIndices = new ArrayList<>();

        for (int i=0;i<resultat.size();i++){ // On regarde d'abord les pions bien placés
            int p = courant.get(i);
            if (p == resultat.get(i)){
                listeIndices.add(1);
                courant.remove(i);
                resultat.remove(i);
            }
        }

        for (int i=0;i<resultat.size();i++){ // Puis on regarde les pions mal placés
            int p = courant.get(i);
            if (p!=0 && resultat.contains(p)){
                listeIndices.add(2);
                resultat.removePion(p);
                courant.removePion(p);
            }
        }
//        for (int i = 0; i < 4; i++){
//            Integer p = courant.get(i);
//            if (p.equals(resultat.get(i))){
//                listeIndices.add(1);
//            } else if (resultat.contains(p) && !p.equals(resultat.get(i))){
//                listeIndices.add(2);
//            } else {
//                listeIndices.add(0);
//            }
//        }

        Collections.shuffle(listeIndices);

        Combinaison res = new Combinaison();
        for (int p : listeIndices){
            res.addPion(p);
        }
//        System.out.println(res);
        return res;
    }

}
