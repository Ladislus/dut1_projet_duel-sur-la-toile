package APIMySQL;

import java.sql.SQLException;

public class APIMySQLException extends SQLException {
    private String cause;
    private String message;

    /**
     * Exception permettant de signaler plus clairement
     * un problème au niveau de l'API MySQL
     * @param cause
     */
    public APIMySQLException(String cause){
        super();
        this.cause = cause;
        setMessage();
    }

    /**
     * Fonction qui permet de mettre en place un message
     * d'erreur compréhensible facilement par un utilisateur
     */
    private void setMessage(){
        if (this.cause.equals("unknownPseudo"))
            this.message = "Ce pseudo n'existe pas.";
        else if (this.cause.equals("pseudoTaken"))
            this.message = "Ce pseudo est déjà pris.";
        else if (this.cause.equals("gameNameTaken"))
            this.message = "Ce nom de jeu est déjà pris";
        else if (this.cause.equals("unkownIdUt"))
            this.message = "Ce numéro d'utilisateur n'existe pas.";
        else
            this.message = "Erreur inconnue.";
    }

    /**
     * Retourne le message d'erreur courant
     * @return message
     */
    public String getMessage() {
        return message;
    }

    public void printMessage() {}}
