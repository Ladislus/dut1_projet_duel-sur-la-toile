package module_joueur;

public class Joueur {

    private int id;

    private String pseudo;
    private String email;

    public Joueur(int id, String pseudo, String email) {

        this.id = id;

        this.pseudo = pseudo;
        this.email = email; }

    public String getPseudo() { return this.pseudo; }

    public int getId() { return this.id; }

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    public void setPseudo(String pseudo) { this.pseudo = pseudo; }}
