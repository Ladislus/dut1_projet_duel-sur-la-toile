package module_joueur;

public class Jeu {

    private String title;

    byte[] image;

    String regle;

    public Jeu(String title, byte[] image, String regle){
        this.title = title;
        this.image = image;
        this.regle = regle;
    }

    public byte[] getImage(){
        return this.image;
    }

    public String getRegle() {
        return regle;
    }

    public void setRegle(String regle) {
        this.regle = regle;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }}
