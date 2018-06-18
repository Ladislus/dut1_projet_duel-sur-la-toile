package module_joueur;

import APIMySQL.Utilisateur;

public class Joueur {

    int id;

    String pseudo;
    String email;

    public Joueur(int id, String pseudo, String email) {

        this.id = id;
        this.pseudo = pseudo;
        this.email = email; }

    public String getPseudo() { return this.pseudo; }

    public int getId() { return this.id; }

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    public void setId(int id) { this.id = id; }

    public void setPseudo(String pseudo) { this.pseudo = pseudo; }}
