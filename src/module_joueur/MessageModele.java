package module_joueur;

import java.text.SimpleDateFormat;

import java.util.Date;

public class MessageModele {

    private long dateEnvoi;

    private String nomExp;
    private String nomDest;
    private String contenu;

    /**
     Entité représentant les messages de la messagerie
     @param nomExp : Le nom de l'expéditeur
     @param nomDest : Le nom du destinataire
     @param dateEnvoi : La date d'envoie (long)
     @param contenu : Le contenu du message
    */
    MessageModele(String nomExp, String nomDest, long dateEnvoi, String contenu) {

        this.dateEnvoi = dateEnvoi;

        this.nomExp = nomExp;
        this.nomDest = nomDest;
        this.contenu = contenu; }

    String getNomExp() { return nomExp; }

    public String getNomDest() { return nomDest; }

    long getDateEnvoi() { return dateEnvoi; }

    String getDateEnvoiString() { return String.valueOf(new SimpleDateFormat("HH:mm:ss '-' dd/MM/yy").format(new Date(this.dateEnvoi))); }

    public String getContenu() { return contenu; }}
