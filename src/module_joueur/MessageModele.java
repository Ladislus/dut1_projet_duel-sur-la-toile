package module_joueur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public String getDateEnvoiString(){
        Date date = new Date(this.dateEnvoi);
        return String.valueOf(new SimpleDateFormat("HH:mm:ss '-' dd/MM/yy").format(date));
    }

    public String getContenu() {
        return contenu;
    }}
