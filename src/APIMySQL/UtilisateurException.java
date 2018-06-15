package APIMySQL;

import java.sql.SQLException;

public class UtilisateurException extends SQLException {
    private String cause;
    private String message;

    public UtilisateurException(String cause){
        super();
        this.cause = cause;
        init();
    }

    private void init(){
        if (this.cause.equals("unknownPseudo")){
            this.message = "Ce pseudo n'existe pas.";
        }
    }

    public String getMessage() {
        return message;
    }
}
