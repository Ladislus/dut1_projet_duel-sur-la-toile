package module_joueur;

public class MessageModele {

    private String nomExp,nomDest;

    private long dateEnvoi;

    private String contenu;


    public MessageModele(String nomExp, String nomDest, long dateEnvoi, String contenu) {
        this.nomExp = nomExp;
        this.nomDest = nomDest;
        this.dateEnvoi = dateEnvoi;
        this.contenu = contenu;
    }

    public String getNomExp() {
        return nomExp;
    }

    public String getNomDest() {
        return nomDest;
    }

    public long getDateEnvoi() {
        return dateEnvoi;
    }

    public String getContenu() {
        return contenu;
    }

}
