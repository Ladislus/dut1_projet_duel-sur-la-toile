package module_joueur;

public class MessageModele {

    private long dateEnvoi;

    private String nomExp;
    private String nomDest;
    private String contenu;

    public MessageModele(String nomExp, String nomDest, long dateEnvoi, String contenu) {

        this.dateEnvoi = dateEnvoi;

        this.nomExp = nomExp;
        this.nomDest = nomDest;
        this.contenu = contenu; }

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
    }}