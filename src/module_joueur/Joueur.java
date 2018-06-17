package module_joueur;

import APIMySQL.Utilisateur;

public class Joueur {

    int id;
    String pseudo;
    String email;

    public Joueur(int id, String pseudo, String email){
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getId() {
        return id;
    }

    public String getEmail(){
        return this.email;
    }

}
