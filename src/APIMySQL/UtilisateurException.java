package APIMySQL;

import java.sql.SQLException;

public class UtilisateurException extends SQLException {
    private String cause;
    private String message;

    public UtilisateurException(String cause){
        super();
        this.cause = cause;
        setMessage();
    }

    private void setMessage(){
        if (this.cause.equals("unknownPseudo"))
            this.message = "Ce pseudo n'existe pas.";
        else if (this.cause.equals("pseudoTaken"))
            this.message = "Ce pseudo est déjà pris.";
        else
            this.message = "Erreur utilisateur.";
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
